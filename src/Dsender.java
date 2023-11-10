import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Dsender{
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);

        DatagramSocket ds=new DatagramSocket();

        System.out.print("Enter a message: ");
        String str=sc.nextLine();

        InetAddress ip=InetAddress.getByName("127.0.0.1");

        DatagramPacket dp=new DatagramPacket(str.getBytes(),str.length(),ip,3000);

        ds.send(dp);
        ds.close();


    }
}
