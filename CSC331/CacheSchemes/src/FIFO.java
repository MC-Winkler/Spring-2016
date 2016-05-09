import java.util.HashMap;

/*
 * First in first out.  This scheme replaces the data
 * that has been in the cache the longest.
 */

public class FIFO extends CacheScheme {

public int numCollisions(int cacheSize, String word) {
		int numCollisions = 0;
		int stillFillingCache = 0;
		
		LinkedList theList = new LinkedList();
		HashMap<Character, Data> theMap = new HashMap<Character, Data>();
		Data firstIn = theList.head;


		for (char x : word.toCharArray()) {
			if (theMap.get(x) == null) {
				Data newData = new Data();
				newData.letter = x;
				theMap.put(x, newData);
			}

			Data currentData = theMap.get(x);
			if (stillFillingCache < cacheSize && currentData.cached == false) {
				firstIn = theList.head;
				theList.appendNewTail(currentData);
				currentData.cached = true;
				stillFillingCache++;

			}

			else {
				if (currentData.cached == false){
					currentData.cached = true;
					theList.replace(firstIn, currentData);
					firstIn = currentData.after;
					numCollisions++;
				}
			}
		}
		return numCollisions;
	}
}
