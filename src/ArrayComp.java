import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class ArrayInput implements Runnable{
	private static final Logger logger = Logger.getLogger(ArrayComp.class.getName());
	int size;
	Scanner sc = new Scanner(System.in);

	ArrayInput(int n)
	{
		size = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int ar1[] = new int[size];
		int ar2[] = new int[size];
		int ar3[] = new int[size];
		logger.log(Level.INFO,"Enter the array1");
		for(int i=0;i<size;i++)
		{
			ar1[i] = sc.nextInt();
			ar1[i]=ar1[i]*ar1[i];
		}
		logger.log(Level.INFO,"Enter the array2");
		for(int i=0;i<size;i++)
		{
			
			ar2[i] = sc.nextInt();
			ar2[i]=ar2[i]*ar2[i]*ar2[i];
			
		}
		for(int i=0;i<size;i++)
		{
			ar3[i]=ar1[i]+ar2[i];
		}
		for(int i=0;i<size;i++)
		{
			logger.log(Level.INFO,ar3[i]+" ");
		}
	}
}

public class ArrayComp {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayInput ar = new ArrayInput(n);
		Thread t1 = new Thread(ar);
		t1.start();
	}
}
