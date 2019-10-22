package 第七周实践作业;

public class kehouti02 {
    public static void main(String[] args){
    	MyThread2 mythread=new MyThread2();
    	Thread thread=new Thread(mythread);   // 	 Thread thread =new Thread(myThread);
    	thread.start();
    	
 		for(int w=100;w>=0;w--)
 		{
 			System.out.println("main");
 			
 		}
    }
}
class MyThread2 implements Runnable{
	public void run()
	{    
		for(int i=50;i>=0;i--)
		{
			
			System.out.println("new");
		}
	}
}