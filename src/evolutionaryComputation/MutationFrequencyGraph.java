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
		
		ArrayList<Double> list0 = Computation.compute(0, 100, 1000, 10, 2);
		ArrayList<Double> list0a = Computation.compute(0, 100, 1000, 10, 2);
		ArrayList<Double> list0b = Computation.compute(0, 100, 1000, 10, 2);
		ArrayList<Double> list0c = Computation.compute(0, 100, 1000, 10, 2);
		ArrayList<Double> list0d = Computation.compute(0, 100, 1000, 10, 2);
		ArrayList<Double> aveMinList0 = new ArrayList<>();
		for (int i=0; i<list0.size(); i++) {
			double sum = list0.get(i) + list0a.get(i) + list0b.get(i) + list0c.get(i) + list0d.get(i);
			double ave = sum/5;
			aveMinList0.add(ave);
			System.out.println(ave);
		}
		
		ArrayList<Double> list1 = Computation.compute(0.5, 100, 1000, 10, 2);
		ArrayList<Double> list1a = Computation.compute(0.5, 100, 1000, 10, 2);
		ArrayList<Double> list1b = Computation.compute(0.5, 100, 1000, 10, 2);
		ArrayList<Double> list1c = Computation.compute(0.5, 100, 1000, 10, 2);
		ArrayList<Double> list1d = Computation.compute(0.5, 100, 1000, 10, 2);
		ArrayList<Double> aveMinList1 = new ArrayList<>();
		for (int i=0; i<list1.size(); i++) {
			double sum = list1.get(i) + list1a.get(i) + list1b.get(i) + list1c.get(i) + list1d.get(i);
			double ave = sum/5;
			aveMinList1.add(ave);
			System.out.println(ave);
			
		}
		
		ArrayList<Double> minFitnessList2 = Computation.compute(5, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList2a = Computation.compute(5, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList2b = Computation.compute(5, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList2c = Computation.compute(5, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList2d = Computation.compute(5, 100, 1000, 10, 2);
		ArrayList<Double> aveMinList2 = new ArrayList<>();
		for (int i=0; i<minFitnessList2.size(); i++) {
			double sum = minFitnessList2.get(i) + minFitnessList2a.get(i) + minFitnessList2b.get(i) + minFitnessList2c.get(i) + minFitnessList2d.get(i);
			double ave = sum/5;
			aveMinList2.add(ave);
		}
		
		ArrayList<Double> minFitnessList3 = Computation.compute(15, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList3a = Computation.compute(15, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList3b = Computation.compute(15, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList3c = Computation.compute(15, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList3d = Computation.compute(15, 100, 1000, 10, 2);
		ArrayList<Double> aveMinList3 = new ArrayList<>();
		for (int i=0; i<minFitnessList3.size(); i++) {
			double sum = minFitnessList3.get(i) + minFitnessList3a.get(i) + minFitnessList3b.get(i) + minFitnessList3c.get(i) + minFitnessList3d.get(i);
			double ave = sum/5;
			aveMinList3.add(ave);
		}
		
		ArrayList<Double> minFitnessList4 = Computation.compute(40, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList4a = Computation.compute(40, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList4b = Computation.compute(40, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList4c = Computation.compute(40, 100, 1000, 10, 2);
		ArrayList<Double> minFitnessList4d = Computation.compute(40, 100, 1000, 10, 2);
		ArrayList<Double> aveMinList4 = new ArrayList<>();
		for (int i=0; i<minFitnessList4.size(); i++) {
			double sum = minFitnessList4.get(i) + minFitnessList4a.get(i) + minFitnessList4b.get(i) + minFitnessList4c.get(i) + minFitnessList4d.get(i);
			double ave = sum/5;
			aveMinList4.add(ave);
		}
		
		
		
		primaryStage.setTitle("Mutation Frequency");
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis(10.0, 15.5, 0.5);
		xAxis.setLabel("Generation");
		yAxis.setLabel("Fitness");
		
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
		lineChart.setTitle("Mutation Frequency and Best Individual Fitness");
		
		
		XYChart.Series series0 = new XYChart.Series();
        series0.setName("0");
        
        
        int i = 0;
        for (int j=0; j<(Computation.numOfGens/Computation.graphTicketInterval); j++) {
        	series0.getData().add(new XYChart.Data(i, aveMinList0.get(j)));
        	i = (int) (i + Computation.graphTicketInterval);
        }
		
		
		
		XYChart.Series series1 = new XYChart.Series();
        series1.setName("0.5");
        
        
        i = 0;
        for (int j=0; j<(Computation.numOfGens/Computation.graphTicketInterval); j++) {
        	series1.getData().add(new XYChart.Data(i, aveMinList1.get(j)));
        	i = (int) (i + Computation.graphTicketInterval);
        }
        
        
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("5");
        
        i = 0;
        for (int j=0; j<(Computation.numOfGens/Computation.graphTicketInterval); j++) {
        	series2.getData().add(new XYChart.Data(i, aveMinList2.get(j)));
        	i = (int) (i + Computation.graphTicketInterval);
        }
        
        
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("15");
        
        i = 0;
        for (int j=0; j<(Computation.numOfGens/Computation.graphTicketInterval); j++) {
        	series3.getData().add(new XYChart.Data(i, aveMinList3.get(j)));
        	i = (int) (i + Computation.graphTicketInterval);
        }
        
        
        
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("40");
        
        i = 0;
        for (int j=0; j<(Computation.numOfGens/Computation.graphTicketInterval); j++) {
        	series4.getData().add(new XYChart.Data(i, aveMinList4.get(j)));
        	i = (int) (i + Computation.graphTicketInterval);
        }
        
        
        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series0, series1, series2, series3, series4);
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
}
		

