package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class Graph {
	
	public static void main(String args[]) throws Exception{
		Graph g = new Graph();
		g.setUpGraph();
		g.dfs();
		g.printEdgeLists();
	}
	
	private AdjacencyList adj;
	//set of all the nodes 
	private Set<Node> nodeList;
	
	//list of all of the TREE edges 
	private ArrayList<String> edgeList;
	//list of all other kinds of edges, they're naughty 
	private ArrayList<String> badEdgeList;
	private int time;
	
	public Graph(){
		adj = new AdjacencyList();
		nodeList = new HashSet<Node>();
		edgeList = new ArrayList<String>();
		badEdgeList = new ArrayList<String>();
	}

	/**
	 * DFS implemented as seen on page 604 on CLRS
	 */
	public void dfs(){
		time = 0;
		for(Node u : nodeList){
			if(u.getColor().equals("WHITE")){
				u.setDistance(0);
				dfsVisit(u);
			}
		}
	}
	
	private void dfsVisit(Node u){
		time++;
		u.setColor("GRAY");
		u.setDiscoveredTime(time);
		System.out.println(u);
		Map<Node, Integer> neighbours = adj.get(u);
		for(Entry <Node, Integer> neighbourEntry : neighbours.entrySet()){
			Node v = neighbourEntry.getKey();
			if(v.getColor().equals("WHITE")){
				edgeList.add(String.format("(%s, %s)", u.getName(), v.getName()));
				v.setParent(u);
				v.setDistance(u.getDistance() + neighbourEntry.getValue());
				System.out.println(v);
				dfsVisit(v);
			} else {
				badEdgeList.add(String.format("(%s, %s)", u.getName(), v.getName()));
			}
		}
		u.setColor("BLACK");
		time++;
		u.setFinishedTime(time);
		System.out.println(u);
	}
	
	private static void printPath(Node n){
		Stack<Node> s = new Stack<Node>();
		while(n != null){
			s.add(n);
			n = n.getParent();
		}
		
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	private void printEdgeLists(){
		//PRINT OUT MY EDGE LISTS 
		String goodEdge = "";
		for(String s : edgeList){
			goodEdge+= s + ",";
		}
		goodEdge = goodEdge.substring(0, goodEdge.length()-1);
		System.out.println(goodEdge);
		
		String badEdge = "";
		for(String s : badEdgeList){
			badEdge += s + ",";
		}
		badEdge = badEdge.substring(0, badEdge.length()-1);
		System.out.println(badEdge);
	}
	
	
	/**
	 * Sets the graph up with Figure 22.6 from CLRS
	 * @throws Exception 
	 */
	public void setUpGraph() throws Exception{
		Node q = new Node("q");
		Node r = new Node("r");
		Node s = new Node("s");
		Node t = new Node("t");
		Node u = new Node("u");
		Node v = new Node("v");
		Node w = new Node("w");
		Node x = new Node("x");
		Node y = new Node("y");
		Node z = new Node("z");
		
		nodeList.add(q);
		nodeList.add(r);
		nodeList.add(s);
		nodeList.add(t);
		nodeList.add(u);
		nodeList.add(v);
		nodeList.add(w);
		nodeList.add(x);
		nodeList.add(y);
		nodeList.add(z);
		
		adj.addNode(q);
		adj.addNode(r);
		adj.addNode(s);
		adj.addNode(t);
		adj.addNode(u);
		adj.addNode(v);
		adj.addNode(w);
		adj.addNode(x);
		adj.addNode(y);
		adj.addNode(z);
		
		adj.addEdge(q, s, 1);
		adj.addEdge(q, t, 1);
		adj.addEdge(q, w, 1);
		
		adj.addEdge(s, v, 1);
		
		adj.addEdge(v, w, 1);
		
		adj.addEdge(w, s, 1);
		
		adj.addEdge(t, x, 1);
		adj.addEdge(t, y, 1);
		
		adj.addEdge(x, z, 1);
		
		adj.addEdge(z, x, 1);
		
		adj.addEdge(y, q, 1);
		
		adj.addEdge(r, u, 1);
		adj.addEdge(r, y, 1);

		adj.addEdge(u, y, 1);
	}
	

}
