/*
Michelle Baldwin
SDEV200
Semester Project 
Check In class
Last update: 10/10/21
*/

import java.util.Calendar;


public class CheckIn {
	private int day;
	private int month;
	private int year;
	private int score;
	
	public CheckIn() {
		Calendar date = Calendar.getInstance();
		day = date.get(Calendar.DATE);
		month = date.get(Calendar.MONTH) + 1;
		year = date.get(Calendar.YEAR);
		score = 20;
	}
	public CheckIn(int score) {
		Calendar date = Calendar.getInstance();
		day = date.get(Calendar.DATE);
		month = date.get(Calendar.MONTH) + 1;
		year = date.get(Calendar.YEAR);
		this.score = score;
	}
	public CheckIn(int day, int month, int year, int score) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.score = score;
	}
	
	//setters
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//getters
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public int getScore() {
		return score;
	}
	
	public void printCheckIn() {
		System.out.println(month + "/" + day + "/" + year + " - " + score + " points");
	}
	
	public String toString() {
		String temp = month + "/" + day + "/" + year + "-" + score + "points";
		return temp;
	}
}
