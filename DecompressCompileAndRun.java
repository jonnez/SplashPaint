import javax.tools.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

class DecompressCompileAndRun extends SimpleJavaFileObject
{
    public DecompressCompileAndRun()
    {
        super(URI.create(""),Kind.SOURCE);
    }

    public static void main(String args[]) throws Exception
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.getTask(null, null, null, null, null, Arrays.asList(new DecompressCompileAndRun())).call();
        Class.forName("S").getDeclaredMethod("main", new Class[] { String[].class })
            .invoke(null, new Object[]{null});
    }

    @Override
    public String getCharContent(boolean ignoreEncodingErrors)
    {
        try
        {
            // De System.out.println hieronder print een string die we direct in de 'encoded' variabele gaan
            // stoppen in de minified versie van deze class.
            String encoded = zipAndBase64Encode();
            System.out.println("Gezipte en Base64 encoded versie van S.java (len=" + encoded.length() + "): " + encoded);
            // Of we gebruiken: gzip -c S.java | openssl base64
            // of: zip - S.java | openssl base64

            ByteArrayInputStream byteStream = new ByteArrayInputStream(Base64.getDecoder().decode(encoded));
            byte[] sJava = new byte[797]; // array size is file size of S.java
            new GZIPInputStream(byteStream).read(sJava);
            return new String(sJava);
        }
        catch (Exception e)
        {
            // wie weet komt dit hier nog van pas:
            e.printStackTrace();
            return null;
        }
    }

    // Deze methode kan weg in de minified versie
    String zipAndBase64Encode() throws Exception
    {
        // Lees S.java
        byte[] sJava = Files.readAllBytes(Paths.get(new File("S.java").toURI()));
        // Zip data
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GZIPOutputStream zipStream = new GZIPOutputStream(outputStream);
        zipStream.write(sJava);
        zipStream.close();
        // return Base64 encodering
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}
