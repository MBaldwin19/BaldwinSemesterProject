/*
Michelle Baldwin
SDEV200
Semester Project 
Habit class
Last update: 10/10/21
*/

import java.util.*;

public class Habit {
	private String habit;
	private int daysPerWeek;
	private int lengthOfHabit;
	private Vector<CheckIn> checkIn = new Vector<CheckIn>();
	private Rewards rewards = new Rewards();
	
	public Habit(String habit) {
		this.habit = habit;
		daysPerWeek = 1;
		lengthOfHabit = 90;
	}
	public Habit(String habit, int daysPerWeek, int lengthOfHabit) {
		this.habit = habit;
		this.daysPerWeek = daysPerWeek;
		this.lengthOfHabit = lengthOfHabit;		
	}
	
	//setters
	public void setHabit(String habit)
	{
		this.habit = habit;
	}
	public void setDaysPerWeek(int daysPerWeek)
	{
		this.daysPerWeek = daysPerWeek;
	}
	public void setLengthOfGoal(int lengthOfHabit) {
		this.lengthOfHabit = lengthOfHabit;
	}
	public void setRewards(int points, String reward) {
		rewards.addReward(points, reward);
	}
	
	//getters
	public String getHabit() {
		return habit;
	}
	public int getDayPerfWeek() {
		return daysPerWeek;
	}
	public int getLengthOfHabit() {
		return lengthOfHabit;
	}
	public Rewards getRewards() {
		return rewards;
	}
	public Vector<CheckIn> getCheckIn() {
		return checkIn;
	}
	
	//add check in with variety of parameters
	public void addCheckIn() {
		checkIn.addElement(new CheckIn());
	}
	public void addCheckIn(int score) {
		checkIn.addElement(new CheckIn(score));
	}
	public void addCheckIn(int day, int month, int year, int score) {
		checkIn.addElement(new CheckIn(day, month, year, score));
	}
	
	//output goal info
	public void printHabit() {
		System.out.println("Habit: " + habit);
		System.out.println("Trying to accomplish this " + daysPerWeek + " days per week for at least " + lengthOfHabit + " days");
	}
	
	public String toString() {
		String string = "Trying to accomplish this " + daysPerWeek + " days per week for at least " + lengthOfHabit + " days";
		return string;
	}
	
	//output check in history
	public void printCheckInHistory() {
		System.out.println("Check In History: ");
		for (int x = 0; x < checkIn.size(); x++) {
			checkIn.get(x).printCheckIn();
		}
	}
}
