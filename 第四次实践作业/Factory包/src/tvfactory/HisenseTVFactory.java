package tvfactory;
import tv.*;
public class HisenseTVFactory implements TVFactory{
   public TV produceTV(){
    return new HisenceTV();
 }
}