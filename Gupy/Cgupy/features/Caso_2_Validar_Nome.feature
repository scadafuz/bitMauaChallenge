Feature: Desafio BitMaua Gupy

Scenario:	Testar nome com sobremenome
	Given Acesso a pagina de teste  
	When eu informo o nome completo 'Bruno Viana' no campo 'Qual seu nome completo?' 
	And  e retiro o foco do campo
	Then o sistema nao deve exibir mensagem