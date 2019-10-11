package PageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class PaginaDesafio_ {

	private WebDriver driver;
	 
	 public PaginaDesafio_(WebDriver driver) {
	   this.driver = driver;
	 }
	public WebDriver acessar(String url,String browser,boolean headless) {
		
		if(browser.equals("firefox")) {	
			System.setProperty("webdriver.gecko.driver", "..\\..\\WEB_DRIVERS\\geckodriver.exe");
			FirefoxOptions opt=new FirefoxOptions();
			if(headless) {
				
						opt.setHeadless(true);
			}
			driver = new FirefoxDriver(opt);
			 
		    driver.get(url);
		   
		}
		else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "..\\..\\WEB_DRIVERS\\chromedriver77.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			if(headless) {
				options.addArguments("--headless");
				options.addArguments("--hide-scrollbars");
				options.addArguments("--disable-gpu");
				options.addArguments("--log-level=3");
			}
			
			driver = new ChromeDriver(options);
		    driver.get(url);  
		   
		}
		 return driver;
	}
	public void informo_nome(String nome){
		 WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Qual seu nome completo?\"]"));
		 element.sendKeys(nome);
	}
	public void informo_email(String email){
		WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Qual seu e-mail?\"]"));
		element.sendKeys(email);
	}
	public void informo_cor_favorita(String cor){
		WebElement element = driver.findElement(By.xpath("//span[text() = '"+cor+"']"));
		element.click();
	}
	public void informo_sobremesa(String sobremesa){
		WebElement element = driver.findElement(By.xpath("//span[text() = '"+sobremesa+"']"));
		element.click();
	}
	public void informo_comida(String comida){
		WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Outra resposta\"]"));
		element.click();
		element.sendKeys(Keys.TAB);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		element = driver.switchTo().activeElement();
		element.sendKeys(comida+Keys.ENTER);
	}
	public void informo_nota_animais(String nota){
		WebElement element = driver.findElement(By.xpath("//div[text() = '"+nota+"']"));
		element.click();
	}
	public void informo_graduacao(String graduacao,String esporte){
		WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+graduacaoCorrecao(graduacao)+", resposta para "+esporte+"\"]"));
		element.click();
	}
	public void informo_ingredientes(String comida,String ingrediente){
		WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+comida+", resposta para "+ingrediente+"\"]"));
		element.click();
	}	
	public void informo_data_atual(){
		Date date = new Date();  
		if(driver.findElements(By.xpath("//input[@aria-label=\"Ano\"]")).size() != 0) {
			WebElement ano = driver.findElement(By.xpath("//input[@aria-label=\"Ano\"]"));
			WebElement mes = driver.findElement(By.xpath("//input[@aria-label=\"M�s\"]"));
			WebElement dia = driver.findElement(By.xpath("//input[@aria-label=\"Dia do m�s\"]"));
			
			ano.sendKeys(new SimpleDateFormat("YYYY").format(date));
			mes.sendKeys(new SimpleDateFormat("MM").format(date));
			dia.sendKeys(new SimpleDateFormat("dd").format(date));
			
		}else {
			

			WebElement element =driver.findElement(By.xpath("//input[@type='date']"));
			 SimpleDateFormat formatter = new SimpleDateFormat("ddMMYYYY");  
			 String strDate = formatter.format(date);
			element.sendKeys(strDate);
			
			
		}
	}
	public void informo_horario_atual(){
		 Date date = new Date();  
		 SimpleDateFormat formatter = new SimpleDateFormat("HH");  
		 String hora = formatter.format(new Date(date.getTime() + 1 * 3600*1000));
		 formatter = new SimpleDateFormat("mm");
		 String minuto = formatter.format(date);
		 WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Hora\"]"));
		 element.sendKeys(hora);
		 element = driver.findElement(By.xpath("//input[@aria-label=\"Minuto\"]"));
		 element.sendKeys(minuto);
	}
	public void submeter(){
		WebElement element = driver.findElement(By.xpath("//span[text() = 'Enviar']"));
	    element.click();   
	}
	public void retirarFoco(){
		WebElement element = driver.switchTo().activeElement();
		element.sendKeys(Keys.TAB);
	} 
	public String graduacaoCorrecao(String graduacao) {
		if(graduacao.equals("Otimo")) {
			return "�timo";
		}
		else {
			return graduacao;
		}
	}
}
