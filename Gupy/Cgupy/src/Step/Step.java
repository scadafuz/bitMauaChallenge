package Step;

import static org.junit.Assert.assertEquals;

import java.awt.RenderingHints.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.remote.server.handler.interactions.SendKeyToActiveElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Step {
	WebDriver driver;
	//Properties prop;
    //String url=prop.getProperty("url");
    
	String url="https://docs.google.com/forms/d/e/1FAIpQLSfWfPcADbvEPrGDePWhY-agioR1TAyFZTW-hwNTucN28-VACg/viewform";
	int timeOut=10;
	String browser="chrome";
	boolean headless=false;
	
	
	
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
		if(headless) {
			options.addArguments("--headless");
			options.addArguments("--hide-scrollbars");
			options.addArguments("--disable-gpu");
			options.addArguments("--log-level=3");
		}
		
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
		driver.quit();
		
	}

	@When("^eu informo o nome completo '(.*)' no campo 'Qual seu nome completo\\?'$")
	public void eu_informo_o_nome_Bruno_Viana_no_campo_Qual_seu_nome_completo(String nome) throws InterruptedException {
		 WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Qual seu nome completo?\"]"));
		 element.sendKeys(nome);
		 timeOut();
	}

	@Then("^o sistema nao deve exibir mensagem$")
	public void o_sistema_nao_deve_exibir_mensagem() {
		WebElement element = driver.findElement(By.className("freebirdFormviewerViewItemsItemErrorMessage"));
		assertEquals(false, element.isDisplayed());
	
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//0
	

@When("^informo o email '(.*)' no campo 'Qual seu e-mail\\?'$")
public void informo_o_email_brunovianalopes_gmail_com_no_campo_Qual_seu_e_mail(String email) {
	WebElement element = driver.findElement(By.xpath("//input[@aria-label=\"Qual seu e-mail?\"]"));
	element.sendKeys(email);
}

@When("^informo a cor favorita 'verde' no campo 'Qual sua cor favorita\\?'$")
public void informo_a_cor_favorita_verde_no_campo_Qual_sua_cor_favorita() {
	WebElement element = driver.findElement(By.xpath("//span[text() = 'Verde']"));
	element.click();
}

@When("^informo a sobremesa favorita 'bolo' no campo 'Qual sua sobremesa favorita\\?'$")
public void informo_a_sobremesa_favorita_bolo_no_campo_Qual_sua_sobremesa_favorita() {
	WebElement element = driver.findElement(By.xpath("//span[text() = 'Bolo']"));
	element.click();
}

@When("^informo a comida favorita '(.*)' no campo 'Qual sua comida favorita\\?'$")
public void informo_a_comida_favorita_Legumes_no_campo_Qual_sua_comida_favorita(String comida) throws InterruptedException {
	
		
	WebElement element = driver.findElement(By.xpath("//span[text() = 'Escolher']"));
	element.click();
	Thread.sleep(1000);
	System.out.println("#####################");
	
	
	element = driver.switchTo().activeElement();
	element.sendKeys(comida);
	
	element = driver.findElement(By.xpath("//div[@data-value=\""+comida+"\"]"));
	WebElement child = element.findElement(By.xpath(".//span"));
	
	

	
	element.sendKeys("");
	element.sendKeys(Keys.ENTER);
	
	System.out.println(child.getText());
	Thread.sleep(1000);
	System.out.println("#####################");
	//element.click();
}

@When("^informo a graduacao '(\\d+)' no campo 'O quanto voce gosta de animais\\?'$")
public void informo_a_graduacao_no_campo_O_quanto_voce_gosta_de_animas(int arg1) {
	WebElement element = driver.findElement(By.xpath("//div[text() = '10']"));
	element.click();
	
}

@When("^informo a graduacao '(.*)' no campo 'Considere os esportes - Rugby'$")
public void informo_a_graduacao_Mediano_no_campo_Considere_os_esportes_Rugby(String graduacao) {
	WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+graduacaoCorrecao(graduacao)+", resposta para Rugby\"]"));
	element.click();
}

