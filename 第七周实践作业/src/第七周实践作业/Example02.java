package 第七周实践作业;

public class Example02 {
     public static void main (String[] args){
    	 MyThread myThread=new MyThread();
    	 myThread.start();
    	 while(true){
    		 System.out.println("main()方法正在运行");
    	 }
     }
}
class MyThread extends Thread{
	public void run(){
		while (true){
			System.out.println("第二个线程正在运行");
		}
	}//MyThread类的run()方法正在运行
}