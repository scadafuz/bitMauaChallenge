package PageObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Faz o acesso a Url no browser selecionado.
 * 
 * @author Bruno Viana Lopes
 * @version 0.0.1
 */

public class PaginaDesafio_ {

	 private WebDriver driver;
	 
	 /**
	  * Construtor do PageObject referente a p�gina do teste.
	  * 
	  * @param driver Driver que ir� manipular o browser.
	  */
	 public PaginaDesafio_(WebDriver driver) {
	   this.driver = driver;
	 }
	 
	 /**
	  * Faz o acesso a Url no browser selecionado.
	  * 
	  * @param url Url que o browser vai acessar.
	  * @param headless Booleano usado como flag para rodar em modo headless
	  * @param browser Qual browser/driver vai ser usado.
	  * @return Retorna o Driver.
	  */
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
	
	 /**
	  * Responsavel por informar o nome na P�gina
	  * 
	  * @param nome String que vai ser setada no campo
	  */
	public void informo_nome(String nome){
		 WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Qual seu nome completo?\"]"));
		 element.sendKeys(nome);
	}
	 /**
	  * Responsavel por informar o email na P�gina
	  * 
	  * @param email String que vai ser setada no campo
	  */
	public void informo_email(String email){
		WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Qual seu e-mail?\"]"));
		element.sendKeys(email);
	}
	 /**
	  * Responsavel por informar a cor na P�gina
	  * 
	  * @param cor String que vai ser setada no campo
	  */
	public void informo_cor_favorita(String cor){
		WebElement element = driver.findElement(By.xpath("//span[text() = '"+cor+"']"));
		element.click();
	}
	 /**
	  * Responsavel por informar a sobremesa na P�gina
	  * 
	  * @param sobremesa String que vai ser setada no campo
	  */
	public void informo_sobremesa(String sobremesa){
		WebElement element = driver.findElement(By.xpath("//span[text() = '"+sobremesa+"']"));
		element.click();
	}
	 /**
	  * Responsavel por informar a comida na P�gina
	  * 
	  * @param comida String que vai ser setada no campo
	  */
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
	 /**
	  * Responsavel por informar a nota na P�gina
	  * 
	  * @param nota String que vai ser setada no campo
	  */
	public void informo_nota_animais(String nota){
		WebElement element = driver.findElement(By.xpath("//div[text() = '"+nota+"']"));
		element.click();
	}
	 /**
	  * Responsavel por informar a graduacao na P�gina
	  * 
	  * @param graduacao String que vai ser setada no campo
	  * @param esporte String que vai ser setada no campo
	  */
	public void informo_graduacao(String graduacao,String esporte){
		WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+graduacaoCorrecao(graduacao)+", resposta para "+esporte+"\"]"));
		element.click();
	}
	 /**
	  * Responsavel por informar os ingredientes na P�gina
	  * 
	  * @param comida String que vai ser setada no campo
	  * @param ingrediente String que vai ser setada no campo
	  */
	public void informo_ingredientes(String comida,String ingrediente){
		WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+comida+", resposta para "+ingrediente+"\"]"));
		element.click();
	}
	/**
	  * Responsavel por informar a data na P�gina
	  * 
	  * @param quando String que define se vai ser uma data passada ou futura
	  */
	public void informo_data(String quando){
		
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if(quando.equals("passado")) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		
		date = cal.getTime();
		  
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
	
	/**
	  * Responsavel por informar um horario na P�gina
	  * 
	  * @param quando String que define se vai ser um horario futuro ou passado
	  */
	public void informo_horario(String quando){
		 Date date = new Date();  
		 SimpleDateFormat formatter = new SimpleDateFormat("HH");  
		 String hora;
			if(quando.equals("futuro")) {
				  hora = formatter.format(new Date(date.getTime() + 1 * 3600*1000));
			}
			else {
				  hora = formatter.format(new Date(date.getTime() - 1 * 3600*1000));
			}
		
		 formatter = new SimpleDateFormat("mm");
		 String minuto = formatter.format(date);
		 WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Hora\"]"));
		 element.sendKeys(hora);
		 element = driver.findElement(By.xpath("//input[@aria-label=\"Minuto\"]"));
		 element.sendKeys(minuto);
	}
	/**
	  * Responsavel por submeter o formulario
	  *
	  */
	public void submeter(){
		WebElement element = driver.findElement(By.xpath("//span[text() = 'Enviar']"));
	    element.click();   
	}
	/**
	  * Responsavel por perder o foco no campo
	  *
	  */
	public void retirarFoco(){
		WebElement element = driver.switchTo().activeElement();
		element.sendKeys(Keys.TAB);
	} 
	
	/**
	  * Responsavel por fazer uma pequena correcao no parametro de graduacao do formulario
	  *
	  *@param graduacao String quer poder� ser alterada
	  *@return String com a nota do Projeto corrigida
	  */
	public String graduacaoCorrecao(String graduacao) {
		if(graduacao.equals("Otimo")) {
			return "�timo";
		}
		else {
			return graduacao;
		}
	}
}
