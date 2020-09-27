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
	public void addElemTail(LinkedElem elem) {
		
		if(this.head != null) {
		this.tail.setNext(elem);
		elem.setPrevious(this.tail);
		
		this.tail = elem;
		
		this.nbElem++;
		}else {
			//if the list was empty
			this.tail = elem;
			this.head = elem;
			this.nbElem++;
			
		}
		
		
	}
	
	/*
	 * @Role: add element at the end of the list
	 * @input: the value of the element
	 */
	public void addElemTail(int v) {
		
		LinkedElem elem = new LinkedElem(v);
		
		if(this.head != null) {
		this.tail.setNext(elem);
		elem.setPrevious(this.tail);
		
		this.tail = elem;
		
		this.nbElem++;
		}else {
			
			//if the list was empty
			this.tail = elem;
			this.head = elem;
			this.nbElem++;
			
			
		}
		
		
	}
	
	
	/*
	 * @Role: add element at the start of the list
	 * @input: the value of the element
	 */
	public void addElemHead(int v) {
		
		LinkedElem elem = new LinkedElem(v);
		
		if(this.head != null) {
		this.head.setPrevious(elem);
		elem.setNext(this.head);
		
		this.head = elem;
		
		this.nbElem++;
		}else {
			//if the list was empty
			this.tail = elem;
			this.head = elem;
			this.nbElem++;
			
		}
	}
	
	/*
	 * @Role: add element at the start of the list
	 * @input: the element to be added
	 */
	public void addElemHead(LinkedElem elem) {
		
		if(this.head != null) {
		this.head.setPrevious(elem);
		elem.setNext(this.head);
		
		this.head = elem;
		
		this.nbElem++;
		}else {
			//if the list was empty
			this.tail = elem;
			this.head = elem;
			this.nbElem++;
		}
	}
	
	
	//TODOO addElemIndice(int v, int ind)
	
	
	private int indiceHalf() {
		
		if(this.nbElem%2 ==0) {
			return this.nbElem/2;
		}else {
			return (this.nbElem/2)+1; 
		}
	}
	
	/*
	 * @role: divide a LinkedList into two LinkedList
	 * @input: (S1,S2): the two new LinkedList
	 */
	public void divideList(LinkedList S1, LinkedList S2) {
		
		LinkedElem currentList = this.head;
		
		LinkedElem currentS1 = new LinkedElem();
		LinkedElem prevS1 = null;
		
		LinkedElem currentS2 = new LinkedElem();
		LinkedElem prevS2 = null;
		
		
		for(int i=0; i<this.nbElem; i++) {
			
			if(i< this.indiceHalf() ) {
				
				currentS1.changeVal(currentList.get_val());
				S1.addElemTail(currentS1);
				
				if(prevS1 != null) {
					prevS1.setNext(currentS1);
				}
				
				currentS1 = currentS1.get_next();
				
				 if(i < this.indiceHalf()-1) {
					 currentS1 = new LinkedElem();
				 }
				
			}else {
				
				currentS2.changeVal(currentList.get_val());
				S2.addElemTail(currentS2);
				
				if(prevS2 != null) {
					prevS2.setNext(currentS2);
				}
				
				currentS2 = currentS2.get_next();
				
				if(i < this.nbElem-1) {
					 currentS2 = new LinkedElem();
				 }
				
			}
			
			currentList = currentList.get_next();
			
		}
		
	}
	

}
