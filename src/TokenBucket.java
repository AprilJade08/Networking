import java.lang.*;

class Bucket{
    public int maxsize, tokens;
    Bucket(int max){
        maxsize=max;
        tokens=0;
    }

    synchronized void addToken(){
        if(tokens>=maxsize)return;
        tokens+=1;
        System.out.println("Added a token. Total : "+tokens);
    }

    synchronized void sendPacket(int n){
        System.out.println("Packet of size "+n+" has arrived");
        if (n>tokens){
            System.out.println("Packet is non-conformant, discarded");
        }else{
            tokens-=n;
            System.out.println("Forwarding packet");
        }
    }
}

class AddTokenThread extends Thread{
    Bucket b;
    AddTokenThread(Bucket b){
        this.b=b;
    }

    public void run(){
        while(true){
            b.addToken();
            try{
                Thread.sleep(300);
            }catch(Exception e){}
        }
    }
}

class AddPacketThread extends Thread{
    Bucket b;
    AddPacketThread(Bucket b){
        this.b=b;
    }

    public void run(){
        while(true){
            try{
                Thread.sleep(500+(int)(Math.random()*3000));
            }catch(Exception e){}
            b.sendPacket(1+(int)(Math.random()*9));
        }
    }
}

public class TokenBucket{
    public static void main(String args[]){
        Bucket b=new Bucket(10);
        Thread token=new AddTokenThread(b);
        Thread packet=new AddPacketThread(b);

        try{
            token.start();
            packet.start();
        }catch(Exception e){}
    }
}