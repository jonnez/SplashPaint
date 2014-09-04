import javafx.util.*;
import java.util.*;
import java.util.stream.*;

class SplashPaint
{
    // Array p is een 14x14 array die het schilderij bevat. Er zit een extra rand om het schilderij heen,
    // altijd met waarde 'false', zodat we geen index checking hoeven te doen. Het flood fill algoritme
    // doet namelijk niets als het op een veld komt met waarde 'false'.
    static int p[] = new int[196],
        x = 14; // eigenlijk locale variabele voor 'main' methode.
    // Ooit gedacht wat het voordeel was van Vector? (het is minder typen dan ArrayList)
    static List c = new Vector(), s;

    @SuppressWarnings("unchecked")
    public static void main(String[]_)
    {
        // We lezen stdin met een Scanner
        Scanner a = new Scanner(System.in).useDelimiter(",");

        // Vullen van de 'painting' array
        while (a.hasNext())
            p[x % 14 == 12 ? x += 3 : ++x] = a.next().indexOf("X")+1;

        // Vanuit elk coordinaat starten we het flood fill algoritme, dat de collectie 'c' vult
        // met alle verfvlek coordinaten.
        // De volgorde van itereren is van belang zodat we later geen karakters kwijtraken aan sorteren.
        // Ooit was dit iets beter leesbaar, maar een dubbele for-loop (buitenste loop y, binnenste loop x)
        // heeft plaatst gemaakt voor een enkele die hetzelfde doet. Deze volgorde, in combinatie
        // met het alleen overschrijven van de uiteindelijke oplossing 's' als deze beter is er toe leidt
        // dat we de gewenste oplossing eerst vinden.
        // Uiteraard doen we verder geen enkele karaktervretende optimalisatie.
        for (x=0; x<196; x++)
        {
            c.clear();
            flood(x%14, x/14);
            if (!c.isEmpty() & (s == null || c.size() < s.size()))
                s = new Vector(c);
        }

        // Hier drukken we de oplossing af. Deze kan "0" zijn als er geen verfvlekken zijn.
        System.out.println(s == null ? "0" : s.size() + " => " + s.stream().
            map(e->"("+((int)((Pair)e).getKey()-1)+", "+((int)((Pair)e).getValue()-1)+")").
            collect(Collectors.joining(", ")));
    }

    @SuppressWarnings("unchecked")
    static void flood(int x, int y)
    {
        if (p[14*y+x]!=0)
        {
            c.add(new Pair(x, y));

            // Iteratie is weer in juiste volgorde zodat verzameling 'c' later niet
            // nog eens gesorteerd hoeft te worden.
            for (int i = 0; i < 9; i++)
                if (!c.contains(new Pair(i/3-1+x, i%3-1+y)))
                    flood(i/3-1+x, i%3-1+y);
        }
    }
}
