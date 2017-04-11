public class BinaryTree{
	private Node root;

	public BinaryTree()
	{
		root = null;
	}

	public static class Node
	{
		int data;
		Node left;
		Node right;

		public String toString()
		{
			return Integer.toString(data);
		}
	}

	public Node find(int key)
	{
		Node current = root;
		while(current != null)
		{
			if (current.data == key)
			{
				return current;
			}
			else if(current.data > key)
			{
				current = current.left;
			}
			else
				current = current.right;
		}
		System.out.println("Here");
		return null;
	}



	public void insert(int key)
	{
		Node newNode = new Node();
		newNode.data = key;
		Node current = root;
		Node parent = null;
		if(root==null)
		{
			root = newNode;
		}
		else
		{
			while(current!=null)
			{
				parent = current;
				if(current.data > key)
				{
					current = current.left;
				}
				else
					current = current.right;
			}
			if(parent.data > key)
			{
				parent.left = newNode;
			}
			else
				parent.right = newNode;
		}
	}

	public void inOrder(Node myNode)
	{
		if(myNode == null)
		{
			return;
		}
		inOrder(myNode.left);
		System.out.println(myNode.data + " ");
		inOrder(myNode.right);
	}

	public static void main(String[] args)
	{
		BinaryTree myTree = new BinaryTree();
		myTree.insert(4);
		myTree.insert(2);
		myTree.insert(3);
		myTree.insert(7);
		myTree.insert(8);

		//Test traversal
		myTree.inOrder(myTree.root);

		//Test find
		//System.out.println(myTree.find(3));




	}



}