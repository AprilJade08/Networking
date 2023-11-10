import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int storage=0;

        System.out.println("Enter the following:\n");
        System.out.print("Bucket Size    : ");
        int bucket=sc.nextInt();
        System.out.print("Incoming Rate  : ");
        int incoming=sc.nextInt();
        System.out.print("Outgoing Rate  : ");
        int outgoing=sc.nextInt();
        System.out.print("No. of Queries : ");
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.println();
            if(incoming<=(bucket-storage)){
                storage+=incoming;
                System.out.println("Bucket buffer size is "+storage+" out of "+bucket);
            }else{
                System.out.println("Packet loss = "+(incoming-(bucket-storage)));
                storage=bucket;
                System.out.println("Bucket buffer size is "+storage+" out of "+bucket);
            }
            storage-=outgoing;
            System.out.println("After outgoing "+storage+" packets left out of "+bucket+" in buffer.");
        }

    }
}
