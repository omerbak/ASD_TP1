import java.util.concurrent.ThreadLocalRandom;

public class fusion {
	
	static void random_int_list(int n , int [] tab ) {
		
		int min = 0;
		int max = 50;
		
		for(int i=0 ; i<n ; i++) {
			
			int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			
			tab[i] = randomNum;
			
			
		}
		
		
	}
	
	
	static void printTab (int [] tab) {
		
		for( int i=0; i<tab.length ; i++) {
			System.out.println(tab[i]);
		}
	}

	
	
	static void merge_sep(int [] tab , int l , int m , int r) {
		
		int tailleS1 = m-l+1 ;
		int tailleS2 = r - m;
		
		int [] S1 = new int [tailleS1];
		int [] S2 = new int [tailleS2];
		
		for(int i=0; i<tailleS1 ; i++) {
			S1[i] = tab[l+i];
		}
		
		for(int i=0; i<tailleS2 ; i++) {
			S2[i] = tab[m+1+i];
		}
		
		int i=0 ; //indice de S1
		int j=0 ; //indice de S2
		int k=l; //indice de tab
		
		while(i<tailleS1 && j<tailleS2) {
			if(S1[i]<= S2[j] ) {
				tab[k] = S1[i];
				i++;
				k++;
			}else {
				tab[k] = S2[j];
				k++;
				j++;
			}
			
		}
		
		while(i<tailleS1) {
			
			tab[k] = S1[i];
			i++;
			k++;
			
		}
		
		while(j<tailleS2) {
			
			tab[k] = S2[j];
			j++;
			k++;
			
		}
		
		
		
		
		
	}
	
	static void merge (int [] tab , int l , int m , int r) {
		
		 int indL = l;
		 int indR = m+1;
		 
		 int tailleS1 = m-l+1 ;
		 int tailleS2 = r - m;
		 
		 for(int i=indL; i<indL+tailleS1; i++) {
			 
			  
			 for(int j=indR+tailleS2-1 ; j>indR-1 ; j--) {
				 
				 if(tab[i] > tab[j]) {
					 int tmp;
					 tmp = tab[i];
					 tab[i] = tab[j];
					 tab[j] = tmp ;
						 
				 }
				 
			 }
				 
			 
			
		 }
	}
	
	static void sort_sep (int [] tab , int l, int r) {
		
		if(l < r) {
			int m = l + (r - l) / 2;
			
			sort_sep(tab,l,m);
			
			sort_sep(tab,m+1,r);
			
			merge_sep(tab,l,m,r);
			
		}else {
			return;
		}
	}
	
	static void sort (int [] tab , int l, int r) {
		
		if(l < r) {
			int m = l + (r - l) / 2;
			
			sort(tab,l,m);
			
			sort(tab,m+1,r);
			
			merge(tab,l,m,r);
			
		}else {
			return;
		}
	}
	
	
public static void main(String[] args) {
		
		int n = 50;
		int [] tab = new int [50];
		
		random_int_list(n,tab);
		System.out.println("before");
		printTab(tab);
		
		/*
		sort_sep(tab,0,tab.length-1);
		System.out.println("after");
		printTab(tab);
		*/
		
		sort(tab,0,tab.length-1);
		System.out.println("after");
		printTab(tab);

		

	}

}
