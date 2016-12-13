// Author: Andreas Petersen
// Student number: 6394911
// Course: ITI 1121B
// Assignment: 1


public class RunCars {
    
    public static void main(String[] args) {
	
	StudentInfo.display();
	
	FeatureVector[] examples;
	examples = new FeatureVector[38];

	examples[0]  = new FeatureVector("Buick Estate Wagon", new double[] { 16.9, 4.36, 2.73, 155.0, 350.0, 8.0 });
	examples[1]  = new FeatureVector("Ford Country Squire Wagon", new double[] { 15.5, 4.054, 2.26, 142.0, 351.0, 8.0 });
	examples[2]  = new FeatureVector("Chevy Malibu Wagon", new double[] { 19.2, 3.605, 2.56, 125.0, 267.0, 8.0 });
	examples[3]  = new FeatureVector("Chrysler LeBaron Wagon", new double[] { 18.5, 3.94, 2.45, 150.0, 360.0, 8.0 });
	examples[4]  = new FeatureVector("Chevette", new double[] { 30.0, 2.155, 3.7, 68.0, 98.0, 4.0 });
	examples[5]  = new FeatureVector("Toyota Corona", new double[] { 27.5, 2.56, 3.05, 95.0, 134.0, 4.0 });
	examples[6]  = new FeatureVector("Datsun 510", new double[] { 27.2, 2.3, 3.54, 97.0, 119.0, 4.0 });
	examples[7]  = new FeatureVector("Dodge Omni", new double[] { 30.9, 2.23, 3.37, 75.0, 105.0, 4.0 });
	examples[8]  = new FeatureVector("Audi 5000", new double[] { 20.3, 2.83, 3.9, 103.0, 131.0, 5.0 });
	examples[9]  = new FeatureVector("Volvo 240 GL", new double[] { 17.0, 3.14, 3.5, 125.0, 163.0, 6.0 });
	examples[10] = new FeatureVector("Saab 99 GLE", new double[] { 21.6, 2.795, 3.77, 115.0, 121.0, 4.0 });
	examples[11] = new FeatureVector("Peugeot 694 SL", new double[] { 16.2, 3.41,	3.58, 133.0, 163.0, 6.0 });
	examples[12] = new FeatureVector("Buick Century Special", new double[] { 20.6, 3.38, 2.73, 105.0, 231.0, 6.0 });
	examples[13] = new FeatureVector("Mercury Zephyr", new double[] { 20.8, 3.07,	3.08, 85.0, 200.0, 6.0 });
	examples[14] = new FeatureVector("Dodge Aspen", new double[] { 18.6, 3.62, 2.71, 110.0, 225.0, 6.0 });
	examples[15] = new FeatureVector("AMC Concord D/L", new double[] { 18.1, 3.41, 2.73, 120.0, 258.0, 6.0 });
	examples[16] = new FeatureVector("Chevy Caprice Classic", new double[] { 17.0, 3.84, 2.41, 130.0, 305.0, 8.0 });
	examples[17] = new FeatureVector("Ford LTD", new double[] { 17.6, 3.725, 2.26, 129.0, 302.0, 8.0 });
	examples[18] = new FeatureVector("Mercury Grand Marquis", new double[] { 16.5, 3.955, 2.26, 138.0, 351.0, 8.0 });
	examples[19] = new FeatureVector("Dodge St Regis", new double[] { 18.2, 3.83,	2.45, 135.0, 318.0, 8.0 });
	examples[20] = new FeatureVector("Ford Mustang 4", new double[] { 26.5, 2.585, 3.08, 88.0, 140.0, 4.0 });
	examples[21] = new FeatureVector("Ford Mustang Ghia", new double[] { 21.9, 2.91, 3.08, 109.0, 171.0, 6.0 });
	examples[22] = new FeatureVector("Mazda GLC", new double[] { 34.1, 1.975, 3.73, 65.0, 86.0, 4.0 });
	examples[23] = new FeatureVector("Dodge Colt", new double[] { 35.1, 1.915, 2.97, 80.0, 98.0, 4.0 });
	examples[24] = new FeatureVector("AMC Spirit", new double[] { 27.4, 2.67, 3.08, 80.0, 121.0, 4.0 });
	examples[25] = new FeatureVector("VW Scirocco", new double[] { 31.5, 1.99, 3.78, 71.0, 89.0, 4.0 });
	examples[26] = new FeatureVector("Honda Accord LX", new double[] { 29.5, 2.135, 3.05, 68.0, 98.0, 4.0 });
	examples[27] = new FeatureVector("Buick Skylark", new double[] { 28.4, 2.67, 2.53, 90.0, 151.0, 4.0 });
	examples[28] = new FeatureVector("Chevy Citation", new double[] { 28.8, 2.595, 2.69, 115.0, 173.0, 6.0 });
	examples[29] = new FeatureVector("Olds Omega", new double[] { 26.8, 2.7, 2.84, 115.0, 173.0, 6.0 });
	examples[30] = new FeatureVector("Pontiac Phoenix", new double[] { 33.5, 2.556, 2.69, 90.0, 151.0, 4.0 });
	examples[31] = new FeatureVector("Plymouth Horizon", new double[] { 34.2, 2.2, 3.37, 70.0, 105.0, 4.0 });
	examples[32] = new FeatureVector("Datsun 210", new double[] { 31.8, 2.02, 3.7, 65.0, 85.0, 4.0 });
	examples[33] = new FeatureVector("Fiat Strada", new double[] { 37.3, 2.13, 3.1, 69.0, 91.0, 4.0 });
	examples[34] = new FeatureVector("VW Dasher", new double[] { 30.5, 2.19, 3.7,	78.0, 97.0, 4.0 });
	examples[35] = new FeatureVector("Datsun 810", new double[] { 22.0, 2.815, 3.7, 97.0, 146.0, 6.0 });
	examples[36] = new FeatureVector("BMW 320i", new double[] { 21.5, 2.6, 3.64, 110.0, 121.0, 4.0 });
	examples[37] = new FeatureVector("VW Rabbit", new double[] { 31.9, 1.925, 3.78, 71.0, 89.0, 4.0 });

	Cluster[] clusters;
	
	clusters = Utilities.run(examples, 3, 100);
	
	for (Cluster c : clusters) {
	    System.out.println(c);
	}

    }

}
