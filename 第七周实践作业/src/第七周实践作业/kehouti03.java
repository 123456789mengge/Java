package 第七周实践作业;

public class kehouti03 {
     public static void main (String[] args){
    	 Jiaoshi tw=new Jiaoshi();
    	 new Thread(tw,"教师一").start();
    	 new Thread(tw,"教师二").start();
    	 new Thread(tw,"教师三").start();
     }
}
class Jiaoshi implements Runnable {
	private int i=80;
	public void run(){
		while (true){
			if(i>0){
			Thread th=Thread.currentThread();
			String thname=th.getName();
			System.out.println(thname+"正在发第"+i--+"份学习笔记");
		}
	}}
}
/*class Jiaoshi implements Runnable {
	//private juanzi=80;
	public void run(){
		for(int i=80;i>0;){
			Thread th=Thread.currentThread();
			String thname=th.getName();
			System.out.println(thname+"正在发第"+i--+"份学习笔记");
		}
	}
}*/
