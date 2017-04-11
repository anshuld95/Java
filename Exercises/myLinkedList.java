public class myLinkedList<AnyType>{
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> next;

		public Node(AnyType d)
		{
			data = d;
		}
	} 

	private Node<AnyType> front;

	public myLinkedList(){
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
		Node<AnyType> temp = front;
		front = new Node<AnyType>(d);
		front.next = temp;
	}

	public Node<AnyType> find(AnyType d)
	{
		Node<AnyType> curr = front;
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

	public Node<AnyType> delete(AnyType d)
	{
		Node<AnyType> curr = front;
		while(curr.data != d)
		{
			if (curr.next == null)
			{
				return null;
			}
			else if(curr.next.data == d)
			{
				Node<AnyType> temp = curr.next;
				curr.next = curr.next.next;
				return temp; 
			}
			curr = curr.next;
		}
		return curr;
	}

	public void display()
	{
		Node<AnyType> curr = front;
		System.out.print("[ ");
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.println(" ]");

	}


	public static void main(String[] args)
	{
		myLinkedList<Integer> l = new myLinkedList<Integer>();
		l.insertFirst(10); 
		l.insertFirst(20); 
		l.insertFirst(30); 
		l.insertFirst(40); 
		l.insertFirst(1); 
		l.insertFirst(11); 
		l.delete(1);
		l.delete(10);
		l.display();
	}
}