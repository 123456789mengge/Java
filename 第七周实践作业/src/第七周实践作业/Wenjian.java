package ������ʵ����ҵ;

public class Wenjian {
     public static void main(String[] args){
    	 Shuzu tw=new Shuzu();
    	 new Thread(tw,"�߳�һ").start();
    	 new Thread(tw,"�̶߳�").start();
    	 new Thread(tw,"�߳���").start();
     }
}
class Shuzu implements Runnable{
	private int[] shuzu = new int[100];
	public void run(){
		//while(true){
			for(int i=0;i<shuzu.length;i++)
			{
				Thread th=Thread.currentThread();
				String thname=th.getName();
				System.out.println(thname+"��������shuzu["+i+"]�ļ�");
			}
		}
	}