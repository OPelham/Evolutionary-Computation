package evolutionaryComputation;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class MutationFrequencyGraph extends Application {
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ArrayList<Double> minFitnessList1 = Computation.compute(0.5);
		ArrayList<Double> minFitnessList1a = Computation.compute(0.5);
		ArrayList<Double> minFitnessList1b = Computation.compute(0.5);
		ArrayList<Double> minFitnessList1c = Computation.compute(0.5);
		ArrayList<Double> minFitnessList1d = Computation.compute(0.5);
		ArrayList<Double> aveMinList1 = new ArrayList<>();
		for (int i=0; i<minFitnessList1.size(); i++) {
			double sum = minFitnessList1.get(i) + minFitnessList1a.get(i) + minFitnessList1b.get(i) + minFitnessList1c.get(i) + minFitnessList1d.get(i);
			double ave = sum/minFitnessList1.size();
			aveMinList1.add(ave);
			
		}
		
		ArrayList<Double> minFitnessList2 = Computation.compute(5);
		ArrayList<Double> minFitnessList2a = Computation.compute(5);
		ArrayList<Double> minFitnessList2b = Computation.compute(5);
		ArrayList<Double> minFitnessList2c = Computation.compute(5);
		ArrayList<Double> minFitnessList2d = Computation.compute(5);
		ArrayList<Double> aveMinList2 = new ArrayList<>();
		for (int i=0; i<minFitnessList2.size(); i++) {
			double sum = minFitnessList2.get(i) + minFitnessList2a.get(i) + minFitnessList2b.get(i) + minFitnessList2c.get(i) + minFitnessList2d.get(i);
			double ave = sum/minFitnessList2.size();
			aveMinList2.add(ave);
		}
		
		ArrayList<Double> minFitnessList3 = Computation.compute(50);
		ArrayList<Double> minFitnessList3a = Computation.compute(50);
		ArrayList<Double> minFitnessList3b = Computation.compute(50);
		ArrayList<Double> minFitnessList3c = Computation.compute(50);
		ArrayList<Double> minFitnessList3d = Computation.compute(50);
		ArrayList<Double> aveMinList3 = new ArrayList<>();
		for (int i=0; i<minFitnessList3.size(); i++) {
			double sum = minFitnessList3.get(i) + minFitnessList3a.get(i) + minFitnessList3b.get(i) + minFitnessList3c.get(i) + minFitnessList3d.get(i);
			double ave = sum/minFitnessList3.size();
			aveMinList3.add(ave);
		}
		
		ArrayList<Double> minFitnessList4 = Computation.compute(100);
		ArrayList<Double> minFitnessList4a = Computation.compute(100);
		ArrayList<Double> minFitnessList4b = Computation.compute(100);
		ArrayList<Double> minFitnessList4c = Computation.compute(100);
		ArrayList<Double> minFitnessList4d = Computation.compute(100);
		ArrayList<Double> aveMinList4 = new ArrayList<>();
		for (int i=0; i<minFitnessList4.size(); i++) {
			double sum = minFitnessList4.get(i) + minFitnessList4a.get(i) + minFitnessList4b.get(i) + minFitnessList4c.get(i) + minFitnessList4d.get(i);
			double ave = sum/minFitnessList4.size();
			aveMinList4.add(ave);
		}
		
		
		
		primaryStage.setTitle("Frequency of Mutation");
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Generation");
		yAxis.setLabel("Fitness");
		
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
		lineChart.setTitle("Fitness vs Generation");
		
		
		XYChart.Series series1 = new XYChart.Series();
        series1.setName("Mutation Frequency 0.5");
        
        
        int i = 0;
        for (int j=0; j<(Computation.numOfGens/1000); j++) {
        	series1.getData().add(new XYChart.Data(i, aveMinList1.get(j)));
        	i = i + 1000;
        }
        
        
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Mutation Frequency 5");
        
        i = 0;
        for (int j=0; j<(Computation.numOfGens/1000); j++) {
        	series2.getData().add(new XYChart.Data(i, aveMinList2.get(j)));
        	i = i + 1000;
        }
        
        
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Mutation Frequency 50");
        
        i = 0;
        for (int j=0; j<(Computation.numOfGens/1000); j++) {
        	series3.getData().add(new XYChart.Data(i, aveMinList3.get(j)));
        	i = i + 1000;
        }
        
        
        
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Mutation Frequency 100");
        
        i = 0;
        for (int j=0; j<(Computation.numOfGens/1000); j++) {
        	series4.getData().add(new XYChart.Data(i, aveMinList4.get(j)));
        	i = i + 1000;
        }
        
        
        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1, series2, series3, series4);
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
}
		

