import javafx.util.*;import java.util.*;import java.util.stream.*;class S{static boolean p[]=new boolean[196];static Set c=new LinkedHashSet(),s;public static void main(String[]_){Scanner a=new Scanner(System.in).useDelimiter(",");int x=14;while(a.hasNext())p[x%14==12?x+=3:++x]=a.next().contains("X");for(x=0;x<196;x++){c.clear();flood(x%14,x/14);if(!c.isEmpty()&(s==null||c.size()<s.size()))s=new LinkedHashSet(c);}System.out.println(s.size()+" => "+s.stream().map(e->"("+((int)((Pair)e).getKey()-1)+", "+((int)((Pair)e).getValue()-1)+")").collect(Collectors.joining(", ")));}static void flood(int x,int y){if(p[14*y+x]){c.add(new Pair(x,y));for(int i=0;i<9;i++)if(!c.contains(new Pair(i/3-1+x,i%3-1+y)))flood(i/3-1+x,i%3-1+y);}}}
