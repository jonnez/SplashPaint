import java.util.*;
import java.util.stream.*;

class S1
{
    int p[]=new int[196],x=14;
    List c=new Vector(),s;

    public static void main(String[]_)
    {
        new S1();
    }

    @SuppressWarnings("unchecked")
    S1()
    {
        Scanner a=new Scanner(System.in).useDelimiter(",");

        while(a.hasNext())p[x%14==12?x+=3:++x]=a.next().indexOf("X")+1;

        for(x=0;x<196;x++)
        {
            c.clear();
            f(x%14,x/14);
            if(!c.isEmpty()&(s==null||c.size()<s.size()))
                s=new Vector(c);
        }

        System.out.println(s==null?"0":s.size()+" => "+s.stream().sorted().
            map(Object::toString).
            collect(Collectors.joining(", ")));
    }

    @SuppressWarnings("unchecked")
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

    class P implements Comparable<P>
    {
        int k,v;

        P(int x,int y)
        {
            k=x;
            v=y;
        }
        public int compareTo(P o)
        {
            return 99*(v-o.v)+k-o.k;
        }

        public String toString()
        {
            return "("+(k-1)+", "+(v-1)+")";
        }

        public boolean equals(Object o)
        {
            return ((P)o).k==k&((P)o).v==v;
        }
    }
}