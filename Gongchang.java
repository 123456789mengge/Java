import java.util.Scanner;
interface TV{
 void show();
}
class HaierTV implements TV{
 public void show(){
      System.out.println("This is HaierTV");
 }
}
class HisenceTV implements TV{
    public void show(){
     System.out.println("This is HisenseTV");
 }
}
interface TVFactory{
  TV produceTV();
}
class HaierTVFactory implements TVFactory{
    public TV produceTV(){
      return new HaierTV();
  }
}
class HisenseTVFactory implements TVFactory{
   public TV produceTV(){
    return new HisenseTV();
 }
}
public class Gongchang{
 public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      TV tv = new HaierTVFactory().produceTV();
       tv.show();
 }
}