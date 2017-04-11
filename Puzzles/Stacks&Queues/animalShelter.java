import java.util.LinkedList;
import java.util.Iterator;

public class animalShelter {
	LinkedList<Animal> ll;

	public static class Animal {
		public void display()
		{
			System.out.println("Im an animal");
		}
	}

	public static class Dog extends Animal{
		public void display()
		{
			System.out.println("Im a Dog");
		}
	}

	public static class Cat extends Animal{
		public void display()
		{
			System.out.println("Im a Cat");
		}
	}

	public animalShelter()
	{
		ll = new LinkedList<Animal>();
	}

	public void enqueue(Animal a)
	{
		ll.addLast(a);
	}

	public Animal dequeueAny()
	{
		return ll.pollFirst();
	}

	public Animal dequeueDog()
	{
		Iterator<Animal> itr = ll.listIterator();
		while(itr.hasNext())
		{
			if(itr.next() instanceof Dog)
			{
				return itr.next();
			}
		}
		return null;
	}

	public Animal dequeueCat()
	{
		Iterator<Animal> itr = ll.listIterator();
		while(itr.hasNext())
		{
			if(itr.next() instanceof Dog)
			{
				return itr.next();
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		animalShelter as = new animalShelter();
		Dog d = new Dog();
		Cat c = new Cat();

		as.enqueue(d);
		as.enqueue(d);
		as.enqueue(c);
		as.enqueue(c);
		as.enqueue(d);

		as.dequeueAny().display();
		as.dequeueCat().display();
		as.dequeueDog().display();

	}
}