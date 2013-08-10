import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),aa=0,bb=0,cc=0,min = Integer.MAX_VALUE,k;
		for(int i=1;i*i<=n;i++)
			for(int j=1;i*i*j<=n;j++)
				if(n%(i*j)==0){
					k = n/(i*j);
					if(i*j+j*k+k*i<min){
						aa=i;
						bb=j;
						cc=k;
						min = i*j+j*k+k*i;
					}
				}
		System.out.println(aa+" "+bb+" "+cc);
	}
}