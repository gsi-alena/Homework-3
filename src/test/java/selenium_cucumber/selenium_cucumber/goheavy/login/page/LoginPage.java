package selenium_cucumber.selenium_cucumber.goheavy.login.page;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;

public class LoginPage extends PageObject {
	String password_id="password";
	String user_id="email";
	String LogingxpathText="//h1[text()='Login']";
    
	
	String emailresult = "";
	String passresult = "";
	
	public LoginPage() {
		super();
		this.urlpath = "login";

	}
	
	public WebElement getLogingTextElemnt() throws Exception{
		return getWebElement(By.xpath(LogingxpathText));
	}

	public HashMap<String, WebElement> fillCredentials(String email, String password) {

		//WebElement email_element = getWebElement(By.id(password_id)); JOSE
		WebElement pass_element = getWebElement(By.id(password_id));
		pass_element.sendKeys(password); passresult = password;
		//WebElement pass_element = getWebElement(By.id(user_id)); JOSE
		WebElement email_element = getWebElement(By.id(user_id)); 
		email_element.sendKeys(email); emailresult = email;

		HashMap<String, WebElement> eles = new HashMap<String, WebElement>();
		eles.put("email", email_element);
		eles.put("password", pass_element); 
		return eles;
	}
	public void clickOnButtons() {
		getWebElement(By.xpath("//*[@id=\"admin-form-session\"]/button")).click();

	}
	
	public void waitForElelemtDisappear() throws Exception{		
		Setup.getWait().waitUntilElementDisappear(By.id(password_id), 5000);
		Setup.getWait().waitUntilElementDisappear(By.id(user_id), 5000);		
	}
	public String get_email() {
		WebElement email_element = getWebElement(By.id(user_id)); System.out.print(email_element.getText());
		return email_element.getText();
	}
	public String get_password() {
		WebElement pass_element = getWebElement(By.id(password_id));
		return pass_element.getText();
	}
    public void checkCredentials(String message) {
    	    	   	
    	if(emailresult.equals("") || passresult.equals(""))  {
    		//This is the alert path //*[@id=\"admin-form-session\"]/div[2]/div[2]/div[2]/div
    		////div[@role='alert']/ancestor::form[@id=\"admin-form-session\"]
    		//div[@role='alert']/ancestor::form"
    		String emailalert = getWebElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div[1]/div[2]/div[2]/div")).getText();
    		String passalert = getWebElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div[1]/div[2]/div[2]/div")).getText();
    		Assert.assertTrue(emailalert.equals(message));
    		Assert.assertTrue(passalert.equals(message));
        }
    }
    public void checkLoginCredentials() {
    //Esto lo hago porque deberia existir algun escenario de registro de usuarios donde los usuarios validos se guarden	
    List<String> validusers = new ArrayList<String>();
    List<String> validpass = new ArrayList<String>();
    
    validusers.add("novanick@gmail.com");
    validusers.add("admin@goheavy.co");
    validusers.add("evakings@gmail.com");
    validusers.add("piper95@gmail.com");
    
    validpass.add("@User123");
    validpass.add("$Fe883*K&kT&");
    validpass.add("@User123");
    validpass.add("@User123");
    int i= 0; boolean notuser = false;
    
    //Verificar que el user no esta entre los definidos
   while ((i< validusers.size()) && (!(validusers.get(i)).equals(emailresult))) {
	   i++;
       } if (i< validusers.size()) {
	      notuser = true;
          }
    //Verificar que el password no esta correcto para el user seleccionado   
       int j = 0; boolean notpass = false;
    while ((j< validpass.size()) && (!(validpass.get(j)).equals(passresult))) {
    	   j++;
           } if (j< validpass.size()) {
    	      notpass = true;
             }   
    
    //Verifico si el texto del popu coincide con lo que se debe mostrar
    if(!notuser || !notpass) {       
    String credentialfailed = getWebElement(By.xpath("//div[@class=’nav navbar-nav navbar-right’]//span[@class=’ant-notification-notice-message-single-line-auto-margin’]")).getText();
	Assert.assertTrue(credentialfailed.equals("The email or password you entered is incorrect. If you are not registered please create an account.")); 
    }
  }
   public void validateEmail(String message) {
	   //Validar que la estructura del email no es correcta
	   if((!emailresult.contains("@")) || (!emailresult.contains("."))) {
		String bademailmessage = getWebElement(By.xpath("//div[@class='ant-form-item-explain ant-form-item-explain-error']")).getText();   
	    Assert.assertTrue(bademailmessage.equals(message));
	   }
	   
   }
}
