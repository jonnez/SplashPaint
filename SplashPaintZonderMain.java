import javafx.util.*;
import java.util.*;
import java.util.stream.*;

class SplashPaintZonderMain
{
    // Dit is een variant van SplashPaint, die geen main methode heeft.
    // Bijkomend voordeel is dat 'static' weg kan. Daarnaast heb ik ook alvast wat
    // commentaar verwijderd.

    int p[] = new int[196], x = 14;
    List c = new Vector(), s;

    @SuppressWarnings("unchecked")
    SplashPaintZonderMain()
    {
        Scanner a = new Scanner(System.in).useDelimiter(",");

        while (a.hasNext())
            p[x % 14 == 12 ? x += 3 : ++x] = a.next().indexOf("X")+1;

        for (x=0; x<196; x++)
        {
            c.clear();
            flood(x%14, x/14);
            if (!c.isEmpty() & (s == null || c.size() < s.size()))
                s = new Vector(c);
        }

        System.out.println(s == null ? "0" : s.size() + " => " + s.stream().
            map(e->"("+((int)((Pair)e).getKey()-1)+", "+((int)((Pair)e).getValue()-1)+")").
            collect(Collectors.joining(", ")));
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
