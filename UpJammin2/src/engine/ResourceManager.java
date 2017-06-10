package engine;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ResourceManager {
	static private ResourceManager instance = null;
	private HashMap<String, String> file_cache;
	private HashMap<String, ImageIcon> img_cache;
	
	private ResourceManager() {
		file_cache = new HashMap<String, String>();
		img_cache = new HashMap<String, ImageIcon>();
	}
	
	static public ResourceManager getResourceManager() {
		if(instance == null)
			instance = new ResourceManager();
		return instance;
	}
	
	public String getFileContents(String file_name) {
		try {
			if(! file_cache.containsKey(file_name)) {
				String fileContent = new String();
				
				Scanner sc = new Scanner(new FileReader(file_name));
		        while (sc.hasNextLine()) {
		            fileContent += "\n" + sc.nextLine();
		        }
		        sc.close();
		        
				file_cache.put(file_name, fileContent);
			}
		}
		catch(Exception e) {
			System.err.println("Problems reading file " + file_name + ".");
			System.err.println(e);
			System.exit(-1);
		}
		
		return file_cache.get(file_name);
	}
	
	public ImageIcon getImageIcon(String file_name) {
		try {
			if(! file_cache.containsKey(file_name)) {
				ImageIcon nii = new ImageIcon(file_name);
				img_cache.put(file_name, nii);
			}
		}
		catch(Exception e) {
			System.err.println("Problems reading image file " + file_name + ".");
			System.err.println(e);
			System.exit(-1);
		}
		
		return img_cache.get(file_name);
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(ResourceManager.getResourceManager().getFileContents("resources/levels.json"));
		JSONParser p = new JSONParser();
		JSONArray a = (JSONArray) p.parse(ResourceManager.getResourceManager().getFileContents("resources/upgrades.json"));
		System.out.println(a.toJSONString());
	}
}
