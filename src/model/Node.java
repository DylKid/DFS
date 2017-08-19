package model;


public class Node implements Comparable<Node>{
	
	private int distance;
	private String name;
	private String color;
	private boolean visited;
	private Node parent;
	private int discoveredTime;
	private int finishedTime;
	
	public Node(String name){
		this.name = name;
		distance = Integer.MAX_VALUE;
		visited = false;
		parent = null;
		color = "WHITE";
		discoveredTime = -1;
		finishedTime = -1;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void visit() {
		this.visited = true;
	}
	
	@Override
	public String toString(){
		return String.format("%s => distance:%s color:%s discoveredTime:%s finishedTime:%s", name, distance, color, discoveredTime, finishedTime);
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Node){
			Node n1 = (Node) o;
			if(n1.getName().equals(this.getName())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		prime += name.hashCode();
		return prime;
	}

	@Override
	public int compareTo(Node n1) {
		if(n1.distance < this.distance){
			return 1;
		} else if(n1.distance > this.distance){
			return -1;
		} else {
			return 0;
		}
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public void reset(){
		this.parent = null;
		this.visited = false;
		this.distance = Integer.MAX_VALUE;
	}

	public int getDiscoveredTime() {
		return discoveredTime;
	}

	public void setDiscoveredTime(int discoveredTime) {
		this.discoveredTime = discoveredTime;
	}

	public int getFinishedTime() {
		return finishedTime;
	}

	public void setFinishedTime(int finishedTime) {
		this.finishedTime = finishedTime;
	}

}
