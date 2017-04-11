import java.util.Queue;
import java.util.LinkedList;

class twoStackQueue{
	private myStack s1;
	private myStack s2;

	public twoStackQueue(){
		s1 = new myStack(100);
		s2 = new myStack(100);
	}

	public void insert(int data)
	{
		s1.push(data);
	}

	public int delete()
	{
		if(s2.isEmpty() == true)
		{
			while(s1.isEmpty() == false)
			{
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}

	public int peek()
	{
		if(s2.isEmpty() == true)
		{
			while(s1.isEmpty() == false)
			{
				s2.push(s1.pop());
			}
		}
		return s2.peek();
	}

	public static void main(String[] args)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		twoStackQueue myQ = new twoStackQueue();
		queue moq = new queue(100);

		q.add(4);
		q.add(1);
		q.add(2);
		q.add(6);
		q.add(3);
		q.add(5);
		System.out.println("Dequeue: " + q.remove());
		System.out.println("Dequeue: " + q.remove());
		System.out.println("Dequeue: " + q.remove());
		System.out.println("Dequeue: " + q.remove());
		myQ.insert(4);
		myQ.insert(1);
		myQ.insert(2);
		myQ.insert(6);
		myQ.insert(3);
		myQ.insert(5);
		System.out.println("My Dequeue: " + myQ.delete());
		System.out.println("My Dequeue: " + myQ.delete());
		System.out.println("My Dequeue: " + myQ.delete());
		System.out.println("My Dequeue: " + myQ.delete());
		moq.insert(4);
		moq.insert(1);
		moq.insert(2);
		moq.insert(6);
		moq.insert(3);
		moq.insert(5);
		System.out.println("My Dequeue: " + moq.delete());
		System.out.println("My Dequeue: " + moq.delete());
		System.out.println("My Dequeue: " + moq.delete());
		System.out.println("My Dequeue: " + moq.delete());
		
	}
}