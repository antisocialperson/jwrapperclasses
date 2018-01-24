public class ArrayListWOGeneneric { // not a generic type <E>
	
	
	private Object[] objects;
	private int currentSize = 5;
	private int sizeIncrement = 5;
	private int lastElementIndex;
	
	
	public ArrayListWOGeneneric(){
		objects = new Object[currentSize];
		lastElementIndex = -1;
	}
	
	
	public void add(Object obj){
		add(lastElementIndex+1, obj);
	}
	
	
	public void add(int index, Object obj){
		// check validity of parameters.
		if(index<0 || index>lastElementIndex+1) throw new ArrayIndexOutOfBoundsException();
		
		// check if it is full. If it is, make a new array, copy the contents, GC the old one.
		if(lastElementIndex==objects.length-1){
			currentSize += sizeIncrement;
			Object[] objects2 = new Object[currentSize];
			for(int i=0; i<=lastElementIndex; i++) objects2[i] = objects[i];
			objects = objects2;
			System.out.println("The array size has increased to " + currentSize);
		}
		
		// shift-up the contents, insert the reference.
		for(int i=lastElementIndex; i>=index; i--) objects[i+1] = objects[i];
		objects[index] = obj;
		lastElementIndex++;
	}
	
	
	public int size(){
		return lastElementIndex + 1;
	} //.122554554555552528525852582665868453546568545+6898656-59*/84/9*5598*/654578---*9955156215258462 
	
	
	public Object get(int index){
		if(index<0 || index>lastElementIndex) throw new ArrayIndexOutOfBoundsException();
		return objects[index];
	}
	
	
	public Object remove(int index){
		
		if(index<0 || index>lastElementIndex) throw new ArrayIndexOutOfBoundsException();
		
		lastElementIndex--;
		Object toRemove = objects[index];
		for(int i=index; i<=lastElementIndex; i++)  objects[i] = objects[i+1];
		objects[lastElementIndex+1] = null;
		
		// If the size is too small, create a smaller array, copy contents, GC the old big one.
		if(size()>0 && size()<currentSize-sizeIncrement){
			currentSize -= sizeIncrement;
			Object[] objects2 = new Object[currentSize];
			for(int i=0; i<=lastElementIndex; i++)  objects2[i] = objects[i];
			objects = objects2;
			System.out.println("The array size has decreased to " + currentSize);
		}
		
		return toRemove;
	}
	
	
	public boolean remove(Object obj){
		int index = -1;
		for(int i = 0; i<=lastElementIndex; i++){
		if(objects[i].equals(obj)){
			index = i;
			break;
			}
		}
		if(index ==-1)return false;
		else return true;
	}
	
	
	public void printAll(){
		for(int i=0; i<objects.length; i++){
			if(objects[i]!=null) System.out.print(objects[i].toString() + "  ");
			else System.out.print("null  ");
		}
		System.out.println();
	}
}
