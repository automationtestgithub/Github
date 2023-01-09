package Com.Guru99.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigiration {

	Properties pro;
	
	public ReadConfigiration() {
		
		File src = new File("C:\\Users\\nikhi\\git\\repository\\Maven\\src\\main\\java\\Com\\Guru99\\Configuration\\Config.properties");
	    // File file= new
	    FileInputStream fis;
		try {
			fis = new FileInputStream(src);	
		
		 pro =new Properties();	    
			pro.load(fis);
		} catch (Exception e1) {
			System.out.println("Exception is :"+e1.getMessage());
	}		
		}
	
	public String getApplicationURL() {
             String url = pro.getProperty("baseURL");
             return url; 
	}
	
	public String getUsername() {
		String username= pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
	String password =pro.getProperty("password");	
	return password;
	
	}
	public String getChromePath() {
		
		String chromepath =pro.getProperty("chromepath");
		return chromepath;
	}
       public String getForeFoxPath() {
		
		String chromepath =pro.getProperty("firefoxpath");
		return chromepath;
	}
	
	
}