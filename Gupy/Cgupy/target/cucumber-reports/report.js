$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Test.feature");
formatter.feature({
  "name": "Desafio BitMaua Gupy",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testar nome sem sobremenome",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Acesso a pagina de teste",
  "keyword": "Given "
});
formatter.match({
  "location": "GupyTest.acesso_a_pagina_de_teste()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "eu informo apenas o nome \u0027Bruno\u0027 no campo \u0027Qual seu nome completo?\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "GupyTest.eu_informo_apenas_o_nome_Bruno_no_campo_Qual_seu_nome_completo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "e retiro o foco do campo",
  "keyword": "And "
});
formatter.match({
  "location": "GupyTest.e_retiro_o_foco_do_campo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o sistema deve exibir uma mensagem informando \u0027Preencha o sobrenome\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "GupyTest.dever_exibir_uma_mensagem_informando_Preencha_o_sobrenome()"
});
formatter.result({
  "status": "passed"
});
});