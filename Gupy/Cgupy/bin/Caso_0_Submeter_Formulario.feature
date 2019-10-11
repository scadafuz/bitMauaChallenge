Feature: Desafio BitMaua Gupy

Scenario:	Submeter o Formulario
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
	And  informo a ingredientes 'Carne' no campo 'Quais os ingredientes do sandwich? - EggXburger'
	And  informo o dia 'atual' no campo 'Que dia e hoje?'
	And  informo o horario 'atual' no campo 'Daqui uma hora, que horas serao?'
	And  clico no Botao 'Enviar'
	Then o sistema deve submeter o formulario
	
	