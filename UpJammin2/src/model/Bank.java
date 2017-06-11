package model;

import java.util.Observable;

public class Bank extends Observable {
	
	private int balance;
	private double interestRate;
	private int seperateIncome;
	
	//Reward for killing enemies.
	private int reward;
	
	//Cost increase for every tower/wall placed.
	private int cost_interest;
	
	//Cost for each type of tower/wall.
	private int price_wall;
	private int price_arrow_tower;
	private int price_cannon_tower;
	private int price_wizard_tower;
	
	
	public Bank() {
		setBalance(500);
		this.seperateIncome = 0;
		this.interestRate = 20;
		
		//Set the reward for killing enemies.
		reward = 1;
		
		//Set the cost interest,
		cost_interest = 5;
		
		//Set the costs for each wall/tower.
		price_wall = 20;
		price_arrow_tower = 70;
		price_cannon_tower = 100;
		price_wizard_tower = 250;
	}
	
	public void endDay() {
		
		balance += balance*(interestRate/100);
		balance +=seperateIncome;
		setChanged();
		notifyObservers();
	}
	
	public void addBalance(int increment) {
		balance += increment;
		setChanged();
		notifyObservers();
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
	
	public void setReward(int reward) {
		this.reward = reward;
	}
	
	public int getReward() {
		return this.reward;
	}
	
	public void buyBlock(Map.blockType blocktype)
	{
		switch (blocktype) {
		case Wall:
			balance -= price_wall;
			price_wall += (int)((double)price_wall * ((double)cost_interest / 100.0));
			break;

		case ArrowTurret:
			balance -= price_arrow_tower;
			price_arrow_tower += (int)((double)price_arrow_tower * ((double)cost_interest / 100.0));
			break;
		
		case CannonTurret:
			balance -= price_cannon_tower;
			price_cannon_tower += (int)((double)price_cannon_tower * ((double)cost_interest / 100.0));
			break;
			
		case Wizard:
			balance -= price_wizard_tower;
			price_wizard_tower += (int)((double)price_wizard_tower * ((double)cost_interest / 100.0));
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
			
		case Wizard:
			return price_wizard_tower;
			
		default:
			return 0;
		}
	}
	
	/**
	 * Check if the player can afford a specific type of tower/wall.
	 * @param blocktype The tower/wall type to check.
	 * @return If the player can afford that tower/wall.
	 */
	public boolean canAfford(Map.blockType blocktype)
	{
		switch (blocktype) {
		case Wall:
			return price_wall <= balance;
			
		case ArrowTurret:
			return price_arrow_tower <= balance;
			
		case CannonTurret:
			return price_cannon_tower <= balance;
		
		case Wizard:
			return price_wizard_tower <= balance;
			
		default:
			return false;
		}
	}
}
