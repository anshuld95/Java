import java.util.LinkedList;
import java.util.Stack;

public class routebtwNodes extends graph {
	public static Boolean rtebtwNodes(graph g, char a, char b)
	{
		if (! (g.vertices.containsKey(a) || g.vertices.containsKey(b)) )
		{
			System.out.println("error");
			return false;
		}
		Stack<Vertex> s = new Stack<Vertex>();
		Vertex v = g.vertices.get(a);
		v.isVisited = true;
		System.out.println("pushing: " + v.getLabel() );
		s.push(v);
		while(!s.isEmpty())
		{
			System.out.println("popping: " + s.peek().getLabel() );
			Vertex x = g.vertices.get(s.pop().getLabel());
			if (x.getLabel() == b)
			{
				g.resetVisited();
				return true;
			}
			for(Edge e : x.getadj())
			{
				System.out.print(e.display());
				if(e.getTarget().isVisited == false)
				{
					e.getTarget().isVisited = true;
					System.out.println("pushing: " + e.getTarget().getLabel() );
					s.push(e.getTarget());
				}
			}
		}
		g.resetVisited();
		return false;
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
		System.out.println(rtebtwNodes(g, 'a', 'e'));
	}
}