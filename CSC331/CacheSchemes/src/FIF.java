import java.util.HashMap;

/*
 * Implements the Furthest In Future Cache algorithm.
 * This algorithm's efficiency doesn't really matter
 * as long as it is tractable.
 * 
 * This is an oracle algorithm, giving a collision lower bounds.
 */

public class FIF extends CacheScheme{
	public int numCollisions(int cacheSize, String word){
		int numCollisions = 0;
		int stillFillingCache = 0;
		
		LinkedList theList = new LinkedList();
		
		char[] wordAsArray = word.toCharArray();
		for (int i = 0; i < wordAsArray.length; i++) {
		}
	}
	
}
