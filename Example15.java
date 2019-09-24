interface Animal{
	void shout ();
}
class Cat implements Animal {
	public void shout(){
		System.out.println("燉燉。。。");
	}
	void sleep()
	{
		System.out.println ("竪鋒状，，，，，，");
	}
}
class Dog implements Animal {
	public void shout()
	{
		System.out.println("濫濫。。。");
	}
}
public class Example15 {
   public static void main (String[] args){
	   Dog dog=new Dog();
	   animalShout(dog);
   }
   public static void animalShout(Animal animal){
	  if(animal instanceof Cat) {
		  Cat cat=(Cat) animal;
		  cat.sleep();
		  cat.shout();
	  }
	  else{
		  System.out.println("this animal is not a cat");
	  }
   }
}
