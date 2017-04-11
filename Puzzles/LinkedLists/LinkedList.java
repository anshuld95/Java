public class LinkedList {
	public static class Node {
		int data;
		Node next;

		public Node(int d)
		{
			data = d;
		}
	}

	Node begin;

	public LinkedList() {
		begin = null;
	}

	public void insertFirst(int d)
	{
		Node newFirst = new Node(d);
		Node temp = begin;
		begin = newFirst;
		newFirst.next = temp;
	}

	public Boolean isEmpty()
	{
		if(begin == null)
		{
			return true;
		}
		else
			return false;

	}

	public void insertLast(int d)
	{
		Node newNode = new Node(d);
		if (this.isEmpty())
		{
			begin = newNode;
			begin.next = null;
		}
		else
		{
			Node current = begin;
			while(current.next != null)
			{
				current = current.next;
			}
			current.next = newNode;
			newNode.next = null;
		}
	}

	public void delete(int idx)
	{
		Node curr = begin;
		Node prev = null;
		for (int i=0; i<idx-1; i++)
		{
			if(curr.next == null)
			{
				break;
			}
			else
			{
				prev = curr;
				curr=curr.next;
			}
		}
		if(prev!=null)
		{
			prev.next = curr.next;
		}
		else
			begin = prev;
	}

	public void delNode(Node s)
	{
		if (this.isEmpty())
		{
			return;
		}

		if(begin.data == s.data)
		{
			begin = begin.next;
			return;
		}

		Node curr = begin;
		while(curr.next.data != s.data )
		{
			if(curr.next == null)
			{
				System.out.println("Node not found!");
				return;
			}
			curr=curr.next;
		}
		curr.next = curr.next.next;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		Node curr = begin;
		while(curr!=null)
		{
			str.append(curr.data + " ");
			curr = curr.next;
		}
		str.append("]");
		return str.toString();

	}

	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		ll.insertFirst(4);
		ll.insertFirst(4);
		ll.insertFirst(6);
		ll.insertFirst(2);
		ll.insertFirst(8);
		ll.insertFirst(4);
		ll.insertFirst(1);
		ll.insertFirst(4);
		ll.insertFirst(9);
		System.out.println(ll.toString());
		Node del = new Node(9);
		ll.delNode(del);
		System.out.println(ll.toString());

	}
}