
public class LinkedElem {
	
	//class attribute
	private int val;
	private LinkedElem next;
	private LinkedElem previous;
	
	/*
	 * @role: constructor of the class
	 */
	public LinkedElem(int v, LinkedElem n, LinkedElem p){
		
		this.val = v;
		this.next = n;
		this.previous = p;
	}
	
	public LinkedElem(int v) {
		
		this.val = v;
		this.next = null;
		this.previous=null;
	}
	
	/*
	 * @role: returns the value of the element
	 */
	public int get_val() {
		return this.val;
	}
	
	/*
	 * @role: returns the next element of the Linked list
	 */
	public LinkedElem get_next() {
		return this.next;
	}
	
	/*
	 * @role: returns the previous element of the Linked list
	 */
	public LinkedElem get_previous() {
		return this.previous;
	}
	
	/*
	 * role: changes the value of the element
	 * input: the new value of the element
	 */
	public void changeVal(int v) {
		this.val = v;
	}
	
	public void setNext(LinkedElem elem) {
		
		this.next = elem;
	}
	
	public void setPrevious(LinkedElem elem) {
		
		this.previous = elem;
	}
	

}
