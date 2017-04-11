import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;

public class doublyLinked<AnyType>{
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> next;
		public Node<AnyType> prev;

		public Node(AnyType d)
		{
			data = d;
		}
	}

	public Node<AnyType> front;

	public doublyLinked()
	{
		front = null;
	}

	public boolean isEmpty()
	{
		if(front==null)
		{
			return true;
		}
		else
			return false;
	}

	public void insertFirst(AnyType d)
	{
		Node<AnyType> newFront = new Node<AnyType>(d);
		if(isEmpty()==true)
		{
			front = newFront;
			front.next = null;
			front.prev = null;
		}
		else
		{
			front.prev = newFront;
			newFront.next = front;
			newFront.prev = null;
			front = newFront;
		}
		
	}

	public Node<AnyType> delete(AnyType d)
	{
		Node<AnyType> curr = front;
		while(curr.data!=d)
		{
			curr=curr.next;
		}
		Node<AnyType> temp = curr;
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		return temp;
	}

	public void reverse()
	{
		Node<AnyType> curr = front;

		while(curr!=null)
		{
			Node<AnyType> temp = curr.next;
			curr.next = curr.prev;
			curr.prev = temp;
			if (curr.prev == null)
			{
				front = curr;
				break;
			}
			curr=curr.prev;
		}

	}

	public void display()
	{
		System.out.print("[ ");
		Node<AnyType> curr = front;
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
		System.out.println(" ]");
	}

	public static void main(String[] args)
	{
		doublyLinked<Integer> mydl = new doublyLinked<Integer>();
		LinkedList<Integer> rldl = new LinkedList<Integer>();

		mydl.insertFirst(10);
		mydl.display();
		mydl.insertFirst(2);
		mydl.insertFirst(9);
		mydl.insertFirst(3);
		mydl.insertFirst(1);
		mydl.insertFirst(20);
		mydl.insertFirst(30);
		mydl.delete(1);
		mydl.display();
		mydl.reverse();
		mydl.display();
		System.out.println("Real Linked list from Java API");
		rldl.addFirst(10);
		rldl.addFirst(2);
		rldl.addFirst(9);
		rldl.addFirst(3);
		rldl.addFirst(1);
		rldl.addFirst(20);
		rldl.addFirst(30);
		rldl.remove(Integer.valueOf("1"));
		System.out.println(Arrays.toString(rldl.toArray()));
		Collections.reverse(rldl);
		System.out.println(Arrays.toString(rldl.toArray()));
	}


}