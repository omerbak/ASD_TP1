
public class mainLinked {
	
	static void printLinkedList(LinkedList list) {
		LinkedElem current = list.get_head();
		
		for(int i=0; i<list.get_size(); i++) {
			
			System.out.println(current.get_val());
			
			current = current.get_next();
		}
	}

	public static void main(String[] args) {
		
		System.out.println("testing the constructor that creat a list with random values");
		
		LinkedList list = new LinkedList(10);
		printLinkedList(list);
		
		System.out.println("adding values at the start");
		System.out.println("adding 0");
		list.addElemHead(0);
		printLinkedList(list);
		
		System.out.println("adding values at the end");
		System.out.println("adding 12");
		list.addElemTail(12);
		printLinkedList(list);
		
		
		System.out.println("testing get_elem(int ind)");
		LinkedElem elem = list.get_elem(0);
		System.out.println("ecpected 0 got " + elem.get_val());
		list.addElemHead(1);
		list.addElemHead(2);
		elem = list.get_elem(2);
		System.out.println("ecpected 0 got " + elem.get_val());
		
		
		
		
		
		
		return;

	}

}
