import java.io.*;
public class CRCCheck {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter data : ");
        String data=br.readLine();
        System.out.print("Enter generator : ");
        String gen=br.readLine();

        String code=data;

        while(code.length()<(data.length()+gen.length()-1)){
            code+="0";
        }

        code=data+div(code,gen);
        System.out.println("\nTransmitted code is : "+code);

        System.out.print("\nEnter received code : ");
        String rec=br.readLine();

        if(Integer.parseInt(div(rec,gen))==0){
            System.out.println("Transmitted without errors.");
        }else{
            System.out.println("Transmitted with errors.");
        }
    }

    static String div(String num1, String num2){
        int pointer=num2.length();
        String result=num1.substring(0,pointer);
        String remainder="";

        for(int i=0;i<num2.length();i++){
            if(result.charAt(i)==num2.charAt(i)){
                remainder+="0";
            }else{
                remainder+="1";
            }
        }

        while(pointer<num1.length()){
            if(remainder.charAt(0)=='0'){
                remainder=remainder.substring(1,remainder.length());
                remainder+=String.valueOf(num1.charAt(pointer));
                pointer++;
            }

            result=remainder;
            remainder="";

            for(int i=0;i<num2.length();i++){
                if(result.charAt(i)==num2.charAt(i)){
                    remainder+="0";
                }else{
                    remainder+="1";
                }
            }
        }

        return remainder.substring(1,remainder.length());
    }
}
