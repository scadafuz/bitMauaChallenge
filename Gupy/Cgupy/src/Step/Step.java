package Step;

import static org.junit.Assert.assertEquals;



import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObject.PaginaDesafio_;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Step {
	WebDriver driver;
	
	Properties propriedades=Support.Property.getProp();
	String url=propriedades.getProperty("url").trim();
	Integer timeOut=Integer.parseInt(propriedades.getProperty("timeOut").trim());
	String browser=propriedades.getProperty("browser").trim();
	boolean headless=Boolean.parseBoolean(propriedades.getProperty("headless").trim());;
	PaginaDesafio_ paginaDesafio= new PaginaDesafio_(driver);
	
	
	@Given("^Acesso a pagina de teste$")
	public void acesso_a_pagina_de_teste() throws InterruptedException {
		
		driver=paginaDesafio.acessar(url,browser,headless);
	}

	@When("^eu informo apenas o nome '(.*)' no campo 'Qual seu nome completo\\?'$")
	public void eu_informo_apenas_o_nome_Bruno_no_campo_Qual_seu_nome_completo(String nome) throws InterruptedException {
		paginaDesafio.informo_nome(nome);	
	}

	@When("^e retiro o foco do campo$")
	public void e_retiro_o_foco_do_campo() throws InterruptedException {
		paginaDesafio.retirarFoco();
	}

	@Then("o sistema deve exibir uma mensagem informando 'Preencha o sobrenome'$")
	public void dever_exibir_uma_mensagem_informando_Preencha_o_sobrenome() {
		WebElement element = driver.findElement(By.className("freebirdFormviewerViewItemsItemErrorMessage"));
		
		assertEquals("Preencha o sobrenome", element.getText());
		
		
	}

	@When("^eu informo o nome completo '(.*)' no campo 'Qual seu nome completo\\?'$")
	public void eu_informo_o_nome_Bruno_Viana_no_campo_Qual_seu_nome_completo(String nome) throws InterruptedException {
		paginaDesafio.informo_nome(nome);
	}

	@Then("^o sistema nao deve exibir mensagem$")
	public void o_sistema_nao_deve_exibir_mensagem() {
		WebElement element = driver.findElement(By.className("freebirdFormviewerViewItemsItemErrorMessage"));
		assertEquals(false, element.isDisplayed());
	}
		
@When("^informo o email '(.*)' no campo 'Qual seu e-mail\\?'$")
	public void informo_o_email_brunovianalopes_gmail_com_no_campo_Qual_seu_e_mail(String email) {
	paginaDesafio.informo_email(email);
}

	@When("^informo a cor favorita '(.*)' no campo 'Qual sua cor favorita\\?'$")
	public void informo_a_cor_favorita_Azul_no_campo_Qual_sua_cor_favorita(String cor) {
		paginaDesafio.informo_cor_favorita(cor);
	}

	@When("^informo a sobremesa favorita '(.*)' no campo 'Qual sua sobremesa favorita\\?'$")
	public void informo_a_sobremesa_favorita_bolo_no_campo_Qual_sua_sobremesa_favorita(String sobremesa) {
		paginaDesafio.informo_sobremesa(sobremesa);
	}

	@When("^informo a comida favorita '(.*)' no campo 'Qual sua comida favorita\\?'$")
	public void informo_a_comida_favorita_Legumes_no_campo_Qual_sua_comida_favorita(String comida) throws InterruptedException {		
		paginaDesafio.informo_comida(comida);
		
	}

	@When("^informo a graduacao '(.*)' no campo 'O quanto voce gosta de animais\\?'$")
	public void informo_a_graduacao_no_campo_O_quanto_voce_gosta_de_animas(String nota) {
		paginaDesafio.informo_nota_animais(nota);
		
	}

	@When("^informo a graduacao '(.*)' no campo 'Considere os esportes - (.*)'$")
	public void informo_a_graduacao_Mediano_no_campo_Considere_os_esportes_Rugby(String graduacao,String esporte) {
		paginaDesafio.informo_graduacao(graduacao, esporte);
	}
	
	@When("^informo a ingredientes '(.*)' no campo 'Quais os ingredientes do sandwich\\? - (.*)'$")
	public void informo_a_ingredientes_Carne_no_campo_Quais_os_ingredientes_do_sandwich_Xburguer(String comida,String ingrediente) {
		paginaDesafio.informo_ingredientes(comida,ingrediente);
	   
	}
	
	@When("^informo o dia 'atual' no campo 'Que dia e hoje\\?'$")
	public void informo_o_dia_atual_no_campo_Que_dia_e_hoje() {
	    
		paginaDesafio.informo_data_atual();
		
	}

	@When("^informo o horario 'atual' no campo 'Daqui uma hora, que horas serao\\?'$")
	public void informo_o_horario_atual_no_campo_Daqui_uma_hora_que_horas_serao() {
		
		paginaDesafio.informo_horario_atual();
		
	}
	
	@When("^clico no Botao 'Enviar'$")
	public void clico_no_Botao_Enviar() {
		paginaDesafio.submeter(); 
	}
	
	@Then("^o sistema deve submeter o formulario$")
	public void o_sistema_deve_submeter_o_formulario() throws InterruptedException {
	timeOut();
	WebElement element = driver.findElement(By.xpath("//div[text() = 'Sua resposta foi registrada.']"));
	assertEquals(true, element.isDisplayed());
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void timeOut() throws InterruptedException {
		
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	
}
