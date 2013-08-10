import java.util.*;	
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		float vs = in.nextFloat(), r = in.nextFloat(),c = in.nextFloat();
		int num = in.nextInt();
		while(num-->0){
			float w = in.nextFloat();
			float vr = (float) (c*r*w*vs/Math.sqrt(1+c*r*w*c*r*w));
			System.out.format("%.3f%n",(double)Math.round(vr*1000)/1000);
		}
	}
}
