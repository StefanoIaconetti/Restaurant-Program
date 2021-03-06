package tabs;


import java.util.ArrayList;

import PlaceHolder.FoodDrink;
import Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StatisticsTab extends Tab {
	
	private static StatisticsTab tab;
	
	public static BorderPane pane;

	public static ComboBox<ENUMS.MonthlyStats> month = new ComboBox<>();
	
	private StatisticsTab() {
		this.setText("Statistics Tab");
		pane = new BorderPane();
		
		//Create the user input for what month they would like to display
		Text monthText = new Text("Month: ");
		month.setItems(FXCollections.observableArrayList(ENUMS.MonthlyStats.values()));
		HBox months = new HBox();
		months.getChildren().addAll(monthText, month);
		months.setAlignment(Pos.CENTER);
		pane.setTop(months);
		
		//Create a button to generate a chart based on the selected model
		Button goBtn = new Button("Generate Chart");
		goBtn.setOnAction(e->{
			PieChart chart = new PieChart();
			if(!month.getSelectionModel().isEmpty()) {
				switch(month.getSelectionModel().getSelectedItem().name()) {
				case "JANUARY":
					chart = generateJanChart();
					break;
				case "FEBRUARY":
					chart = generateFebChart();
					break;
				case "MARCH":
					chart = generateMarChart();
					break;
				case "APRIL":
					chart = generateAprChart();
					break;
				case "MAY":
					chart = generateMayChart();
					break;
				case "JUNE":
					chart = generateJunChart();
					break;
				case "JULY":
					chart = generateJulChart();
					break;
				case "AUGUST":
					chart = generateAugChart();
					break;
				case "SEPTEMBER":
					chart = generateSepChart();
					break;
				case "OCTOBER":
					chart = generateOctChart();
					break;
				case "NOVEMBER":
					chart = generateNovChart();
					break;
				case "DECEMBER":
					chart = generateDecChart();
					break;
				}
			} else {
				chart = generateChart();
			}
			//if there is nothing in the chart then dont show the chart
			if(chart == null) {
				pane.setCenter(new Text("Sorry there are no food entries for " + month.getSelectionModel().getSelectedItem().name()));
			}else {
				pane.setCenter(chart);
			}
		});
		pane.setBottom(goBtn);
		pane.setAlignment(goBtn, Pos.CENTER);
		
		this.setContent(pane);
	}

	public static StatisticsTab getInstance() {
		if(tab == null) {
			tab = new StatisticsTab();
		}
		return tab;
	}
	
	//Generate a chart that displays everything
	public static PieChart generateChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrink();
		ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
		for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
		}
		
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
		chart.setData(data);
		
		return chart;
	}
	
	//Generate a chart for january stats
	public static PieChart generateJanChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("January Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.JANUARY.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			} 
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}
	
	public static PieChart generateFebChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("February Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.FEBRUARY.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}

	public static PieChart generateMarChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("March Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.MARCH.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}

	public static PieChart generateAprChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("April Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.APRIL.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}

	public static PieChart generateMayChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("May Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.MAY.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}

	public static PieChart generateJunChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("June Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.JUNE.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}
	
	public static PieChart generateJulChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("July Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.JULY.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}

	public static PieChart generateAugChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("August Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.AUGUST.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}

	public static PieChart generateSepChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("September Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.SEPTEMBER.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}
	
	public static PieChart generateOctChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("October Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.OCTOBER.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}

	public static PieChart generateNovChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("November Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.NOVEMBER.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}
	
	public static PieChart generateDecChart() {
		FoodTable table = new FoodTable();
		
		PieChart chart = new PieChart();
		chart.setTitle("December Total Sales of Each Menu Item");
		chart.setLabelsVisible(true);
		ArrayList<FoodDrink> foodItems = table.getAllFoodDrinkFrom(ENUMS.MonthlyStats.DECEMBER.name());
		if(!foodItems.isEmpty()) {
			ArrayList<PieChart.Data> foodItemData = new ArrayList<PieChart.Data>();
			for(int i = 0; i < foodItems.size(); i++) {
				foodItemData.add(new PieChart.Data(foodItems.get(i).getName(), foodItems.get(i).getAmountSold()));
			}
			
			ObservableList<PieChart.Data> data = FXCollections.observableArrayList(foodItemData);
			chart.setData(data);
			
			return chart;
		} else {
			return null;
		}
	}




	
	
}
