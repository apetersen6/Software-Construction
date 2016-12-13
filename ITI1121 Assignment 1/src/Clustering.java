// Author: Andreas Petersen
// Student number: 6394911
// Course: ITI 1121B
// Assignment: 1


import java.util.Random;

public class Clustering {

	public static Cluster[] kmeans(FeatureVector[] examples, int k){ //Implements the k-means algorithm on a Cluster of FeatureVectors
		Cluster[] d = new Cluster[k];
		Random random = new Random();
		FeatureVector[] clone = examples.clone();
		int max = examples.length-1;
		
		for(int i=0; i<k; i++){
			d[i] = new Cluster(examples.length); //Create k clusters
			
			int rand = random.nextInt(max);
					
			d[i].add(examples[rand]); //Set a random example as the centroid of each cluster
			
			FeatureVector temp = clone[max];
			clone[max] = clone[rand];
			clone[rand] = temp;
			max--;
			
		}
		
		Cluster[] dp = new Cluster[k];
		
		for(int i=0; i<k; i++){
			dp[i] = new Cluster(examples.length); // Create k clusters
		}
		
		for (int i = 0; i < examples.length; i++) { // Add examples to
													// cluster who's
													// centroid is closest
			double[] temp = new double[k];
			double t = Double.MAX_VALUE;
			int u = 0;

			for (int j = 0; j < k; j++) {
				temp[j] = examples[i].getDistance(d[j].getCentroid());

				if (temp[j] < t) {
					u = j;
					t = temp[j];
				}
			}
			dp[u].add(examples[i]);
		}
		
		for(int l=0; l<k; l++){
			if(dp[l].getSize() != d[l].getSize() || dp[l].getCentroid() != d[l].getCentroid()){ //Check if d and dprime are equal
				
				d[l] = dp[l];
				
				for(int i=0; i<k; i++){
					for (int j = 0; j < k; j++) {
						dp[j] = new Cluster(examples.length); // Create k clusters
					}
		
					for (int j = 0; j < examples.length; j++) { // Add examples to
																// cluster who's
																// centroid is closest
						double[] temp = new double[k];
						double t = Double.MAX_VALUE;
						int u = 0;
		
						for (int h = 0; h < k; h++) {
							temp[h] = examples[j].getDistance(d[h].getCentroid());
		
							if (temp[h] < t) {
								u = h;
								t = temp[h];
							}
						}
						dp[u].add(examples[j]);
					}
				}
			}
			else if(dp[l].getSize() == d[l].getSize() || dp[l].getCentroid() == d[l].getCentroid()){
				//do nothing
			}
		}
		
		return d;
	}
}
