package model;

import java.nio.file.Files;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import engine.Config;
import engine.ResourceManager;

public class UpgradeWindowModel {

	private int[] progress;
	private JSONArray file; 



	public UpgradeWindowModel() {
		String file_content = ResourceManager.getResourceManager().getFileContents(Config.upgrade_file);
		JSONParser parser = new JSONParser();
		try {
			file = (JSONArray) parser.parse(file_content);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
