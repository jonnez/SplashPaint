import java.util.*;

// Dit is een variant van SplashPaint, die geen main methode heeft.
// Ook is alvast het meeste commentaar en whitespace verwijderd.
class SplashPaintZonderMain
{
    int p[]=new int[196],x=14;
    List c=new Vector(),s;
    Scanner a=new Scanner(System.in).useDelimiter(",");

    SplashPaintZonderMain()
    {
        while(a.hasNext())
            p[x%14==12?x+=3:++x]=a.next().indexOf("X")+1;

        for(x=0;x<196;x++)
        {
            c.clear();
            f(x%14,x/14);
            if(!c.isEmpty()&(s==null||c.size()<s.size()))
                s=new Vector(c);
        }

        System.out.println(s==null?"0":s.size()+" => "+s.stream().
            sorted((e,f)->99*(((P)e).y-((P)f).y)+((P)e).x-((P)f).x).
            map(e->"("+(((P)e).x-1)+", "+(((P)e).y-1)+")").
            collect(java.util.stream.Collectors.joining(", ")));
    }

    void f(int x,int y)
    {
        if(p[14*y+x]!=0)
        {
            c.add(new P(x,y));

            for(int i=0;i<9;i++)
                if(!c.contains(new P(i/3-1+x,i%3-1+y)))
                    f(i/3-1+x,i%3-1+y);
        }
    }

    class P
    {
        int x,y;

        P(int u,int v)
        {
            x=u;
            y=v;
        }

        public boolean equals(Object o)
        {
            return x==((P)o).x&&y==((P)o).y;
        }
    }
}