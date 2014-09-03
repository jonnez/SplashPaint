import javafx.util.*;
import java.util.*;
import java.util.stream.*;

class SplashPaint
{
    // Array p is een 14x14 array die het schilderij bevat. Er zit een extra rand om het schilderij heen,
    // altijd met waarde 'false', zodat we geen index checking hoeven te doen. Het flood fill algoritme
    // doet namelijk niets als het op een veld komt met waarde 'false'.
    static boolean p[] = new boolean[196];
    static Set c = new LinkedHashSet(), s;

    public static void main(String[]_)
    {
        // We lezen stdin met een Scanner
        Scanner a = new Scanner(System.in).useDelimiter(",");
        int x = 14, y = 0;

        // Vullen van de 'painting' array
        while (a.hasNext())
            p[x % 14 == 12 ? x += 3 : ++x] = a.next().contains("X");

        // Vanuit elk coordinaat starten we het flood fill algoritme, dat de collectie 'c' vult
        // met alle verfvlek coordinaten. Merk op dat de volgorde van iteratie (eerst y, dan x) in combinatie
        // met het alleen overschrijven van de uiteindelijke oplossing 's' als deze beter is er toe leidt
        // dat we de gewenste oplossing eerst vinden. Uiteraard doen we geen enkele karaktervretende optimalisatie.
        for (; y < 14; y++)
            for (x = 0; x < 14; x++)
            {
                c.clear();
                flood(x, y);
                if (!c.isEmpty() && (s == null || c.size() < s.size()))
                {
                    s = new LinkedHashSet(c);
                }
            }

        System.out.println(s.size() + " => " + s.stream().
            map(e->"("+((int)((Pair)e).getKey()-1)+", "+((int)((Pair)e).getValue()-1)+")").
            collect(Collectors.joining(", ")));
    }

    static void flood(int x, int y)
    {
        if (p[14*y+x])
        {
            c.add(new Pair(x, y));

            // Note that we rely on the collection to be a LinkedHashSet. The iteration is done in
            // such order that we do not need to sort the collection later.
            for (int u = y-1; u < y+2; u++)
                for (int v = x-1; v < x+2; v++)
                    if (!c.contains(new Pair(v, u)))
                        flood(v, u);
        }
    }
}
