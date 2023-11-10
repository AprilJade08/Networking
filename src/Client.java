import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        try{
            Socket c=new Socket("127.0.0.1",12345);

            BufferedReader reader=new BufferedReader(new InputStreamReader(c.getInputStream()));
            PrintWriter writer=new PrintWriter(c.getOutputStream(),true);

            //sending message to server
            System.out.print("Enter message to send to server: ");
            String message=sc.nextLine();
            writer.println(message);
            System.out.println("\nMessage sent to server        : "+message);

            //receiving message from server
            String response=reader.readLine();
            System.out.println("Response received from server : "+response);

            reader.close();
            writer.close();
            c.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
