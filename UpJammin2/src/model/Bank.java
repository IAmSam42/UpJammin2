package model;

import java.util.Observable;

public class Bank extends Observable {
	
	private int balance;
	private double interestRate;
	private int seperateIncome;
	
	//Cost increase for every tower/wall placed.
	private int cost_interest;
	
	//Cost for each type of tower/wall.
	private int price_wall;
	private int price_arrow_tower;
	private int price_cannon_tower;
	
	
	public Bank() {
		setBalance(500);
		this.seperateIncome = 0;
		this.interestRate = 20;
		
		//Set the cost interest,
		cost_interest = 5;
		
		//Set the costs for each wall/tower.
		price_wall = 20;
		price_arrow_tower = 70;
		price_cannon_tower = 100;
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
	
	public void increaseCost(Map.blockType blocktype)
	{
		System.out.println("increased" + price_wall);
		switch (blocktype) {
		case Wall:
			price_wall += (int)((double)price_wall * ((double)cost_interest / 100.0));
			break;

		case ArrowTurret:
			price_arrow_tower += (int)((double)price_arrow_tower * ((double)cost_interest / 100.0));
			break;
		
		case CannonTurret:
			price_cannon_tower += (int)((double)price_cannon_tower * ((double)cost_interest / 100.0));
			break;
			
		default:
			break;
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Get the current cost of a given blocktype.
	 * @param blocktype The blocktype to check.
	 * @return The price of the blocktype.
	 */
	public int getCost(Map.blockType blocktype)
	{
		switch (blocktype) {
		case Wall:
			return price_wall;
		
		case ArrowTurret:
			return price_arrow_tower;
			
		case CannonTurret:
			return price_cannon_tower;
			
		default:
			return 0;
		}
	}
}
