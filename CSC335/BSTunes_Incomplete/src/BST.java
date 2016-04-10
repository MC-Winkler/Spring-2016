import java.util.Comparator;

public class BST {
	public BSTNode myRoot;
	private Comparator<Track> myComparator;
	public static int idNum = 0;

	public BST(Comparator<Track> comp) {
		myComparator = comp;
	}

	/*
	 * Insert the given track in the appropriate place in the tree. It may or
	 * may not be necessary to make a completely new node.
	 */
	public void insert(Track t) {
		BSTNode currentNode = myRoot;
		BSTNode parent = currentNode;
		boolean isLeftChild = false;
		while (currentNode != null && myComparator.compare(t,currentNode.getTrack()) !=0){
			parent = currentNode;
			if (myComparator.compare(t, currentNode.getTrack()) < 1) {
				currentNode = currentNode.leftChild;
				isLeftChild = true;
			}
			else{
				currentNode = currentNode.rightChild;
				isLeftChild = false;
			}
		}
		
		if (currentNode == null) {
			if (isLeftChild)
				parent.leftChild = new BSTNode (parent, t, idNum);
			else
				parent.rightChild = new BSTNode (parent, t, idNum);
			idNum ++;
		}
		
		else {
			currentNode.addTrack(t);
		}
	}

	/*
	 * public void insert(Track t){ BSTNode currentNode = myRoot; BSTNode parent
	 * = myRoot; while (currentNode != null && myComparator.compare(t,
	 * currentNode.getTrack())!=0) { parent = currentNode; if
	 * (myComparator.compare(t, currentNode.getTrack())>1) currentNode =
	 * currentNode.rightChild; else currentNode = currentNode.leftChild; } if
	 * (currentNode == null){ currentNode = new BSTNode(parent, t, idNum);
	 * if(myComparator.compare(t, parent.getTrack())>0){
	 * parent.rightChild=currentNode; } else{ parent.leftChild=currentNode; }
	 * idNum++; } else currentNode.addTrack(t); }
	 */

	/*
	 * Call printout on each node, in 'inorder' fashion.
	 */
	public void inorderTreeWalk() {
		inorderTreeWalk(this.myRoot);
	}

	/*
	 * Call printout on each node, in 'inorder' fashion, for the tree rooted at
	 * the given node.
	 */
	public void inorderTreeWalk(BSTNode n) {
		if (n != null) {
			inorderTreeWalk(n.leftChild);
			n.printOut();
			inorderTreeWalk(n.rightChild);
		}
	}

	/*
	 * Find the Node that matches the item
	 */
	public BSTNode treeSearch(Track item) {
		return treeSearch(this.myRoot, item);
	}

	/*
	 * Return the Node in the tree rooted at the given node that matches the
	 * given track.
	 */
	public BSTNode treeSearch(BSTNode start, Track item) {
		if (start == null || myComparator.compare(item, start.getTrack()) == 0) {
			return start;
		}
		if (myComparator.compare(item, start.getTrack()) > 0) {
			treeSearch(start.rightChild, item);
		} else
			treeSearch(start.leftChild, item);

	}

	/*
	 * Find the "smallest" node
	 */
	public BSTNode treeMin(BSTNode start) {
		while (start.leftChild != null)
			start = start.leftChild;
		return start;
	}

	/*
	 * Find the "biggest" node
	 */
	public BSTNode treeMax(BSTNode start) {
		while (start.rightChild != null)
			start = start.rightChild;
		return start;
	}

	/*
	 * Find the node that is the successor of the given node.
	 */
	public BSTNode treeSuccessor(BSTNode start) {
		if (start.rightChild != null) {
			return treeMin(start.rightChild);
		}
		BSTNode y = start.parent;
		while (y != null && start == y.rightChild) {
			start = y;
			y = y.parent;
		}
		return y;
	}

	/*
	 * Delete a track.
	 */
	public void delete(Track t) {
		BSTNode found = treeSearch(myRoot, t);
		if (found != null) {
			found.deleteTrack(t);
			if (found.numTracks() == 0) {
				deleteNode(found);
			}
		}
	}

	/*
	 * Delete a node from the tree.
	 */
	public void deleteNode(BSTNode z) {

	}
}
