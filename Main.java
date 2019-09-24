interface TV{
    void play();
}
class HaierTV implements TV{
   public void play(){
         System.out.println("This is Haier TV");
 }
}
class HisenseTV implements TV{
  public void play(){
     System.out.println("This is HisenseTV");
 }
}
class TVFactory{
 public static TV produceTV(String brand){
    if(brand.equals("HaierTV")) return new HaierTV();
    if(brand.equals("HisenseTV")) return new HisenseTV();
    return null;
 }
}
public class Main{
 public static void main(String[] args){
   TV tv = TVFactory.produceTV("HaierTV");
   tv.play();
 }
}
