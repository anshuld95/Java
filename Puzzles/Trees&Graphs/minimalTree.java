public class minimalTree {
	public static class BST {
		public Node root;

		public static class Node {
			private int data;
			private Node right;
			private Node left;

			public Node(int d) {
				data = d;
				right = null;
				left = null;
			}

			public int getData() {
				return this.data;
			}
		}

		public BST() {
			root = null;
		}

		public Boolean isEmpty() {
			if(root == null)
			{
				return true;
			}
			else
				return false;
		}

		public void insert(int d)
		{
			Node newNode = new Node(d);
			if (this.isEmpty())
			{
				//System.out.println("root is now: " + d);
				root = newNode;
			}
			else 
			{
				Node curr = root;
				while(curr!=null)
				{
					if(curr.getData() > d)
					{
						if(curr.left == null)
						{
							//System.out.println("adding " + d);
							curr.left = newNode;
							return;
						}
						else
							curr = curr.left;
					}
					else
					{
						if(curr.right == null)
						{
							//System.out.println("adding " + d);
							curr.right = newNode;
							return;
						}
						else
							curr=curr.right;
					}
				}
				return;
			}
		}

		public void display(Node root)
		{
			if(root == null)
			{
				return;
			}
			System.out.print(root.getData());
			display(root.left);
			display(root.right);

		}
	}

	public static void minimalTree(BST b, int[] sortedArr, int start, int end)
	{
		//System.out.println("Start is:" + start);
		//System.out.println("end is:" + end);
		if(start>end)
		{
			return;
		}
		int mid = (start+end)/2;
		//System.out.println(sortedArr[mid]);
		b.insert(sortedArr[mid]);
		minimalTree(b, sortedArr, start, mid-1);
		minimalTree(b, sortedArr, mid+1, end);
	}

	public static void main(String[] args)
	{
		BST b = new BST();
		int[] myArr = new int[] {1,2,3,4,5};
		minimalTree(b,myArr,0,4);
		b.display(b.root);

	} 

}

