public class reverseLL extends LinkedList {
	public static void reverse(LinkedList ll)
	{
		Node prev = null;
		Node curr = ll.begin;
		while(curr!= null)
		{
			Node tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		ll.begin = prev;
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
		reverse(ll);
		System.out.println(ll.toString());
	}
}