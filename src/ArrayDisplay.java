import java.util.Scanner;
public class ArrayDisplay {

		Scanner sc = new Scanner(System.in);
	    int status=1;
	    int size = sc.nextInt();
	  
	    public static void main(String[] args) {
	    	ArrayDisplay ar = new ArrayDisplay(); 

	        Array1 a=new Array1(ar);
	        Array2 b=new Array2(ar);
	        Array3 c=new Array3(ar);

	        a.start();
	        b.start();
	        c.start();
	    }
	}

	class Array1 extends Thread{
	    ArrayDisplay ar;
	   

	    Array1(ArrayDisplay ar){
	        this.ar = ar;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (ar) {
	            	int ar1[] = {1,2,3,4,5};
	            	/*for(int i=0;i<ar1.length;i++)
	            		ar1[i]=ar.sc.nextInt();*/
	                for (int i = 0; i < ar.size; i++) {

	                	//ar1[i]=ar.sc.nextInt();
	                    while(ar.status!=1){
	                        ar.wait();
	                    }

	                    System.out.print(ar1[i]);
	                    ar.status = 2;
	                    ar.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 1 :"+e.getMessage());
	        }

	    }

	}

	class Array2 extends Thread{

		ArrayDisplay ar;

	    Array2(ArrayDisplay ar){
	        this.ar = ar;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (ar) {

	            	int ar2[] = {2,4,6,8,0};
	            	/*for(int i=0;i<ar2.length;i++)
	            		ar2[i]=ar.sc.nextInt();*/
	                for (int i = 0; i < ar.size; i++) {

	                	//ar2[i]=ar.sc.nextInt();
	                    while(ar.status!=2){
	                        ar.wait();
	                    }

	                    System.out.print(ar2[i]);
	                    ar.status = 3;
	                    ar.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 2 :"+e.getMessage());
	        }

	    }
	}


	class Array3 extends Thread{

		ArrayDisplay ar;

	    Array3(ArrayDisplay ar){
	        this.ar = ar;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (ar) {

	            	int ar3[] = {1,3,5,7,9};
	            	/*for(int i=0;i<ar3.length;i++)
	            		ar3[i]=ar.sc.nextInt();*/
	                for (int i = 0; i < ar.size; i++) {

	                    while(ar.status!=3){
	                    		ar.wait();
	                    }

	                    System.out.print(ar3[i]);
	                    ar.status = 1;
	                    ar.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 3 :"+e.getMessage());
	        }

	    }
}
