package evolutionaryComputation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import nz.ac.vuw.kol.OptimisationFunction;

public class Test {

	static int numOfGens = 150000;
	static int generationSize = 100;
	static double lowerRange = -10;
	static double upperRange = 10;
	static int numOfRecombinationPairs = 2;
	static int sampleSize = 30;
	static double mutationFrequency = .5; // percentage chance of mutation
	static double mutationSize = .4;
	static ArrayList<double[]> currentGeneration = new ArrayList<>();
	static Map<Integer, Double> subset = new HashMap<>();  //<position in currentGeneration array, phenotype>
	
	static long mutationCount = 0;

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

	public static void pickSubset() {
		//first clear old subset
		subset.clear();
		//set tickets
		ArrayList<Integer> tickets = new ArrayList<>();
		for (int t=0; t<generationSize; t++) {
			tickets.add(t);
		}
		//pick a number of random parents for subset and store in map with in
		for (int i=0; i<sampleSize; i++) {
			//to avoid double ups use 'tickets'	
			Random rand = new Random();			
			int selectedPosition = (int) (tickets.size()-1 * rand.nextDouble());
			//process ticket
//			System.out.println("debug ticket size");
//			System.out.println(tickets.size());
//			System.out.println("selected position");
//			System.out.println(selectedPosition);
			int ticket = tickets.get(selectedPosition); //ticket is a ubique int from 0 to generation size -1
//			System.out.println(ticket);
			//use this to get position in current gen and fitness and store in map

			double[] selectedParent = currentGeneration.get(ticket);
			
			mutate(selectedParent);

			double selectedParentFitness = OptimisationFunction.unknownFunction(selectedParent);
			subset.put(ticket, selectedParentFitness);
			//delete ticket
			tickets.remove(ticket);

		} 
//		System.out.println("checking subset");
//		for(double fitness: subset.values()) {
//			System.out.println(fitness);
//		}
//		System.out.println("subset check complete");

		rankSubset();
	}

	//take map of subset and get positions ranked by fitness
	public static void rankSubset() {
		ArrayList<Integer> rankedPositions = new ArrayList<>(); //to hold int of position (of subset) in current gen sorted by fitness 

		int minPos = -1;
		for(int i = 0; i<sampleSize; i++) {

			double min = 999999999;
			for ( Map.Entry<Integer, Double> e: subset.entrySet()) {
				if (e.getValue() != null && e.getValue() < min && !(rankedPositions.contains(e.getKey()))) {
					min = e.getValue();
					minPos = e.getKey();

				}
			}
			rankedPositions.add(minPos);
//			System.out.println("min pos added");
//			System.out.println(minPos);
//			System.out.println("fitness of minpos");
//			System.out.println(min);
//			System.out.println("rankingsize");
//			System.out.println(rankedPositions.size());

			

		}
		selectBreeders(rankedPositions);


	}

	//select breeders
	private static void selectBreeders(ArrayList<Integer> rankedPosList) {
		//depending on number of breeders pick and call breeding on apprirate parents from ranked subset
		for (int i=0; i<numOfRecombinationPairs; i++) {
			int parent1 = rankedPosList.get( ((i+1)*2-1)  );
			int parent2 = rankedPosList.get( ((i+1)*2) );
			breedPair(parent1, parent2);

		}
	}

	//breed a pair and add overwrite parent with child
	private static void breedPair(int parent1Index, int parent2Index) {
		double[] parent1 = currentGeneration.get(parent1Index);
		double[] parent2 = currentGeneration.get(parent2Index);
		//recombine to make children and overwrite parent with children
		double[] child1 = new double[5];
		double[] child2 = new double[5];
		//recombintation
		Random rand = new Random();
		for (int i=0; i<5; i++) {
			if(rand.nextDouble() < .5) {
				child1[i] = parent1[i];
				child2[i] = parent2[i];
			} else {
				child1[i] = parent2[i];
				child2[i] = parent1[i];
			}

		}
		//here just overwrite parent or do so only if child better fitness?
		//overwrite
//		System.out.println("-------parent before--------");
//		for (double d: parent1) {
//			System.out.println(d);
//		}
		if(OptimisationFunction.unknownFunction(child1) < OptimisationFunction.unknownFunction(parent1)) {
			parent1 = child1;
		}
		
		if(OptimisationFunction.unknownFunction(child2) < OptimisationFunction.unknownFunction(parent2)) {
			parent2 = child2;
		}
		
		
//		System.out.println("-------parent after--------");
//		for (double d: parent1) {
//			System.out.println(d);
//		}
	
		
	

	}

	//mutation
	private static void mutate(double[] mutatee) {
		Random rand = new Random();
		double mutation = (rand.nextDouble() * mutationSize) - mutationSize/2;
		if (rand.nextDouble()*100 < mutationFrequency) {
			int geneToMutate = (int) (rand.nextDouble()*5);
			mutatee[geneToMutate] += mutation;
			mutationCount ++;
//			System.out.println("mutated by " + mutation);
		}
	}


	public static void main(String[] args) {

		populateFirstGeneration();
		
		System.out.println("----------initial fitness----------");
		double initMin = 99999999;
		for(int j=0; j<generationSize; j++) {
			if(OptimisationFunction.unknownFunction(currentGeneration.get(j))< initMin) {
				initMin = OptimisationFunction.unknownFunction(currentGeneration.get(j));
			}
//			System.out.println(OptimisationFunction.unknownFunction(currentGeneration.get(j)));
		}
		System.out.println("==========InitMin=========");
		System.out.println(initMin);

		for (int i=0; i<numOfGens; i++) {


			pickSubset();
//			System.out.println("generation number" + i);

			
			
		}
		
		System.out.println("-----------final fitness----------");
		double finalMin = 99999999;
		for(int j=0; j<generationSize; j++) {
			if(OptimisationFunction.unknownFunction(currentGeneration.get(j))< finalMin) {
				finalMin = OptimisationFunction.unknownFunction(currentGeneration.get(j));
			}
//			System.out.println(OptimisationFunction.unknownFunction(currentGeneration.get(j)));
		}
		System.out.println("==========FinalMin==========");
		System.out.println(finalMin);
		System.out.println("mutation count: " + mutationCount);



	}

}
