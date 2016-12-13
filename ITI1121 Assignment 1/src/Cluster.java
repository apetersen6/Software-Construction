// Author: Andreas Petersen
// Student number: 6394911
// Course: ITI 1121B
// Assignment: 1


public class Cluster {
	
	int cap;
	FeatureVector[] cluster;
	
	public Cluster(int capacity){ //Constructor for a Cluster object
		this.cap = capacity;
		this.cluster = new FeatureVector[capacity];
	}
	
	public int getSize(){ //Returns the number of FeatureVectors in this Cluster
	int count = 0;
	
	for(int index=0; index<this.cap; index++){
		if(this.cluster[index] != null){
			count++;
			}
		}
		return count;
	}
	
	public boolean add(FeatureVector elem){ //Adds a FeatureVector to this Cluster
		boolean temp;
		
		if(this.getSize() == this.cap){
			temp = false;
		}
		else{
			temp = true;
			this.cluster[this.getSize()] = elem;
		}
		return temp;
	}
	
	public FeatureVector getElementAt(int index){ //Returns the FeatureVector at an index of this Cluster
		return this.cluster[index];
	}
	
	public FeatureVector getCentroid(){ //Calculates the centroid of this Cluster
		int size = this.cluster[0].getSize();

		FeatureVector centroid = new FeatureVector("Centroid", size);
		double temp = 0;

		for(int index=0; index<size; index++){
			for(int jndex=0; jndex<this.getSize(); jndex++){
				temp = temp + this.cluster[jndex].featureAt(index);
			}
			centroid.featureSet(index, temp/this.getSize());
			temp = 0;
		}
		return centroid;
	}
	
	public double getVariance(){ //Calculates the variance of this Cluster using the centroid
		double variance = 0.0;
		
		for(int index=0; index<this.getSize(); index++){
			variance = variance + Math.pow((this.cluster[index].getDistance(this.getCentroid())), 2);
		}
		return Math.sqrt(variance);
	}
	
	public String toString(){ //toString() method
		String temp = "Cluster: {";
		String temp2 = "";
		String temp3 = "";

		for(int index=0; index<this.getSize(); index++){
			for(int jndex=0; jndex<this.cluster[0].getSize(); jndex++){
				temp3 = temp3 + this.cluster[index].featureAt(jndex) + ", ";
			}
			temp2 = temp2 + this.cluster[index].getName() + ": {" + temp3.substring(0, temp3.length()-2) + "}, ";
			temp3 = "";
		}
		return temp + temp2.substring(0, temp2.length()-2) + "}";
	}
}
