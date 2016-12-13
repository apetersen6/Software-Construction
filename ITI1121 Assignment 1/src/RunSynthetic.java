// Author: Andreas Petersen
// Student number: 6394911
// Course: ITI 1121B
// Assignment: 1


public class RunSynthetic {

    public static void main(String[] args) {
	
	StudentInfo.display();

	FeatureVector[] examples;
	examples = new FeatureVector[10];

	examples[0] = new FeatureVector("A", new double[] { 0.0, 0.0 });
	examples[1] = new FeatureVector("B", new double[] { 1.0, 1.0 });
	examples[2] = new FeatureVector("C", new double[] { 1.0, 0.0 });
	examples[3] = new FeatureVector("D", new double[] { 2.0, 0.0 });
	examples[4] = new FeatureVector("E", new double[] { 6.0, 4.0 });
	examples[5] = new FeatureVector("F", new double[] { 5.0, 6.0 });
	examples[6] = new FeatureVector("G", new double[] { 7.0, 5.0 });
	examples[7] = new FeatureVector("H", new double[] { 6.0, 6.0 });
	examples[8] = new FeatureVector("I", new double[] { 8.0, 9.0 });
	examples[9] = new FeatureVector("J", new double[] { 8.0, 9.0 });

	FeatureVector.setVerbose(true);

	Cluster[] clusters;
	
	clusters = Utilities.run(examples, 3, 10);
	
	for (Cluster c : clusters) {
	    System.out.println(c);
	}

    }

}