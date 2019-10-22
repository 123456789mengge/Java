package 第七周实践作业;

public class Example03 {
     public static void main(String[] args){
    	 MyThread1 myThread=new MyThread1();
    	 Thread thread =new Thread(myThread);
    	 thread.start();
    	 while(true){
    		 System.out.println("main()方法在运行");
    	 }
    	 
     }
}class MyThread1 implements Runnable{
	public void run(){
		while(true){
			System.out.println("MyThread类中的run()方法在运行");
		}
	}
}
