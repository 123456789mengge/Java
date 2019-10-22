package  第七周实践作业;
class Mythread3 extends Thread{
	public void run(){
		
			System.out.println("线程一");
		
		
	}
}
class MThread extends Thread {
	 public void run(){
		
			 System.out.println("线程二");
		 
	 }
}
public class kehouti01 {
      public static void main(String[] args){
    	  Mythread3 mythread= new Mythread3();
    	  MThread mthread=new MThread();
    	  mythread.setName("线程一");
    	  mthread.setName("线程二");
    	  mythread.start();
    	  mthread.start();
    		
      }
}
