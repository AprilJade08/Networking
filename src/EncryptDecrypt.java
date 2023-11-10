import java.util.Scanner;
public class EncryptDecrypt {
    public static void encrypt(char password[],int key){
        for(int i=0;i<password.length;i++){
            password[i]=(char)(password[i]-key);
        }
    }

    public static void decrypt(char password[],int key){
        for(int i=0;i<password.length;i++){
            password[i]=(char)(password[i]+key);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter password: ");
        String password=sc.nextLine();
        char passwordarray[]=password.toCharArray();
        System.out.println("\nPassword         : "+password);
        encrypt(passwordarray,3);
        System.out.println("Encrypted password : "+new String(passwordarray));
        decrypt(passwordarray,3);
        System.out.println("Decrypted password : "+new String(passwordarray));
    }
}
