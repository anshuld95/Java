import java.util.HashSet;

public class removeDups extends LinkedList 
{
	public static void delDups(LinkedList ll)
	{
		HashSet<Integer> h = new HashSet<Integer>();
		Node cur = ll.begin;
		while(cur != null)
		{
			if(h.contains(cur.data))
			{
				ll.delNode(cur);
			}
			h.add(cur.data);
			cur=cur.next;
		}
	}

	public static void delDupsNoBF(LinkedList ll)
	{
		Node curr = ll.begin;
		while(curr.next != null)
		{
			Node prev = curr;
			Node nxt = curr.next;
			while(nxt != null)
			{
				if(nxt.data == curr.data)
				{
					nxt=nxt.next;
					prev.next = nxt;
				}
				else
				{
					prev = nxt;
					nxt=nxt.next;
				}
			}
			curr = curr.next;
		}

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
		delDupsNoBF(ll);
		System.out.println(ll.toString());

	}
}