package pbl��Ŀ;

public class Main {
	
		public static void main(String[] args){
			Customer customer=new Customer("�û�");
			//Movie movie = new Movie("��һ����Ӱ",1);
			//Rental rental = new Rental(movie,5);
			//customer.addRental(rental);
			customer.addRental(new Rental(new Movie("����ѩ��Ե2��",0),5));
			customer.addRental(new Rental(new Movie("��������㡷",1),6));
			customer.addRental(new Rental(new Movie("���й�������",2),7));
			System.out.println("�������飺"+customer.statement());
		}
	}


