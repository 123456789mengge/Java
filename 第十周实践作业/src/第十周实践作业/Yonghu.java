package ��ʮ��ʵ����ҵ;
import java.util.Random;

class Input implements Runnable{
		private Storage st;
	    private Random num;  
	    

		Input(Storage st){
			this.st=st;      //ͨ�����췽������Storage����
			num=new Random();   //�ڷ�����new����һ����������������飻new������ʵ��������ֻ���ڷ��������У�
		}
		public void run() {
			try{
		Thread.sleep(num.nextInt(10));
		}
		catch (InterruptedException e){
					e.printStackTrace();}
		while(true){
				st.put(num.nextInt(100));//��һ�����ڵ������
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
				System.out.println(cells[inpos]+" �û���¼");
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
				System.out.println(data+" �û�ע��");
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