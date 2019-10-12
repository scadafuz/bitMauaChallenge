Feature: Validacao de campos

Scenario:	Testar validacao do campo 'Qual seu nome completo?' ao digitar apenas uma palavra
	Given Acesso a pagina de teste  
	When eu informo apenas o nome 'Bruno' no campo 'Qual seu nome completo?' 
	And  e retiro o foco do campo
	Then o sistema deve exibir a mensagem 'Preencha o sobrenome'
				
Scenario:	Testar validacao do campo 'Qual seu e-mail?' digitando um email invalido
	Given Acesso a pagina de teste  
	When eu informo o nome completo 'Bruno Viana' no campo 'Qual seu nome completo?' 
	And  informo o email 'bruno@' no campo 'Qual seu e-mail?'
	And  e retiro o foco do campo
	Then o sistema deve exibir a mensagem 'Esse e-mail n�o parece v�lido'
	
Scenario:	Testar validacao no campo 'Considere os esportes' ao informar mais de uma resposta por coluna
	Given Acesso a pagina de teste  
	When eu informo o nome completo 'Bruno Viana' no campo 'Qual seu nome completo?' 
	And  informo o email 'brunovianalopes@gmail.com' no campo 'Qual seu e-mail?'
	And  informo a cor favorita 'Azul' no campo 'Qual sua cor favorita?'
	And  informo a sobremesa favorita 'Bolo' no campo 'Qual sua sobremesa favorita?'
	And  informo a comida favorita 'Legumes' no campo 'Qual sua comida favorita?'
	And  informo a graduacao '10' no campo 'O quanto voce gosta de animais?'
	And  informo a graduacao 'Mediano' no campo 'Considere os esportes - Rugby'
	And  informo a graduacao 'Mediano' no campo 'Considere os esportes - Futebol'
	And  informo a graduacao 'Mediano' no campo 'Considere os esportes - Baseball'
	And  informo a graduacao 'Mediano' no campo 'Considere os esportes - eSport'
	Then o sistema deve exibir a mensagem 'N�o selecione mais de uma resposta por coluna'
	
Scenario:	Testar validacao do campo  'Qual sua sobremesa favorita?' ao escolher a op��o Outro
	Given Acesso a pagina de teste  
	When eu informo o nome completo 'Bruno Viana' no campo 'Qual seu nome completo?' 
	And  informo o email 'brunovianalopes@gmail.com' no campo 'Qual seu e-mail?'
	And  informo a cor favorita 'Azul' no campo 'Qual sua cor favorita?'
	And  informo a sobremesa favorita 'Outro:' no campo 'Qual sua sobremesa favorita?'
	Then o sistema deve exibir a mensagem 'Esta pergunta � obrigat�ria'
	
Scenario:	Testar validacao do campo 'Quais os ingredientes do sandwich?' ao informar menos de uma resposta por linha
	Given Acesso a pagina de teste  
	When eu informo o nome completo 'Bruno Viana' no campo 'Qual seu nome completo?' 
	And  informo o email 'brunovianalopes@gmail.com' no campo 'Qual seu e-mail?'
	And  informo a cor favorita 'Azul' no campo 'Qual sua cor favorita?'
	And  informo a sobremesa favorita 'Bolo' no campo 'Qual sua sobremesa favorita?'
	And  informo a comida favorita 'Legumes' no campo 'Qual sua comida favorita?'
	And  informo a graduacao '10' no campo 'O quanto voce gosta de animais?'
	And  informo a graduacao 'Mediano' no campo 'Considere os esportes - Rugby'
	And  informo a graduacao 'Ruim' no campo 'Considere os esportes - Futebol'
	And  informo a graduacao 'Bom' no campo 'Considere os esportes - Baseball'
	And  informo a graduacao 'Otimo' no campo 'Considere os esportes - eSport'
	And  informo a ingredientes 'Carne' no campo 'Quais os ingredientes do sandwich? - Xburguer'
	And  informo a ingredientes 'Salada' no campo 'Quais os ingredientes do sandwich? - Vegetariano'
	And  informo a ingredientes 'Carne' no campo 'Quais os ingredientes do sandwich? - Hamburguer'
	Then o sistema deve exibir a mensagem 'Esta pergunta exige pelo menos uma resposta por linha' 
	
Scenario:	Exibicao de mensagem ao tentar enviar formulario sem preencher os campos obrigatorios
	Given Acesso a pagina de teste  
 	And  clico no Botao 'Enviar'
	Then o sistema deve exibir mensagens informando os campo obrigatorio

