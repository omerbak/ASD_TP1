
public class mainLinked {
	
	static void printLinkedList(LinkedList list) {
		LinkedElem current = list.get_head();
		
		for(int i=0; i<list.get_size(); i++) {
			
			System.out.println(current.get_val());
			
			current = current.get_next();
		}
	}
	
	public static void merge(LinkedList list, int l, int m, int r) {
		
		 int indL = l;
		 int indR = m+1;
		 
		 int tailleS1 = m-l+1 ;
		 int tailleS2 = r - m;
		 
		 for(int i=indL; i<indL+tailleS1; i++) {
			 
			 
			 for(int j=indR+tailleS2-1 ; j>indR-1 ; j--) {
				 
				 int valS1 = list.get_elem(i).get_val();
				 int valS2 = list.get_elem(j).get_val();
				 
				 if(valS1 > valS2) {
					 int tmp;
					 tmp = valS1;
					 list.get_elem(i).changeVal(valS2);
					 list.get_elem(j).changeVal(tmp) ;
					 
				 }
				 
			 }
			
		 }
	}
	
	public static void merge_sep(LinkedList list, int l, int m, int r) {
		
		int tailleS1 = m-l+1 ;
		int tailleS2 = r - m;
		
		LinkedList S1 = new LinkedList();
		LinkedList S2 = new LinkedList();
		
		for(int i=0; i<tailleS1; i++) {
			S1.addElemTail(list.get_elem(l+i));
			
		}
		
		for(int i=0; i<tailleS2; i++) {
			S2.addElemTail(list.get_elem(m+1+i));
		}
		
		int i=0 ; //indice de S1
		int j=0 ; //indice de S2
		int k=l; //indice de tab
		
		while(i<tailleS1 && j<tailleS2) {
			
			int valS1 = S1.get_elem(i).get_val();
			int valS2 = S2.get_elem(j).get_val();
			
			if(valS1 <= valS2) {
				list.get_elem(k).changeVal(valS1);
				i++;
				k++;
			}else {
				list.get_elem(k).changeVal(valS2);
				j++;
				k++;
			}
			
		}
		
		while(i<tailleS1) {
			int valS1 = S1.get_elem(i).get_val();
			list.get_elem(k).changeVal(valS1);
			i++;
			k++;
			
		}
		
		while(j<tailleS2) {
			
			int valS2 = S2.get_elem(j).get_val();
			list.get_elem(k).changeVal(valS2);
			j++;
			k++;
			
		}
		
	}
	
	public static void sort(LinkedList list, int l, int r) {
		
		if( l < r) {
			int m = l + (r - l) / 2;
			sort(list, l, m);
			sort(list, m+1, r);
			merge(list, l, m, r);
			
		}
	}
	
	public static void sort_sep(LinkedList list , int l , int r) {
		if(l < r) {
			
			int m = l + (r - l) / 2;
			sort_sep(list, l, m);
			sort_sep(list, m+1, r);
			merge_sep(list, l, m, r);
		}
	}

	public static void main(String[] args) {
		
		System.out.println("testing the constructor that creat a list with random values");
		
		LinkedList list = new LinkedList(4);
		printLinkedList(list);
		
		/*
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
		*/
		
		/*
		System.out.println("testing divideList");
		LinkedList S1 = new LinkedList();
		LinkedList S2 = new LinkedList();
		
		list.divideList(S1, S2);
		
		System.out.println("print S1");
		printLinkedList(S1);
		
		System.out.println("print S2");
		printLinkedList(S2);
		*/
		
		
		/*
		System.out.println("test sort without a copy");
		sort(list, 0, 9);
		printLinkedList(list);
		*/
		
		System.out.println("test sort with copying");
		sort_sep(list, 0, list.get_size()-1);
		printLinkedList(list);
		
		
		
		return;

	}

}
