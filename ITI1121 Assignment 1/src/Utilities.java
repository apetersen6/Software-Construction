// Author: Andreas Petersen
// Student number: 6394911
// Course: ITI 1121B
// Assignment: 1


public class Utilities {

    public static Cluster[] run(FeatureVector[] examples, int k, int trials) {

	Cluster[][] clusters;
	clusters = new Cluster[trials][];

	for (int i = 0; i < trials; i++) {
	    clusters[i] = Clustering.kmeans(examples, k);
	}

	int argMin = 0;
	double min = getSumVariance(clusters[argMin]);

	for (int i = 1; i < trials; i++) {
	    double var = getSumVariance(clusters[i]);
	    if (var < min) {
		min = var;
		argMin = i;
	    }
	}
	
	return clusters[argMin];

    }

    private static double getSumVariance(Cluster[] clusters) {
	double var = 0.0;
	for (Cluster c : clusters) {
	    if (c.getSize() > 0) {
		var += c.getVariance();
	    }
	}
	return var;
    }

}