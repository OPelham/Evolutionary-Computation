package evolutionaryComputation;


import java.util.Random;
import nz.ac.vuw.kol.OptimisationFunction;

public class Test {
	
	public static double[] generateNewParent(double lowerRange, double upperRange) {
		Random rand = new Random();
		double[] newParent = new double[5];
		//initial constaints on 
		for (int i = 0; i < 5; i++) {
			double randValue = lowerRange + (upperRange - lowerRange) * rand.nextDouble();
			newParent[i] = randValue;
		}
		
		return newParent;
	}

	public static void main(String[] args) {
		System.out.println(OptimisationFunction.unknownFunction(generateNewParent(-10, 0)));
	

	}

}
