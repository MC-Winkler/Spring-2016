
public class LinkedList {

	protected Data head;
	protected Data tail;

	
	public void appendNewTail(Data data) {
		System.out.println("Appending to tail node " + data);
		if (head == null){
			head = data;
			tail = data;
		}
		else{
			tail.after = data;
			data.before = tail;
			tail = data;
		}
	}
	
	public void remove(Data data){
		System.out.println("removing node " + data);
		if (data == head){
			head = data.after;
			data.after.before = null;
			data.after = null;
		}
		else if(data == tail){
			tail = data.before;
			data.before.after = null;
			data.before = null;
		}
		else {
			
			data.before.after = data.after;
			data.after.before = data.before;
		}
		data.cached = false;
	}
	
	public void replace (Data toReplace, Data newData){
		System.out.println("replacing " + toReplace + " with " + newData);
		if (toReplace == head){
			newData.before = null;
			newData.after = toReplace.after;
			toReplace.before = newData;
			head = newData;
		}
		
		else if(toReplace == tail){
			newData.before = toReplace.before;
			newData.after = null;
			toReplace.after = newData;
			tail = newData;
		}
		else {
			toReplace.before.after = newData;
			toReplace.after.before = newData;
			newData.after = toReplace.after;
			newData.before = toReplace.before;
		}
		toReplace.cached = false;
	}

	public void removeHead() {
		System.out.println("Removing the head");
		Data tempData = head;
		head = head.after;		
		tempData.after = null;
		tempData.cached = false;
	}
}
