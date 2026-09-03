package settings;

import java.net.URL;

public class Properties {
	
	String imgDir;
	URL background;
	URL logo;
	URL company;
	URL companyFrame;
	
	public Properties(String img){
		imgDir = "/img";
		background = getClass().getResource(imgDir +"/background.png");
		company = getClass().getResource(imgDir + "/company.png");
		logo = getClass().getResource(imgDir + "/logo.png");
		companyFrame = getClass().getResource(imgDir + "/company_iframe.png");
	}
	
	public URL getLogo(){
		return logo;
	}
	public URL getCompany(){
		return company;
	}
	public URL getBackground(){
		return background;
	}
	public URL getCompanyFrame(){
		return companyFrame;
	}

}
