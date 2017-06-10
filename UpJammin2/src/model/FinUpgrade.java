package model;

public class FinUpgrade {

	private String title;
	private String subtitle;
	private String imgLoc;
	private boolean exists;
		
	public FinUpgrade(String title, String subtitle, String imgLoc, boolean exists) {
		this.title = title;
		this.subtitle = subtitle;
		this.imgLoc = imgLoc;
		this.exists = exists;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getImgLoc() {
		return imgLoc;
	}

	public void setImgLoc(String imgLoc) {
		this.imgLoc = imgLoc;
	}
	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	
	
}
