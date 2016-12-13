import java.util.Random;


public class RandomPermutation {

	private int rows;
	private int columns;
	public int[] random;
	 
	public RandomPermutation(int row, int column){

		this.rows = row;
		this.columns = column;
		random = this.toArray();
		
	}
	
	public int[] toArray(){ //converts the RandomPermutation to an array from 1 to 8 where 0 is the final position
		
		int[] temp = new int[rows*columns];
		int x = 0;
		
		for(int i = 0; i<temp.length-1; i++){
			if(x == 9){
				temp[i] = 0;
			}
			else{
				temp[i] = x+1;
			}
			x++;
		}
		
		return temp;
	}
	
	public void shuffle(){ //shuffles the array randomly
		
		int[] ar = this.toArray();
		Random rnd = new Random();
		int temp;
		
		for(int i = 0; i<ar.length-1; i++){
			int r = rnd.nextInt(ar.length-1);
			
			temp = ar[r];
			ar[r] = ar[i];
			ar[i] = temp;
			
		}
		
		this.random = ar;
	}
	
	public String toString(){ //toString() method
		
		String temp = "";
		int lb = 0;
		int[] ar = this.random;

		for(int i = 0; i < ar.length; i++){
			if(lb == 2){
				temp = temp + "[" + ar[i] + "] \n";
				lb = 0;
			}
			else{
				temp = temp + "[" + ar[i] + "]";
				lb++;
			}
		}
		
		return temp;
	}
		
}
