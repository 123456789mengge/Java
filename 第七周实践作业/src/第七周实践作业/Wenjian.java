package 第七周实践作业;

public class Wenjian {
     public static void main(String[] args){
    	 Shuzu tw=new Shuzu();
    	 new Thread(tw,"线程一").start();
    	 new Thread(tw,"线程二").start();
    	 new Thread(tw,"线程三").start();
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
				System.out.println(thname+"正在下载shuzu["+i+"]文件");
			}
		}
	}