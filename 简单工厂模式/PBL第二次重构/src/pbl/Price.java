package pbl;

abstract class Price {
    abstract int getPriceCode();
    abstract double getChager(int daysRented) ;
    
    public int getFrequentRentalPoint(int daysRented) {
   		 return 1;
    }
}
 class ChildrensPrice extends Price{

	int getPriceCode() {
		return Movie.CHILDRENS;
	}
	public double getChager(int daysRented) {
		//double result=0;
		double result=1.5;
		if(daysRented > 3)
  			 result += (daysRented - 3) * 1.5;
		return result;
	}
}
 class RegularPrice extends Price{

		int getPriceCode() {
			return Movie.NEW_RELEASE;
		}
		public double getChager(int daysRented) {
			double result=2;
	  		 if(daysRented > 2) 
	  			 result += (daysRented - 2) * 1.5;
			return result;
			
		}
	}

class NewRegularPrice extends Price{

	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	public double getChager(int daysRented) {
		//return dayRented;
	    return daysRented * 3;
	}
	public int getFrequentRentalPoint(int daysRented) {
  		 return (daysRented>1) ? 2 : 1;
   }
}
