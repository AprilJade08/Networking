import java.util.Scanner;
public class CaesarCipher{
    public static String encrypt(String text, int s){
        String result="";
        for(int i=0;i<text.length();i++){
            char Curr=text.charAt(i);
            if(Character.isUpperCase(Curr)){
                char New=(char)(((int)Curr-65+s)%26+65);
                result+=New;
            }else{
                char New=(char)(((int)Curr-97+s)%26+97);
                result+=New;
            }

        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text : ");
        String text=sc.nextLine();
        int shift=4;

        System.out.println("\nPlaintext : "+text);
        System.out.println("Ciphertext : "+encrypt(text,shift));
    }
}
