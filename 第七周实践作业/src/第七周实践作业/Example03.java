package ������ʵ����ҵ;

public class Example03 {
     public static void main(String[] args){
    	 MyThread1 myThread=new MyThread1();
    	 Thread thread =new Thread(myThread);
    	 thread.start();
    	 while(true){
    		 System.out.println("main()����������");
    	 }
    	 
     }
}class MyThread1 implements Runnable{
	public void run(){
		while(true){
			System.out.println("MyThread���е�run()����������");
		}
	}
}
