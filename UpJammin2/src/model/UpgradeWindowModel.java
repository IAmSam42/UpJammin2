package model;

import java.nio.file.Files;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UpgradeWindowModel {

	private int[] progress;
	private JSONArray file; 



	public UpgradeWindowModel() {
		//CODE TO READ IN THE FILE HERE
		
		
		progress = new int[file.size()];
		for(int y : progress)
			progress[y] = 0;
		
		
	}
	
	public ArrayList<FinUpgrade> getFinUpgrades() {
		ArrayList<FinUpgrade> x = new ArrayList<FinUpgrade>();
		for(int i = 0; i <file.size(); i++){
			JSONArray upgradePath = (JSONArray) file.get(i);
			if(progress[i]>=upgradePath.size()){
				JSONObject upgrade = (JSONObject) upgradePath.get(upgradePath.size());
				x.add(new FinUpgrade((String)upgrade.get("title"), (String)upgrade.get("subtitle"), (String)upgrade.get("imgLoc"), false));
				
			} else {
				JSONObject upgrade = (JSONObject) upgradePath.get(i);
				x.add(new FinUpgrade((String)upgrade.get("title"), (String)upgrade.get("subtitle"), (String)upgrade.get("imgLoc"), true));				
			}

		}
		return x;
	}
	
	
}
