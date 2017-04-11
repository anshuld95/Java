public class myLinkedList<AnyType>{
	private static class Node<AnyType>{
		public AnyType data;
		public Node next;

		public Node(AnyType d)
		{
			data = d;
		}
	} 

	private Node first;

	public myLinkedList(){
		first = null;
	}

	public boolean isEmpty()
	{
		if(first==null)
		{
			return true;
		}
		else
			return false;
	}

	public void insertFirst(AnyType d)
	{
		Node temp = first;
		first = new Node(d);
		first.next = temp;
	}

	public Node find(AnyType d)
	{
		Node curr = front;
		while(curr!=null)
		{
			if(curr.data == d)
			{
				return curr;
			}
			curr=curr.next;
		}
		return curr;
	}

	public Node delete(AnyType d)
	{
		Node curr = front;
		while(curr.data != d)
		{
			if (curr.next == null)
			{
				return null;
			}
			else if(curr.next.data = d)
			{
				Node temp = curr.next;
				curr.next = curr.next.next;
				return temp; 
			}
			curr = curr.next;
		}
	}

	public void display()
	{
		Node curr = front;
		System.out.print("[ ");
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.print(" ]");

	}


	public static void main(String[] args)
	{
		myLinkedList<Integer> l = new myLinkedList();
		l.insertFirst(10); 
		l.insertFirst(20); 
		l.insertFirst(30); 
		l.insertFirst(40); 
		l.insertFirst(1); 
		l.insertFirst(11); 
		l.delete(1);
		l.display();
	}
}