package model;

public class Bank {
	
	private int balance;
	private double interestRate;
	private int seperateIncome;
	
	public Bank() {
		setBalance(500);
		this.seperateIncome = 0;
		this.interestRate = 20;
	}
	
	public void endDay() {
		balance *= interestRate;
		balance +=seperateIncome;
	}
	
	public void addBalance(int increment) {
		balance += increment;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getSeperateIncome() {
		return seperateIncome;
	}

	public void setSeperateIncome(int seperateIncome) {
		this.seperateIncome = seperateIncome;
	}
	
	
}
