import java.util.*;

class S1
{
    int p[] = new int[196], x = 14;
    List c = new Vector(), s;
    Scanner a = new Scanner(System.in).useDelimiter(",");

    public static void main(String[]_){new S();}
    S1()
    {
        for (;x<180;)
            p[x % 14 == 12 ? x += 3 : ++x] = a.next().indexOf(88)+1;

        for (x=0; x<196; x++)
        {
            c.clear();
            f(x % 14, x / 14);
            if (!c.isEmpty() & (s == null || c.size() < s.size()))
                s = new Vector(c);
        }

        System.out.println(s == null ? 0 : s.size() + " => " + s.stream().
            sorted((e,f) -> 99*(((P1)e).y-((P1)f).y)+((P1)e).x-((P1)f).x).
            map(e->"("+(((P1)e).x-1)+", "+(((P1)e).y-1)+")").
            collect(java.util.stream.Collectors.joining(", ")));
    }

    void f(int x, int y)
    {
        if (p[14*y+x]!=0)
        {
            c.add(new P1(x, y));

            for (int i = 0; i < 9; i++)
                if (!c.contains(new P1(i/3-1+x, i%3-1+y)))
                    f(i / 3 - 1 + x, i % 3 - 1 + y);
        }
    }

    class P1
    {
        int x, y;

        P1(int u, int v)
        {
            x = u;
            y = v;
        }

        public boolean equals(Object o)
        {
            return x==((P)o).x && y==((P)o).y;
        }
    }
}