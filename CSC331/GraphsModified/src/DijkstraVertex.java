public class DijkstraVertex extends Vertex implements Comparable<DijkstraVertex>{

	private int distance;
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public DijkstraVertex(String name) {
		super(name);
	}

	@Override
	public int compareTo(DijkstraVertex otherVertex) {
		if (this.distance > otherVertex.distance){
			return 1;
		}
		else if (this.distance == otherVertex.distance){
			return 0;
		}
		else return -1;
	}


}
