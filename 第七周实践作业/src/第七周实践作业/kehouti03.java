package ������ʵ����ҵ;

public class kehouti03 {
     public static void main (String[] args){
    	 Jiaoshi tw=new Jiaoshi();
    	 new Thread(tw,"��ʦһ").start();
    	 new Thread(tw,"��ʦ��").start();
    	 new Thread(tw,"��ʦ��").start();
     }
}
class Jiaoshi implements Runnable {
	private int i=80;
	public void run(){
		while (true){
			if(i>0){
			Thread th=Thread.currentThread();
			String thname=th.getName();
			System.out.println(thname+"���ڷ���"+i--+"��ѧϰ�ʼ�");
		}
	}}
}
/*class Jiaoshi implements Runnable {
	//private juanzi=80;
	public void run(){
		for(int i=80;i>0;){
			Thread th=Thread.currentThread();
			String thname=th.getName();
			System.out.println(thname+"���ڷ���"+i--+"��ѧϰ�ʼ�");
		}
	}
}*/
