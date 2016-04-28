public class DijkstraVertex extends Vertex implements Comparable<DijkstraVertex>{

	private double distance;
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public DijkstraVertex(String name) {
		super(name);
		this.distance = Double.POSITIVE_INFINITY;
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
