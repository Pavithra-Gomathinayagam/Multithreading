import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arraysum {

	private static final Logger logger = Logger.getLogger(Arraysum.class.getName());
	private static int ar1[] = {1,2,3,4,5};
	private static int ar2[] = {2,3,4,5,6};
	private static int ab1[] = new int[ar1.length];
	private static int ab2[] = new int[ar2.length];
	private static int ab3[] = new int[ar1.length];
	public static void main(String args[])
	{
		/*Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();*/
		
		ArrayOne ar = new ArrayOne();
		Thread t1 = new Thread(ar);
		ArrayTwo at = new ArrayTwo();
		Thread t2 = new Thread(at);
		ArrayCalc arc = new ArrayCalc();
		Thread t3 = new Thread(arc);
		t1.start();
		t2.start();
		try {
			t1.join();
		}catch(Exception e)
		{
			logger.log(Level.INFO,e.getMessage());
		}
		try {
			t2.join();
		}catch(Exception e)
		{
			logger.log(Level.INFO,e.getMessage());
		}
		t3.start();
	}
	static class ArrayOne implements Runnable{
	
		@Override
		public void run() {
			// TODO Auto-generated method stub
				for(int i=0;i<ar1.length;i++)
				{
					//ar1[i] = sc.nextInt();
					ab1[i]=ar1[i]*ar1[i];
					try {
			            Thread.sleep(4000);
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
				}
		}
		
	}
	static class ArrayTwo implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<ar2.length;i++)
			{
				
				ab2[i]=ar2[i]*ar2[i]*ar2[i];
				System.out.println(ab2[i]);
				try {
		            Thread.sleep(4000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
			
		}
	}
	static class ArrayCalc implements Runnable{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			for(int i=0;i<ar1.length;i++)
			{
				ab3[i]=ab1[i]+ab2[i];
				logger.log(Level.INFO,ab3[i]+" ");
				try {
		            Thread.sleep(4000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		}
	}
}
