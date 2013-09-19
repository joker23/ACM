import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        while(i-->0){
            String tmp = in.next();
            if(tmp.length()>10){
                System.out.println(""+tmp.charAt(0) + (tmp.length()-2) + tmp.charAt(tmp.length()-1));
            }else{
                System.out.println(tmp);
            }
        }
    }
}
