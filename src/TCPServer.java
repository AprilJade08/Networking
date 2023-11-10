import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serSock=new ServerSocket(4000);
        System.out.println("Server listening on port : 4000");
        Socket c=serSock.accept();
        System.out.println("Client connected : "+c.getInetAddress().getHostAddress());

        BufferedReader br=new BufferedReader(new InputStreamReader(c.getInputStream()));
        String fname=br.readLine();

        PrintWriter writer=new PrintWriter(c.getOutputStream(),true);
        BufferedReader reader=new BufferedReader(new FileReader(fname));
        String str;
        while((str=reader.readLine())!=null){
            writer.println(str);
        }

        reader.close();
        writer.close();
        br.close();
        c.close();
        serSock.close();
    }
}
