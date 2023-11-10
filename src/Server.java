import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket serSock=new ServerSocket(12345);
            System.out.println("Server listening on port: 12345");

            while(true){
                Socket c=serSock.accept();
                System.out.println("Client connected: "+c.getInetAddress().getHostAddress());

                BufferedReader reader=new BufferedReader(new InputStreamReader(c.getInputStream()));
                PrintWriter writer=new PrintWriter(c.getOutputStream(),true);

                //reading message from client
                String message=reader.readLine();
                System.out.println("Message received from client: "+message);

                //sending response to client
                String response="Server says: Hi, Client.";
                writer.println(response);

                reader.close();
                writer.close();
                c.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