@When("^informo a graduacao '(.*)' no campo 'Considere os esportes - Futebol'$")
public void informo_a_graduacao_Ruim_no_campo_Considere_os_esportes_Futebol(String graduacao) {
	WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+graduacaoCorrecao(graduacao)+", resposta para Futebol\"]"));
	element.click();
    
}

@When("^informo a graduacao '(.*)' no campo 'Considere os esportes - Baseball'$")
public void informo_a_graduacao_Bom_no_campo_Considere_os_esportes_Baseball(String graduacao) {
	WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+graduacaoCorrecao(graduacao)+", resposta para Baseball\"]"));
	element.click();
   
}

@When("^informo a graduacao '(.*)' no campo 'Considere os esportes - eSport'$")
public void informo_a_graduacao_Otimo_no_campo_Considere_os_esportes_eSport(String graduacao) {
	WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+graduacaoCorrecao(graduacao)+", resposta para eSport\"]"));
	element.click();
   
}

@When("^informo a ingredientes '(.*)' no campo 'Quais os ingredientes do sandwich\\? - Xburguer'$")
public void informo_a_ingredientes_Carne_no_campo_Quais_os_ingredientes_do_sandwich_Xburguer(String comida) {
	WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+comida+", resposta para Xburguer\"]"));
	element.click();
   
}

@When("^informo a ingredientes '(.*)' no campo 'Quais os ingredientes do sandwich\\? - Vegetariano'$")
public void informo_a_ingredientes_Salada_no_campo_Quais_os_ingredientes_do_sandwich_Vegetariano(String comida) {
	WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+comida+", resposta para Vegetariano\"]"));
	element.click();
   
}

@When("^informo a ingredientes '(.*)' no campo 'Quais os ingredientes do sandwich\\? - Hamburguer'$")
public void informo_a_ingredientes_Carne_no_campo_Quais_os_ingredientes_do_sandwich_Hamburguer(String comida) {
    
	WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+comida+", resposta para Hamburguer\"]"));
	element.click();
}

@When("^informo a ingredientes '(.*)' no campo 'Quais os ingredientes do sandwich\\? - EggXburger'$")
public void informo_a_ingredientes_Carne_no_campo_Quais_os_ingredientes_do_sandwich_EggXburger(String comida) {
	WebElement element = driver.findElement(By.xpath("//div[@aria-label=\""+comida+", resposta para EggXburger\"]"));
	element.click();
    
}

@When("^informo o dia 'atual' no campo 'Que dia e hoje\\?'$")
public void informo_o_dia_atual_no_campo_Que_dia_e_hoje() {
    
	
	WebElement element =driver.findElement(By.xpath("//input[@type='date']"));
	 Date date = new Date();  
	 SimpleDateFormat formatter = new SimpleDateFormat("ddMMYYYY");  
	 String strDate = formatter.format(date);
	element.sendKeys(strDate);
	
}

@When("^informo o horario 'atual' no campo 'Daqui uma hora, que horas serao\\?'$")
public void informo_o_horario_atual_no_campo_Daqui_uma_hora_que_horas_serao() {
	
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

@When("^clico no Botao 'Enviar'$")
public void clico_no_Botao_Enviar() {
	WebElement element = driver.findElement(By.xpath("//span[text() = 'Enviar']"));
    element.click();    
}

@Then("^o sistema deve submeter o formulario$")
public void o_sistema_deve_submeter_o_formulario() throws InterruptedException {
	timeOut();
	WebElement element = driver.findElement(By.xpath("//div[text() = 'Sua resposta foi registrada.']"));
	assertEquals(true, element.isDisplayed());
	driver.quit();
}


public String graduacaoCorrecao(String graduacao) {
	if(graduacao.equals("Otimo")) {
		return "�timo";
	}
	else {
		return graduacao;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void timeOut() throws InterruptedException {
		
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	
}