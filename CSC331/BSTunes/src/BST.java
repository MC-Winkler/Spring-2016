import java.util.Comparator;


public class BST {
	public BSTNode myRoot;
	private Comparator<Track> myComparator;
	public static int idNum = 0;
	
	public BST(Comparator<Track> comp){
		myComparator = comp;
	}
	
	/*
	 * Insert the given track in the appropriate place in the tree.
	 * It may or may not be necessary to make a completely 
	 * new node.
	 */
	public void insert(Track t){
		BSTNode whereToInsert = treeSearch(t);
        if (whereToInsert==null){
        	
        }
        else{
        	whereToInsert.addTrack(t);
        }
    }
	
	/*
	 * Call printout on each node, in 'inorder' fashion.
	 */
	public void inorderTreeWalk(){
		inorderTreeWalk(this.myRoot);
	}
    
	/*
	 * Call printout on each node, in 'inorder' fashion,
	 * for the tree rooted at the given node.
	 */
    public void inorderTreeWalk(BSTNode n){
       
    }
    
    /*
     * Find the Node that matches the item 
     */
    public BSTNode treeSearch(Track item){
    	return treeSearch(this.myRoot, item);
    }
    
    /*
     * Return the Node in the tree rooted at the given node
     * that matches the given track.
     */
    public BSTNode treeSearch(BSTNode start, Track item){
    	return null;
    }
    
   /*
    * Find the "smallest" node
    */
    public BSTNode treeMin(BSTNode start){
        return null;
    }
    
    /*
     * Find the "biggest" node
     */
    public BSTNode treeMax(BSTNode start){
    	return null;
    }
    
    /*
     * Find the node that is the successor of the given node.
     */
    public BSTNode treeSuccessor(BSTNode start){
        return null;
    }
    
    /*
     * Delete a track.
     */
    public void delete(Track t){
        BSTNode found = treeSearch(myRoot, t);
        if (found != null){
            found.deleteTrack(t);
            if (found.numTracks()==0){
                deleteNode(found);
            }
        }
    }
    
    /*
     * Delete a node from the tree.
     */
    public void deleteNode(BSTNode z){
    	
    }
}
