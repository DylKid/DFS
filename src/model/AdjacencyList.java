package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AdjacencyList {
	
	private Map<Node, Map<Node, Integer>> adj;
	
	public AdjacencyList(){
		adj = new HashMap<Node, Map<Node,Integer>>();
	}
	
	public Set<Node> getVerticies(){
		return adj.keySet();
	}
	
	public void addNode(Node node){
		if(!adj.containsKey(node)){
			adj.put(node, new HashMap<Node,Integer>());
		} 
	}
	
	public void removeNode(Node node){
		adj.remove(node);
	}
	
	public Map<Node, Integer> get(Node node){
		return adj.get(node);
	}
	
	
	public void addEdge(Node node1, Node node2, Integer Integer) throws Exception{
		Map<Node, Integer> node1Map = adj.get(node1);
		if(node1Map!=null){
			node1Map.put(node2, Integer);
		} else {
			System.out.println("ADD FAILED");
			throw new Exception("node1 does not exist in adj");
		}
	}
	
	public void addEdge(String node1, String node2, Integer weight) throws Exception{
		Node n1 = new Node(node1);
		Node n2 = new Node(node2);
		Map<Node, Integer> node1Map = adj.get(n1);
		if(node1Map!=null){
			node1Map.put(n2, weight);
		} else {
			throw new Exception("node1 does not exist in adj");
		}
	}
	
	public Integer getEdge(Node node1, Node node2){
		return adj.get(node1).get(node2);
		
	}
	
	@Override
	public String toString(){
		String ret = "";
		for(Entry<Node, Map<Node,Integer>> entry : adj.entrySet()){
			ret += entry.getKey() + "=>";
			for(Entry<Node, Integer> e : entry.getValue().entrySet()){
				ret+= "(" + e.getKey() + " : " + e.getValue() + "),";
			}
			ret+= "\n";
		}
		return ret;
	}
	

}
