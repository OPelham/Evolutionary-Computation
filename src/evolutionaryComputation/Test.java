package evolutionaryComputation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import nz.ac.vuw.kol.OptimisationFunction;

public class Test {
	
	static int generationSize = 100;
	static double lowerRange = 0;
	static double upperRange = 100;
	static ArrayList<double[]> currentGeneration = new ArrayList<>();
	static Map<Integer, double[]> subset = new HashMap<>();  //<position in currentGeneration array, phenotype>
	
	/**
	 * Creates a new parent with random doubles in phenotype (double[5]) within given range
	 * @return returns randomised phenotype of a new parent
	 */
	private static double[] generateNewParent() {
		Random rand = new Random();
		double[] newParent = new double[5];
		//initial constaints on 
		for (int i = 0; i < 5; i++) {
			double randValue = lowerRange + (upperRange - lowerRange) * rand.nextDouble();
			newParent[i] = randValue;
		}
		return newParent;
	}
	
	/**
	 * Creates the given number of parents and stores them in currentGeneration arraylist
	 * @param sizeOfFirstGen number of parents per generation
	 * @param lowerRange lower range of doubles to generate
	 * @param upperRange upper range of doubles to generate
	 */
	public static void populateFirstGeneration() {
		//clear existing 
		currentGeneration.clear();
		//generate a parent for as many as size of generation
		for (int i = 0; i < generationSize; i++) {
			currentGeneration.add(generateNewParent());
		}
	}
	
	public static void pickSubset(int sampleSize) {
		//first clear old subset
		subset.clear();
		//pick a number of random parents for subset and store in map with in
		for (int i=0; i<sampleSize; i++) {
			//to avoid double ups use 'tickets'
			int[] tickets = new int[sampleSize];
			for (int t=0; t<sampleSize; t++) {
				
				//to do set tcikets, chose from tickets not taken, ...
				
			}
		}
	}
	

	public static void main(String[] args) {
		
		populateFirstGeneration();
		
		
		for(int i=0; i<100; i++) {
			System.out.println(OptimisationFunction.unknownFunction(currentGeneration.get(i)));
		}
		
	

	}

}
