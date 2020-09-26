import java.util.concurrent.ThreadLocalRandom;


public class LinkedList {
	//class attribute
	private LinkedElem head;
	private LinkedElem tail;
	private int nbElem;
	
	/*
	 * @role: a basic constructor for an empty list
	 */
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.nbElem = 0;
	}
	
	/*
	 * @role: a constructor with nb random element
	 * @input: the number of random element 
	 */
	public LinkedList(int nb) {
		
		this.nbElem = nb;
		
		//setting the min and max
		int min = 0;
		int max = 50;
		
		//generating the random value
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		//creating the head
		this.head = new LinkedElem(randomNum);
		
		//Initialising prev and current for linking the list
		LinkedElem prev = this.head;
		LinkedElem current;
		
		for(int i=1 ; i<this.nbElem-1 ; i++) {
			
			randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			
			current = new LinkedElem(randomNum);
			
			//connecting the list
			prev.setNext(current);
			current.setPrevious(prev);
			
			prev = current;
		}
		
		randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		this.tail = new LinkedElem(randomNum);
		this.tail.setPrevious(prev);
		
		prev.setNext(this.tail);
		
	}
	
	public LinkedElem get_elem(int ind) {
		
		LinkedElem tmp = this.head;
		
		for(int i =0; i<ind ; i++ ) {
			tmp = tmp.get_next();
		}
		
		return tmp;
	}
	
	public LinkedElem get_head() { return this.head; }
	public LinkedElem get_tail() { return this.tail; }
	public int get_size() { return this.nbElem; }
	
	
	/*
	public void randomVals () {
		
		//setting the min and max
		int min = 0;
		int max = 50;
		
		//generating the random value
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		//creating the head
		this.head = new LinkedElem(randomNum);
		
		//Initialising prev and current for linking the list
		LinkedElem prev = this.head;
		LinkedElem current;
		
		for(int i=1 ; i<this.nbElem-1 ; i++) {
			
			randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			
			current = new LinkedElem(randomNum);
			
			//connecting the list
			prev.setNext(current);
			current.setPrevious(prev);
			
			prev = current;
		}
		
		randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		this.tail = new LinkedElem(randomNum);
		this.tail.setPrevious(prev);
		
		
		
	}
	*/
	
	
	/*
	 * @Role: add element at the end of the list
	 * @input: the value of the element
	 */
	public void addElemTail(int v) {
		
		LinkedElem elem = new LinkedElem(v);
		
		this.tail.setNext(elem);
		elem.setPrevious(this.tail);
		
		this.tail = elem;
		
		this.nbElem++;
		
		
	}
	
	
	/*
	 * @Role: add element at the start of the list
	 * @input: the value of the element
	 */
	public void addElemHead(int v) {
		
		LinkedElem elem = new LinkedElem(v);
		
		this.head.setPrevious(elem);
		elem.setNext(this.head);
		
		this.head = elem;
		
		this.nbElem++;
	}
	
	//TODOO addElemIndice(int v, int ind)
	

}
