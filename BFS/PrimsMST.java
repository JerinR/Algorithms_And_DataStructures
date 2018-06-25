package bfs;


import java.util.*;


public class PrimsMST {
	private static ArrayList<Integer> adjacencyList[];
	private static ArrayList<Integer> adjacencyList_MST[];
	private static int[][] adjacencyMatrix;
	private static HashMap<Integer,ArrayList<Edge>> edgeWeights;
	static ArrayList<Integer> visited; //To keep a check of all the visited nodes
	static PriorityQueue<Edge> queue; //To get the least weight edge of all the edges connected to the node 
	private static float totalDist = 0;
	private static int componentsOfGraph = 0;
	private static int vertices = 0;
	private static Map<Integer,List> MSTedges;
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		vertices = s.nextInt();
		
		int edges = s.nextInt();
		int start=0;
		adjacencyList = new ArrayList[vertices];
		adjacencyList_MST = new ArrayList[vertices];
		edgeWeights = new HashMap<Integer,ArrayList<Edge>>();
		visited = new ArrayList<Integer>();
		queue = new PriorityQueue<Edge>();
		for(int i=0;i<vertices;i++){
			adjacencyList[i] = new ArrayList<Integer>();
			adjacencyList_MST[i] = new ArrayList<Integer>();
		}
		for(int j=0;j<edges;j++){
			addEdge(s.nextInt()-1,s.nextInt()-1,s.nextFloat());
		}
		System.out.println("Adjacency Matrix of Graph");
		printAdjMatrix(vertices,adjacencyList);
		for(int l=0;l<vertices;l++){
			start = l;
			if(!visited.contains(l)){
				Prim(start);
				componentsOfGraph++;
				System.out.println();
				System.out.println("Weight of MST "+componentsOfGraph +"= "+ totalDist);
				System.out.println("Adjacency Matrix of MST "+ componentsOfGraph);
				printAdjMatrix(vertices, adjacencyList_MST);
				totalDist = 0;
			}
		}
		if(componentsOfGraph>1)
			System.out.println("Graph not connected!!!");
		else
			System.out.println("Graph is connected!!!");		
		
		
	}
	
	/* Method - addEdge
	 * @params - u, v, weight 
	 * @Description - The method creates the graph adding the edges
	 */
	private static void addEdge(int u,int v, float d){
		PrimsMST p = new PrimsMST();
		adjacencyList[u].add(v);
		adjacencyList[v].add(u);
		if(edgeWeights.get(u)==null){
			edgeWeights.put(u,(ArrayList<Edge>) (edgeWeights.containsKey(u)?edgeWeights.get(u).add(p.new Edge(u,v,d)):
				new ArrayList<Edge>()));
			edgeWeights.get(u).add(p.new Edge(u,v,d));
		}
		else
			edgeWeights.get(u).add(p.new Edge(u,v,d));
		
		if(edgeWeights.get(v)==null){
			edgeWeights.put(v,new ArrayList<Edge>());
			edgeWeights.get(v).add(p.new Edge(v,u,d));
		}
		else
			edgeWeights.get(v).add(p.new Edge(v,u,d));
	}
	
	/* Method - Prim
	 * @params - root vertex
	 * @Description - The method finds the minimum spanning tree in the graph
	 */
	private static void Prim(int ele){
		Edge edge; 
		Integer v;
		int j=0;
		PrimsMST p = new PrimsMST();
		queue.add(p.new Edge(ele));
		while(!queue.isEmpty()){
			edge = (Edge) queue.poll();	
			if(j==0)
				j=1;
			else{
				ele = edge.v;
				adjacencyList_MST[edge.u].add(ele);
			}
			if(visited.contains(ele))
				continue;
			visited.add(ele);
			
			//total MST weight
			totalDist += edge.distance;
			Iterator it = adjacencyList[ele].iterator();
			int i=0;
			while(it.hasNext()){
				v = (Integer)it.next();
				Edge newedge = edgeWeights.get(ele).get(i);
				if(!visited.contains(v)){
					
					queue.add(newedge);
					
				}
				i++;
			}
		}
	}
	
	/* Method - printAdjMatrix
	 * @params - number of vertices in the graph
	 * @Description - prints the adjacency matix
	 */
	public static void printAdjMatrix(int vertices,ArrayList<Integer> adjacencyList[]){
		int i = 0;
		adjacencyMatrix = new int[vertices][vertices];
		while(i<adjacencyList.length){
			int j=0;
			Iterator<Integer> it = adjacencyList[i].iterator();
			while(it.hasNext()){
				j = it.next();
				adjacencyMatrix[i][j]=1;
			}
			i++;
		}
		for(int l=0;l<vertices;l++){
			for(int k=0;k<vertices;k++){
				System.out.print(adjacencyMatrix[l][k]+" ");
			}
			System.out.println();
		}
	}
	
	public class Edge implements Comparable<Edge>{
		int u;
		int v;
		float distance;
		public Edge(int u,int v,float distance){
			this.u = u;
			this.v = v;
			this.distance = distance;
		}
		
		public Edge(int u){
			this.u = u;
		}
		@Override
		public int compareTo(Edge e1) {
			// TODO Auto-generated method stub
			if(distance>e1.distance)
				return 1;
			else if(distance<e1.distance)
				return -1;
			return 0;
		}
	}


}

