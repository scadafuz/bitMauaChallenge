Feature: Desafio BitMaua Gupy

Scenario:	Testar preenchimento com email invalido
	Given Acesso a pagina de teste  
	When eu informo o nome completo 'Bruno Viana' no campo 'Qual seu nome completo?' 
	And  informo o email 'bruno@' no campo 'Qual seu e-mail?'
	Then o sistema n�o deve exibir a mensagem 'Esse e-mail n�o parece v�lido'
	
	