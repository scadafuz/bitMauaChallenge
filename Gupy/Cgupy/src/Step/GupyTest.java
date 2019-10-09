package Step;

import static org.junit.Assert.assertEquals;

import java.awt.List;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class GupyTest {
	WebDriver driver;
	
	String url="https://docs.google.com/forms/d/e/1FAIpQLSfWfPcADbvEPrGDePWhY-agioR1TAyFZTW-hwNTucN28-VACg/viewform";
	int timeOut=10;
	String browser="chrome"; //firefox
	
	@SuppressWarnings("deprecation")
	@Given("^Acesso a pagina de teste$")
	public void acesso_a_pagina_de_teste() throws InterruptedException {
		
	if(browser=="firefox") {	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\bruno\\Desktop\\WEB_DRIVERS\\geckodriver.exe");
		driver = new FirefoxDriver();
		 timeOut();
	    driver.get(url);
	    timeOut();
	}
	else if(browser=="chrome"){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\Desktop\\WEB_DRIVERS\\chromedriver77.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		/*options.addArguments("--headless");
		options.addArguments("--hide-scrollbars");
		options.addArguments("--disable-gpu");
		options.addArguments("--log-level=3");*/
		
		driver = new ChromeDriver(options);
	    driver.get(url);
	    timeOut();
	}
	
	}

	@When("^eu informo apenas o nome '(.*)' no campo 'Qual seu nome completo\\?'$")
	public void eu_informo_apenas_o_nome_Bruno_no_campo_Qual_seu_nome_completo(String nome) throws InterruptedException {
		 WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Qual seu nome completo?\"]"));
		 element.sendKeys(nome);
		 timeOut();
	}

	@When("^e retiro o foco do campo$")
	public void e_retiro_o_foco_do_campo() throws InterruptedException {
		 WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Qual seu e-mail?\"]"));
		 element.click();
		 timeOut();
		
	}

	@Then("o sistema deve exibir uma mensagem informando 'Preencha o sobrenome'$")
	public void dever_exibir_uma_mensagem_informando_Preencha_o_sobrenome() {
		WebElement element = driver.findElement(By.className("freebirdFormviewerViewItemsItemErrorMessage"));
		
		assertEquals("Preencha o sobrenome", element.getText());
      
	}

	
	
	public void timeOut() throws InterruptedException {
		
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	
}