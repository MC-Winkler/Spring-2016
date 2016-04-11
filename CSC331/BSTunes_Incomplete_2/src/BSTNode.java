import java.util.ArrayList;


public class BSTNode {
	public BSTNode parent;
	public BSTNode leftChild;
	public BSTNode rightChild;
	public ArrayList<Track> tracks;
	public int id;
	
	//create a new node with an id and an empty tracklist
	public BSTNode(int idNum){
		tracks = new ArrayList<Track>();
		id = idNum;
	}
	
	//call the previous constructor, so we don't have to copy lines
	public BSTNode(BSTNode p, Track t, int idNum){
		this(idNum);
		parent = p;
		tracks.add(t);
	}
	
	
	//get all the tracks in a node
	public ArrayList<Track> getTracks(){
		return tracks;
	}
	
	//get the first track held by a node
	public Track getTrack(){
		return tracks.get(0);
	}
	
	//add a track to a node's tracklist
	public void addTrack(Track t){
		tracks.add(t);
	}
	
	//print everything you might want to know about a node
    public void printOut(){
        System.out.println("My id is "+id);
        System.out.println("My track is: ");
        tracks.get(0).prettyPrint();
        if(leftChild == null){
            System.out.println("No left child");
        }
        else{
            System.out.println("My left child is "+leftChild.id);
        }
        if(rightChild == null){
            System.out.println("No right child");
        }
        else{
            System.out.println("My right child is "+rightChild.id);
        }
    }
    
    //checks if a node contains a specific track 
    //(denoted by a track item)
    public boolean contains(Track item){
        for(int i =0; i<tracks.size(); i++){
            Track t = tracks.get(i);
            if (t.equals(item)){
                return true;
            }
        }
        return false;
    }
    
    //check if a node contains a track, 
    //specified by album or artist
    public boolean contains(String key){
    	for (Track t: tracks){
    		if (t.getAlbum().equals(key) || t.getArtist().equals(key) || t.getGenre().equals(key)){
    			return true;
    		}
    	}
    	return false;
    }
    
    //delete a track from a node
    //accepts a track item, not a key
    public void deleteTrack(Track item){
        int index = -1;
        for(int i =0; i<tracks.size(); i++){
            Track t = tracks.get(i);
            if (t.equals(item)){
                index = i;
            }
        }
        if(index != -1){
            tracks.remove(index);
        }
    }
    
    //returns the number of tracks held in a node
    public int numTracks(){
        return tracks.size();
    }
}

