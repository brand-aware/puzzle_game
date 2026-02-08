package settings;

import java.io.File;

public class Properties {
	
	String imgDir;
	String background;
	String logo;
	String company;
	String companyFrame;
	
	public Properties(String img){
		imgDir = img;
		background = imgDir + File.separator + "background.png";
		company = imgDir + File.separator + "company.png";
		logo = imgDir + File.separator + "logo.png";
		companyFrame = imgDir + File.separator + "company_iframe.png";
	}
	
	public String getLogo(){
		return logo;
	}
	public String getCompany(){
		return company;
	}
	public String getBackground(){
		return background;
	}
	public String getCompanyFrame(){
		return companyFrame;
	}

}
