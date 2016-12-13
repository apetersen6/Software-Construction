// Author: Andreas Petersen
// Student number: 6394911
// Course: ITI 1121B
// Assignment: 1

public class FeatureVector {
	
	String fvName;
	int fvSize;
	static boolean verbose = false;
	double[] features;
		
	public FeatureVector(String name, int size){ //Constructor for a FeatureVector with an array filled with 0.0s
		this.fvName = name;
		this.fvSize = size;
		this.features = new double[size];		
	}
	
	public FeatureVector(String name, double elems[]){ //Constructor for a FeatureVector with a specified array
		this.fvName = name;
		this.features = elems;
	}
	
	public String getName(){ //Return the name of this FeatureVector
		return this.fvName;
	}
	
	public int getSize(){ //Return the size of this FeatureVector
		return this.features.length;
	}
	
	public double featureAt(int index){ //Returns the feature at a given index of this FeatureVector
		double value = features[index];
		return value;
	}
	
	public void featureSet(int index, double value){ //Sets a specific value and a given index in this FeatureVector
		features[index] = value;
	}
	
	public FeatureVector copy(){ //Creates a hard copy of this FeatureVector
		FeatureVector copy = new FeatureVector(this.getName(), this.getSize());
		for(int index=0; index<this.getSize(); index++){
			copy.featureSet(index, this.featureAt(index));
		}
		return copy;
	}
	
	public double getDistance(FeatureVector other){ //Calculates the Euclidean Distance between two FeatureVectors
		double sum = 0.0;
		
		for(int index=0; index<other.getSize(); index++){
			sum = sum + Math.pow((this.featureAt(index) - other.featureAt(index)), 2);
		}
		return Math.sqrt(sum);
	}
	
	public void plus(FeatureVector other){ //Adds another FeatureVector to this one
		if(this.getSize() <= other.getSize()){	
			for(int index=0; index<this.getSize(); index++){
				this.featureSet(index, this.featureAt(index) + other.featureAt(index));
			}
		}
		else{
			System.out.println("The other feature vector is too small");
		}
	}
	
	public void div(FeatureVector other){ //Divides this FeatureVector by another
		if(this.getSize() <= other.getSize()){	
			for(int index=0; index<this.getSize(); index++){
				this.featureSet(index, this.featureAt(index) / other.featureAt(index));
			}
		}
		else{
			System.out.println("The other feature vector is too small");
		}	
	}
	
	public void div(double value){ //Divies this FeatureVector by a value
		for(int index=0; index<this.getSize(); index++){
			this.featureSet(index, this.featureAt(index) / value);
		}
	}
	
	public String toString(){ //toString() method
		String temp = this.getName();
		String temp2 = "";
		String temp3 = "";
		int size = this.getSize();
		
		if(verbose == false){
			temp3 = temp;
		}
		else if(verbose == true){
			temp = temp + ": {";
			for(int i=0; i<size; i++){
				temp2 = temp2 + this.featureAt(i) + ", ";
			}
			 temp3 = temp + temp2.substring(0, temp2.length()-2) + "}";
		}
		return temp3;
	}
	
	public boolean equals(FeatureVector other){ //Check to see if two FeatureVectors are equal
		boolean temp = false;
		int compare = 0;
		int size = this.getSize();
		
		for(int index=0; index<this.getSize(); index++){
			if(this.featureAt(index) == other.featureAt(index)){
				compare++;
			}
		}
		
		if(this.getSize() == other.getSize()){
			if(compare == size){
				temp = true;
			}
			else{
				temp = false;
			}
		}
		return temp;
	}
	
	public static void setVerbose(boolean value){ //Sets the verbose variable to true or false changing the toString() output
		if(value = true){
			verbose = true;
		}
		else{
			verbose = false;
		}
	}
}
