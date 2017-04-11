import java.util.LinkedList;
import java.util.HashMap;

public class graph {
	HashMap<Character, Vertex> vertices;

	public static class Vertex {
		private char label;
		private LinkedList<Edge> adjList;
		public Boolean isVisited;

		public Vertex(char c)
		{
			label = c;
			adjList = new LinkedList<Edge>();
			isVisited = false;
		}

		public LinkedList<Edge> getadj()
		{
			return this.adjList;
		}

		public char getLabel()
		{
			return this.label;
		}

		public void addEdge(Edge e)
		{
			if(adjList.contains(e))
			{
				return;
			}
			adjList.addLast(e);
		}

		public int hashCode() {
			Character c = new Character(this.label);
			return c.hashCode();
		}


		public boolean equals(Object other)
		{
        	if(!(other instanceof Vertex))
        	{
            	return false;
        	}
        	Vertex v = (Vertex)other;
        	return this.label == v.label;
    	}

	}

	public static class Edge {
		private Vertex source;
		private Vertex target;

		public Edge(char a, char b)
		{
			Vertex one = new Vertex(a);
			Vertex two = new Vertex(b);
			source = one;
			target = two;
		}

		public boolean equals(Object other)
		{
        	if(!(other instanceof Edge))
        	{
            	return false;
        	}
        	Edge e = (Edge)other;
        	return e.source == this.source && e.target == this.target;
		}

		public int hashCode()
		{
			Integer c = new Integer((source.getLabel() + target.getLabel()));
        	return c.hashCode();
    	}

    	public Vertex getTarget()
    	{
    		return target;
    	}


		public String display()
		{
			StringBuilder str = new StringBuilder();
			str.append("( ");
			str.append(source.getLabel());
			str.append(" , ");
			str.append(target.getLabel());
			str.append(")");
			return str.toString();

		}
	}

	public graph() 
	{
		vertices = new HashMap<Character, Vertex>();
	}

	public void addVertex(char c)
	{
		Vertex v = new Vertex(c);
		vertices.put(c, v);
	}

	public void addEdge(char a, char b)
	{
		Edge e = new Edge(a,b);
		if(vertices.containsKey(a))
		{
			if(!vertices.get(a).getadj().contains(e))
			{
				vertices.get(a).addEdge(e);
			}
		}
		return;
	}

	public void resetVisited()
	{
		for (Vertex v : vertices.values())
		{
			v.isVisited = false;
		}
	}

	public void display()
	{
		LinkedList<Edge> ll = new LinkedList<Edge>();
		for (char c : vertices.keySet())
		{
			System.out.print(c + " : ");
			ll = vertices.get(c).getadj();
			if(!ll.isEmpty())
			{
				for (Edge e : ll )
				{
					System.out.print(e.display());
				}
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args)
	{
		graph g = new graph();
		char[] myArr = new char[] {'a', 'b', 'c', 'd', 'e'}; 
		for (int i = 0; i < 5; i++)
		{
			g.addVertex(myArr[i]);
		}
		g.addEdge('a', 'b');
		g.addEdge('a', 'c');
		g.addEdge('b', 'c');
		g.addEdge('c', 'd');
		//g.addEdge('d', 'e');
		g.addEdge('e', 'a');
		g.display();
	}
}

