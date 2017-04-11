public class sumList extends LinkedList 
{
	public static LinkedList sumList(LinkedList l1, LinkedList l2)
	{
		Node cur1 = l1.begin;
		Node cur2 = l2.begin;
		LinkedList output = new LinkedList();
		int rem = 0;
		int sum;

		while(cur1 != null && cur2!= null)
		{
			if (cur1 == null)
			{
				sum = cur2.data + rem;
			}
			else if (cur2 == null)
			{
				sum = cur1.data + rem;
			}
			else
				sum = (cur1.data + cur2.data) + rem;
			
			output.insertLast(sum % 10);
			rem = sum / 10;
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return output;
	}

	public static void main(String[] args)
	{
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();

		l1.insertLast(7);
		l1.insertLast(1);
		l1.insertLast(6);
		l2.insertLast(5);
		l2.insertLast(9);
		l2.insertLast(2);

		System.out.println(sumList(l1, l2).toString());

	}
}