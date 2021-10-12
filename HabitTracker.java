/*
Michelle Baldwin
SDEV200
Semester Project JavaFX
Last update: 10/4/21
*/

import java.util.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HabitTracker extends Application {
	//create buttons
	private Button btHabits = new Button("Habits");
	private Button btCheckIns = new Button("Check Ins");
	private Button btRewards = new Button("Rewards");
	private Button btAdd = new Button("Add");
	private Button btStart = new Button("Back to Main Menu");
	
	private ArrayList<Habit> HabitList = new ArrayList<Habit>();
	
	//create text fields
	private TextField tfHabit = new TextField();
	private TextField tfDaysPerWeek = new TextField();
	private TextField tfLengthOfHabit = new TextField();
	private TextField tfDate = new TextField();
	private TextField tfMonth = new TextField();
	private TextField tfYear = new TextField();
	private TextField tfScore = new TextField();
	private TextField tfReward = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
		//create grid pane
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		
		//add buttons
		gridPane.add(btHabits, 3, 2);
		gridPane.add(btCheckIns, 3, 4);
		gridPane.add(btRewards, 3, 6);
		
		//set formatting
		gridPane.setAlignment(Pos.CENTER);
		btHabits.setAlignment(Pos.CENTER);
		btCheckIns.setAlignment(Pos.CENTER);
		btRewards.setAlignment(Pos.CENTER);

		//process events
		btHabits.setOnAction(e -> firstMenu("Habits", primaryStage));
		btCheckIns.setOnAction(e -> firstMenu("Check Ins", primaryStage));
		btRewards.setOnAction(e -> firstMenu("Rewards", primaryStage));
		
		//display text/fields/button in scene on stage
		Scene scene = new Scene(gridPane, 800, 600);
		primaryStage.setTitle("Habit Tracker");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void firstMenu(String title, Stage primaryStage) {
		//create buttons
		Button btView = new Button("View");
		Button btAddNew = new Button("Add New");		
		
		//create grid pane
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		
		//add buttons
		gridPane.add(btView, 3, 2);
		gridPane.add(btAddNew, 3, 4);
		gridPane.add(btStart, 3, 6);
		
		//set formatting
		gridPane.setAlignment(Pos.CENTER);
		btView.setAlignment(Pos.CENTER);
		btAddNew.setAlignment(Pos.CENTER);
		btStart.setAlignment(Pos.CENTER);
		
		//process events
		btView.setOnAction(e -> viewMenu(title, HabitList, primaryStage));
		if (title == "Habits") {
			btAddNew.setOnAction(e -> addHabit(primaryStage));
		}
		else if (title == "Check Ins") {
			btAddNew.setOnAction(e -> addCheckIn(primaryStage));
		}
		else if (title == "Rewards") {
			btAddNew.setOnAction(e -> addReward());
		}
		
		btStart.setOnAction(e -> start(primaryStage));
		
		//display text/fields/button in scene on stage
		Scene scene = new Scene(gridPane, 800, 600);
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void viewMenu(String title, ArrayList<Habit> HabitList, Stage primaryStage) {
		//variable used to select which habit to display either check ins or rewards for
		int habitNum = 0;
		
		//only ask which habit if it isn't habits you want to display
		if (title == "Check Ins" || title == "Rewards")
			habitNum = getHabitNum(title, HabitList);
		
		//create grid pane
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		
		if (title == "Habits") {
			//loop through HabitList to display habits
			for (int x = 0; x < HabitList.size(); x++) {
				//output data
				gridPane.getChildren().add(new Label("Habit " + (x + 1)));
				gridPane.getChildren().add(new Label(HabitList.get(x).toString()));
			}
		}
		else if (title == "Check Ins") {
			//loop through the check in vector of HabitList to display habits
			for (int x = 0; x < HabitList.get(habitNum).getCheckIn().size(); x++) {			
				//output data
				gridPane.getChildren().add(new Label("Check In " + (x + 1)));
				gridPane.getChildren().add(new Label(HabitList.get(habitNum).getCheckIn().get(x).toString()));
			}
		}
		else if (title == "Rewards") {
			//loop through the rewards vector of HabitList to display habits
			for (int x = 0; x < HabitList.get(habitNum).getRewards().getRewardList().size(); x++) {			
				//output data
				gridPane.getChildren().add(new Label("Reward " + (x + 1)));
				gridPane.getChildren().add(new Label(HabitList.get(habitNum).getRewards().getRewardList().get(x).toString()));
			}
		}	
		
		gridPane.getChildren().add(btStart);
		btStart.setOnAction(e -> start(primaryStage));
		
		
		//display text/fields/button in scene on stage
		Scene scene = new Scene(gridPane, 800, 600); 
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
				
	public void addHabit(Stage primaryStage) {

		//create grid pane
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
			
		//output explanatory text, text fields, and button
		gridPane.add(new Label("Goal:"), 0, 0);
		gridPane.add(tfHabit, 1, 0);
			
		gridPane.add(new Label("Days per week:"), 0, 1);
		gridPane.add(tfDaysPerWeek, 1, 1);
		
		gridPane.add(new Label("Length of goal (in weeks):"), 0, 2);
		gridPane.add(tfLengthOfHabit, 1, 2);
		
		gridPane.add(btAdd, 1, 5);
		
		//set formatting
		gridPane.setAlignment(Pos.CENTER);
		tfHabit.setAlignment(Pos.BOTTOM_RIGHT);
		tfDaysPerWeek.setAlignment(Pos.BOTTOM_RIGHT);
		tfLengthOfHabit.setAlignment(Pos.BOTTOM_RIGHT);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
		
		//process events
		btAdd.setOnAction(e -> inputHabit(primaryStage));
		
		//display text/fields/button in scene on stage
		Scene scene = new Scene(gridPane, 800, 600);
		primaryStage.setTitle("Add Habit");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void inputHabit(Stage primaryStage) {
		//get values from text fields
		String habit = tfHabit.getText();
		int daysPerWeek = Integer.parseInt(tfDaysPerWeek.getText());
		int lengthOfHabit = Integer.parseInt(tfLengthOfHabit.getText());
							
		HabitList.add(new Habit(habit, daysPerWeek, lengthOfHabit));
		
		start(primaryStage);
	}
	
	public void addCheckIn(Stage primaryStage) {
		int habitNum = getHabitNum("Check Ins", HabitList);
		//create buttons
		Button btNew = new Button("Input new check in");
		Button btOld = new Button("Input old check in");
		
		//create stack pane
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		
		//add buttons
		gridPane.getChildren().add(btNew);
		gridPane.getChildren().add(btOld);
				
		//process events
		btNew.setOnAction(e -> addNewCheckIn(habitNum));
		btOld.setOnAction(e -> addOldCheckIn(habitNum));
				
		//display text/fields/button in scene on stage
		Scene scene = new Scene(gridPane, 800, 600);
		primaryStage.setTitle("Add Check In");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void addNewCheckIn(int habitNum) {
		HabitList.get(habitNum).addCheckIn();
	}
	public void addOldCheckIn(int habitNum) {
		Stage oldCheckInStage = new Stage();
		
		//create grid pane
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
					
		//output explanatory text, text fields, and button
		gridPane.add(new Label("Date:"), 0, 0);
		gridPane.add(tfDate, 1, 0);
			
		gridPane.add(new Label("Month:"), 0, 1);
		gridPane.add(tfMonth, 1, 1);
				
		gridPane.add(new Label("Year:"), 0, 2);
		gridPane.add(tfLengthOfHabit, 1, 2);
		
		gridPane.add(new Label("Score: "), 0, 3);
		gridPane.add(tfScore, 1, 3);
				
		gridPane.add(btAdd, 1, 5);
				
		//set formatting
		gridPane.setAlignment(Pos.CENTER);
		tfDate.setAlignment(Pos.BOTTOM_RIGHT);
		tfMonth.setAlignment(Pos.BOTTOM_RIGHT);
		tfYear.setAlignment(Pos.BOTTOM_RIGHT);
		tfScore.setAlignment(Pos.BOTTOM_RIGHT);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
				
		//process events
		btAdd.setOnAction(e -> createCheckIn(habitNum));
		
		//display text/fields/button in scene on stage
		Scene scene = new Scene(gridPane, 800, 600);
		oldCheckInStage.setTitle("Add Old Check In");
		oldCheckInStage.setScene(scene);
		oldCheckInStage.show();
	}
	public void createCheckIn(int habitNum) {
		//get values from text fields
		//this needs some defensive programming, add later
		int date = Integer.parseInt(tfDate.getText());
		int month = Integer.parseInt(tfMonth.getText());
		int year = Integer.parseInt(tfYear.getText());
		int score = Integer.parseInt(tfScore.getText());
								
		HabitList.get(habitNum).addCheckIn(date, month, year, score);
			
		Stage temp = new Stage(); 
		start(temp);
	}
	public void addReward() {
		int habitNum = getHabitNum("Rewards", HabitList);
		Stage newRewardStage = new Stage();
		
		//create grid pane
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
					
		//output explanatory text, text fields, and button
		gridPane.add(new Label("Reward:"), 0, 0);
		gridPane.add(tfReward, 1, 0);
			
		gridPane.add(new Label("Score:"), 0, 1);
		gridPane.add(tfMonth, 1, 1);
				
		gridPane.add(btAdd, 1, 3);
				
		//set formatting
		gridPane.setAlignment(Pos.CENTER);
		tfReward.setAlignment(Pos.BOTTOM_RIGHT);
		tfScore.setAlignment(Pos.BOTTOM_RIGHT);
		GridPane.setHalignment(btAdd, HPos.RIGHT);
				
		//process events
		btAdd.setOnAction(e -> createReward(habitNum));
		
		//display text/fields/button in scene on stage
		Scene scene = new Scene(gridPane, 800, 600);
		newRewardStage.setTitle("Add Reward");
		newRewardStage.setScene(scene);
		newRewardStage.show();
	}
	public void createReward(int habitNum) {
		//get values from text fields
		//this needs some defensive programming, add later
		String reward = tfReward.getText();
		int score = Integer.parseInt(tfScore.getText());
										
		HabitList.get(habitNum).getRewards().addReward(score, reward);
					
		Stage temp = new Stage(); 
		start(temp);
	}
	public int getHabitNum(String title, ArrayList<Habit> HabitList) {
		//create stack pane
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
				
		//loop through HabitList to display habits
		for (int x = 0; x < HabitList.size(); x++) {
			gridPane.getChildren().add(new Button((x + 1) + ": " + HabitList.get(x).getHabit()));
		}
		
		//create text field
		TextField tfHabitNum = new TextField();
		
		//select correct label based on title
		if (title == "Check Ins") {
			gridPane.getChildren().add(new Label("Check ins for which habit? "));
		}
		else {
			gridPane.getChildren().add(new Label("Rewards for which habit? "));
		}
		
		//add text field
		gridPane.getChildren().add(tfHabitNum);
		
		//return value from text field
		return Integer.parseInt(tfHabitNum.getText());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
