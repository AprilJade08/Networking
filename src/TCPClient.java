import java.io.*;
import java.net.*;
import java.nio.Buffer;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        Socket c=new Socket("127.0.0.1",4000);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter filename : ");
        String fname=br.readLine();

        PrintWriter writer=new PrintWriter(c.getOutputStream(),true);
        writer.println(fname);

        BufferedReader reader=new BufferedReader(new InputStreamReader(c.getInputStream()));
        String str;
        while((str=reader.readLine())!=null){
            System.out.println(str);
        }

        br.close();
        writer.close();
        reader.close();
        c.close();
    }
}
