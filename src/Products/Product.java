package Products;

import java.awt.Image;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Product {

	protected long ID;
	protected String title;
	protected Condition condition;
	protected double price;
	protected String color;
	protected Date dateUpload;
	protected String email;
	protected String phoneNum;
	protected Image[] images;

	Product(String title, Condition condition, double price,
			String color, Date dateUpload, String email,
			String phoneNum, Image[] images) {
		this.title = stringValidate(title);
		this.color = stringValidate(color);
		this.email = isValidEmailId(email);
		this.phoneNum = stringValidate(phoneNum);
		
	}
	Product(String phoneNum){
		this.phoneNum= phoneNumValidator( phoneNum);
	}
			
	public static void main (String[] args){
		Product p = new Product("0 888 51-00/26");
		System.out.println(p.phoneNum);
	}
	
	
	private String stringValidate(String str) {

		if (str != null && !str.isEmpty()) {
			return str;
		} else {
			return "Default";
		}

	}
	
	// for now the return type is String later will be boolean 
	private static String isValidEmailId(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(email);
        if(m.matches()){
        	return email;
        }else{
        	return "No email";
        }
    }
	
	private String phoneNumValidator(String number){
		Pattern pattern = Pattern.compile("^[0-9 -/]+");
		Matcher matcher = pattern.matcher(number); 
		 if (matcher.matches()) {
		     return number;
		 }else{
			 return "No phone";
		 }
	}

}
