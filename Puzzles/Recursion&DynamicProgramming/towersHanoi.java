import java.util.Stack;
import java.util.Arrays;

public class towersHanoi {
	public static class Tower {
		private Stack<Integer> disks;

		public Tower() {
			disks = new Stack<Integer>();
		}

		public void push(int i)
		{
			if(isEmpty() || disks.peek() > i)
			{
				disks.push(i);
			}
		}

		public int pop()
		{
			return disks.pop();
		}

		public int peek()
		{
			return disks.peek();
		}

		public Boolean isEmpty()
		{
			return disks.isEmpty();
		}

		public void moveTop(Tower buffer)
		{
			if(disks.isEmpty())
			{
				return;
			}
			if (isValid(this, buffer))
			{
				buffer.push(this.pop());
			}
		}

		public void moveAll(Tower buffer)
		{
			while(!isEmpty())
			{
				if (isValid(this, buffer))
				{
					buffer.push(this.pop());
				}
				else
					return;
			}
		}

		public Boolean isValid(Tower a, Tower b)
		{
			if(b.isEmpty())
			{
				return true;
			}

			if(b.peek() < a.peek())
			{
				return false;
			}
			else
				return true;

		}

		public void moveTopTwo(Tower c, Tower buffer)
		{
			moveTop(buffer);
			moveTop(c);
			buffer.moveTop(c);
		}

		public void display()
		{
			System.out.println(Arrays.toString(disks.toArray()));
		}
	}

	public static void towersHanoi(Tower source, Tower buffer, Tower target, int size)
	{
		if (size == 1)
		{
			source.moveTop(target);
			return;
		}
		if (size == 2)
		{
			source.moveTopTwo(target, buffer);
			return;
		}
		towersHanoi(source, target, buffer, size-1);
		source.moveTop(target);
		towersHanoi(buffer, source, target, size-1);
	}

	public static void main(String[] args)
	{
		Tower a = new Tower();
		Tower b = new Tower();
		Tower c = new Tower();

		a.push(3);
		a.push(2);
		a.push(1);

		a.display();
		b.display();
		c.display();

		towersHanoi(a,b,c,3);

		a.display();
		b.display();
		c.display();
	}
}