import tv.*;
import tvfactory.*;

public class Main{
 public static void main(String[] args){
      //Scanner scan = new Scanner(System.in);
      TV tv = new HaierTVFactory().produceTV();
       tv.show();
 }
}