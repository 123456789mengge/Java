package ������ʵ����ҵ;

public class Chuzuche {
      public static void main(String[] args){
    	  Chengke tw=new Chengke();
    	  new Thread(tw,"��һ�����⳵").start();
    	  new Thread(tw,"�ڶ������⳵").start();
    	  new Thread(tw,"���������⳵").start();
    	  new Thread(tw,"���ĸ����⳵").start();
    	  new Thread(tw,"��������⳵").start();
      }
}
class Chengke implements Runnable{
	private int tickets=100;
	public void run(){
		while(true){
			if(tickets>0){
				Thread th=Thread.currentThread();
				String thname=th.getName();
				System.out.println(thname+"���ڽ��͵�"+tickets--+"���˿�");
			}
		}
	}
}
