package 第七周实践作业;

public class Chuzuche {
      public static void main(String[] args){
    	  Chengke tw=new Chengke();
    	  new Thread(tw,"第一个出租车").start();
    	  new Thread(tw,"第二个出租车").start();
    	  new Thread(tw,"第三个出租车").start();
    	  new Thread(tw,"第四个出租车").start();
    	  new Thread(tw,"第五个出租车").start();
      }
}
class Chengke implements Runnable{
	private int tickets=100;
	public void run(){
		while(true){
			if(tickets>0){
				Thread th=Thread.currentThread();
				String thname=th.getName();
				System.out.println(thname+"正在接送第"+tickets--+"个乘客");
			}
		}
	}
}
