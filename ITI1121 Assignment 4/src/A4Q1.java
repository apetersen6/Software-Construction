
public class A4Q1 {
	
	public static <T extends Comparable<T>> boolean equals(LinkedList<T> xs, LinkedList<T> ys){
		
		int check = 0;
		
		if(xs == null && ys == null){ //if both lists are empty returns true
			return true;
		}
		else if(xs == null || ys == null){ //if one of the lists is empty and the other isn't, returns false
			return false;
		}
		else if(xs.size() == 0 && ys.size() == 0){ //if both lists have a size of 0, returns true
			return true;
		}
		else if(xs.size() == ys.size()){
			
			Iterator<T> i = xs.iterator(); //iterator for the first list
			Iterator<T> j = ys.iterator(); //iterator for the second list
			
			while(i.hasNext() && j.hasNext()){ //continue loop while iterators still contains elements
				
				if(i.next().toString().compareTo(j.next().toString()) == 0){
					check++; //if both iterators values are the same, increment the counter
				}

			}
			
			if(check == xs.size()){
				return true; //if the count is equal to the size of the lists that means all elements were equal
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}
