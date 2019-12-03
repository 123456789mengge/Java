package pbl项目;

public class Main {
	
		public static void main(String[] args){
			Customer customer=new Customer("用户");
			//Movie movie = new Movie("第一部电影",1);
			//Rental rental = new Rental(movie,5);
			//customer.addRental(rental);
			customer.addRental(new Rental(new Movie("《冰雪奇缘2》",0),5));
			customer.addRental(new Rental(new Movie("《少年的你》",1),6));
			customer.addRental(new Rental(new Movie("《中国机长》",2),7));
			System.out.println("租用详情："+customer.statement());
		}
	}


