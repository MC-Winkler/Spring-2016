import java.util.HashMap;

/*
 * Least recently used cache algorithm
 * 
 * This algorithm replaces the data in the cache 
 * with the oldest last request.
 */


public class LRU extends CacheScheme {
	
public int numCollisions(int cacheSize, String word) {
		
		int numCollisions = 0;
		int stillFillingCache = 0;
		
		LinkedList theList = new LinkedList();
		HashMap<Character, Data> theMap = new HashMap<Character, Data>();
		
		for (char x : word.toCharArray()) {
			if (theMap.get(x)== null){
				Data newData = new Data();
				newData.letter = x;
				theMap.put(x, newData);
			}
			
			Data currentData = theMap.get(x);
			
			if (stillFillingCache < cacheSize && currentData.cached == false){
				theList.appendNewTail(currentData);
				currentData.cached = true;
				stillFillingCache++;
			}
			
			else {
				if (currentData.cached == false){
					currentData.cached = true;
					theList.removeHead();
					theList.appendNewTail(currentData);
					numCollisions++;
				}
				else {
					theList.remove(currentData);
					theList.appendNewTail(currentData);
				}
			}

		}
		return numCollisions;
	}
}

