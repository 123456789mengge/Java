package  ������ʵ����ҵ;
class Mythread3 extends Thread{
	public void run(){
		
			System.out.println("�߳�һ");
		
		
	}
}
class MThread extends Thread {
	 public void run(){
		
			 System.out.println("�̶߳�");
		 
	 }
}
public class kehouti01 {
      public static void main(String[] args){
    	  Mythread3 mythread= new Mythread3();
    	  MThread mthread=new MThread();
    	  mythread.setName("�߳�һ");
    	  mthread.setName("�̶߳�");
    	  mythread.start();
    	  mthread.start();
    		
      }
}
