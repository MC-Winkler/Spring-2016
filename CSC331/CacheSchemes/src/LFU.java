import java.util.HashMap;

/*
 * Least frequently used Cache algorithm.
 * This algorithm replaces the piece of data that has the least 
 * number of requests.
 */


public class LFU extends CacheScheme {

	public int numCollisions(int cacheSize, String word){
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
			System.out.println("currentData: " + currentData);
			
			if (stillFillingCache < cacheSize && currentData.cached == false){
				theList.appendNewTail(currentData);
				currentData.cached = true;
				stillFillingCache++;
			}
			if (currentData.cached == false){
				Data iterator = theList.head;
				Data currentLFU = theList.head;
				int LFU = currentLFU.frequency;
				while (iterator != null){
					if (iterator.frequency <= LFU){
						LFU = iterator.frequency;
						currentLFU = iterator;
					}
					iterator = iterator.after;
				}
				
				currentData.cached = true;
				theList.replace(currentLFU, currentData);
				numCollisions++;
			}
			currentData.frequency += 1;
		}
		return numCollisions;
	}
}
