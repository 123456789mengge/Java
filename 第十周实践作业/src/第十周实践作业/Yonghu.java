package 第十周实践作业;
import java.util.Random;

class Input implements Runnable{
		private Storage st;
	    private Random num;  
	    

		Input(Storage st){
			this.st=st;      //通过构造方法接受Storage对象；
			num=new Random();   //在方法中new出来一个对象，做具体的事情；new出来的实例化对象只能在方法中运行；
		}
		public void run() {
			try{
		Thread.sleep(num.nextInt(10));
		}
		catch (InterruptedException e){
					e.printStackTrace();}
		while(true){
				st.put(num.nextInt(100));//在一百以内的随机数
				}
		}
		
	}
class Output implements Runnable{
		private Storage st;
		Output (Storage st){
			this.st=st;
		}
		public void run(){
			while(true){
				st.get();
			}
		}
	}
	class Storage{
		private String[] cells=new String [8];
		private int count;
		public int inpos,outpos;
		public synchronized void put (int num){//Random
			try{
				while (count==cells.length){
					this.wait();
				}
				cells[inpos]=String.valueOf(num);
				System.out.println(cells[inpos]+" 用户登录");
				inpos++;
				if(inpos==cells.length)
					inpos=0;
				count++;
				this.notify();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		public synchronized void get(){ 
			try {
				while(count==0){
					this.wait();
				}
				String data=cells[outpos];
				System.out.println(data+" 用户注销");
				cells[outpos]="0";
				outpos++;
				if(outpos==cells.length)
					outpos=0;
				count--;
				this.notify();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}


public class Yonghu {

	public static void main (String[] args) {
		Storage st =new Storage();
		Input input =new Input(st);
		Output output =new Output(st);
		new Thread(input).start();
		new Thread(output).start();
	}
}