import java.util.*;

// TODO: still need to verify if System.in.read() can beat Scanner

class SplashPaint
{
    // Array p is een 14x14 array die het schilderij bevat. Er zit een extra rand om het schilderij heen,
    // altijd met waarde 'false', zodat we geen index checking hoeven te doen. Het flood fill algoritme
    // doet namelijk niets als het op een veld komt met waarde 'false'.
    int p[] = new int[196],
        x = 14; // eigenlijk locale variabele voor 'main' methode.
    // Ooit gedacht wat het voordeel was van Vector? (het is minder typen dan ArrayList)
    List c = new Vector(), s;
    // We lezen stdin met een Scanner
    Scanner a = new Scanner(System.in).useDelimiter(",");

    @SuppressWarnings("unchecked")
    public static void main(String[]_)
    {
        new SplashPaint();
    }

    SplashPaint()
    {
        // Vullen van de 'painting' array (88 = 'X')
        for (;x<180;)
            p[x % 14 == 12 ? x += 3 : ++x] = a.next().indexOf(88)+1;

        // Vanuit elk coordinaat starten we het flood fill algoritme, dat de collectie 'c' vult
        // met alle verfvlek coordinaten.
        // De volgorde van itereren zorgt ervoor dat de gewenste oplossing eerst gevonden wordt.
        // Uiteraard doen we verder geen enkele karaktervretende optimalisatie.
        for (x=0; x<196; x++)
        {
            c.clear();
            flood(x%14, x/14);
            if (!c.isEmpty() & (s == null || c.size() < s.size()))
                s = new Vector(c);
        }

        // Hier drukken we de oplossing af.
        // - We moeten sorteren eerst op y (value) en dan op x (key).
        // - Formattering van coordinaten moet zijn: "size => (x1, y1), (x2, y2)",
        //   we kunnen dus niet simpelweg toString op een array of collection doen, want
        //   dan zouden we haken om de coordinaten krijgen.
        // - Aanname is dat we "0" moeten printen als er geen verfvlekken zijn.
        System.out.println(s == null ? 0 : s.size() + " => " + s.stream().
            sorted((e,f) -> 99*(((Pair)e).y-((Pair)f).y)+((Pair)e).x-((Pair)f).x).
            map(e->"("+(((Pair)e).x-1)+", "+(((Pair)e).y-1)+")").
            collect(java.util.stream.Collectors.joining(", ")));
    }

    @SuppressWarnings("unchecked")
    void flood(int x, int y)
    {
        if (p[14*y+x]!=0)
        {
            c.add(new Pair(x, y));

            for (int i = 0; i < 9; i++)
                if (!c.contains(new Pair(i/3-1+x, i%3-1+y)))
                    flood(i/3-1+x, i%3-1+y);
        }
    }
}

class Pair
{
    int x, y;

    Pair(int u, int v)
    {
        x = u;
        y = v;
    }

    // Vector.contains() maakt gebruik van deze equals() methode om te kijken of het object al
    // in de vector zit - de contains() aanroep zit in de flood() methode.
    public boolean equals(Object o)
    {
        return x==((Pair)o).x && y==((Pair)o).y;
    }
}