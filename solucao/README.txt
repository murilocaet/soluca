***********************
RESUMO DO SISTEMA
***********************
Este software foi desenvolvido com o intuito de solucionar um problema bastante corriqueiro no dia a dia de algumas empresas/pessoas. 
Voltado para a �rea de entrega de mercadorias, o servi�o fornecido � o de calcular a melhor rota de entrega, mais curta e com o menor 
custo, tendo como dados para utiliza��o no mapeamento e busca apenas o ponto inicial(A), o ponto final(B) e a dist�ncia entre os dois 
pontos. Essa limita��o de dados trava um pouco o sistema deixando ele �s cegas(de certa forma), pois n�o da pra ter no��o de dire��o, 
tr�fego, e por ai vai! Bom, com esses dados carregados no sistema, o usu�rio informar� o destino das mercadorias, autonomia do 
ve�culo (em Km), custo m�dio e receber� o roteiro que deve seguir. 



***********************
ARQUITETURA DO SISTEMA
***********************
1	Constru��o do �BACK-END� + WebService

1.1.	Linguagem JAVA

1.2.	Eclipse IDE

1.3.	Tomcat 7

1.4.	jre1.8.0_121

1.5.	Projeto Dynamic Web Module 3.0

1.6.	LIBS

1.6.1.	jersey-1.19.1

1.6.2.	jackson-1.9.2

1.6.3.	jettison-1.1

1.6.4.	asm-3.1

1.6.5.	jsr311-1.1.1

1.6.6.	hamcrest-core-1.3

1.6.7.	junit-4.12



2	Constru��o do �FRON-END� + Cliente

2.1.	Linguagem AngularJs

2.2.	LIBS

2.2.1.	angularJs-1.5.8

2.2.2.	bootstrap- 3.3.7



3	Protocolo para troca de mensagens WebService/Cliente

3.1.	JSON

3.1.1.	Layout das malhas para o Webservice

3.1.1.1.	Mapa

				{"malhas":[

				{"nome":"BA","rotas":[

				{"origem":"A","destino":"B","km":"10.0"},

				{"origem":"B","destino":"D","km":"15.0"}, 

				{"origem":"A","destino":"C","km":"20.0"},

				{"origem":"C","destino":"D","km":"30.0"}, 

				{"origem":"B","destino":"E","km":"50.0"}, 

				{"origem":"D","destino":"E","km":"30.0"}]},

				{"nome":"SP","rotas":[

				{"origem":"A","destino":"B","km":"10.0"},

				{"origem":"B","destino":"D","km":"15.0"}, 

				{"origem":"A","destino":"C","km":"20.0"},

				{"origem":"C","destino":"D","km":"30.0"}, 

				{"origem":"B","destino":"E","km":"50.0"}, 

				{"origem":"D","destino":"E","km":"30.0"}]},

				{...},

				{...}

				]}

3.1.1.2.	Rotas

				{"malhas":[

				{"nome":"BA","rotas":[

				{"origem":"A","destino":"D","km":"10.0","custoMedio":"2.5"},

				{"origem":"A","destino":"B","km":"10.0","custoMedio":"2.5"},

				{"origem":"B","destino":"D","km":"15.0","custoMedio":"2.5"}, 

				{"origem":"A","destino":"C","km":"20.0","custoMedio":"2.5"},

				{"origem":"C","destino":"D","km":"30.0","custoMedio":"2.5"}, 

				{"origem":"B","destino":"E","km":"50.0","custoMedio":"2.5"}, 

				{"origem":"D","destino":"E","km":"30.0","custoMedio":"2.5"}]},

				{"nome":"SP","rotas":[

				{"origem":"A","destino":"D","km":"10.0","custoMedio":"2.5"},

				{"origem":"A","destino":"B","km":"10.0","custoMedio":"2.5"},

				{"origem":"B","destino":"D","km":"15.0","custoMedio":"2.5"}, 

				{"origem":"A","destino":"C","km":"20.0","custoMedio":"2.5"},

				{"origem":"C","destino":"D","km":"30.0","custoMedio":"2.5"}, 

				{"origem":"B","destino":"E","km":"50.0","custoMedio":"2.5"}, 

				{"origem":"D","destino":"E","km":"30.0","custoMedio":"2.5"}]},

				{...},

				{...}

				]}


J� havia trabalhado com AngularJs em um projeto ano passado, aqui nessa mesma empresa que trabalho hoje, e foi uma experi�ncia 
fant�stica! AngularJs � fant�stico!!  Infelizmente o projeto que atuo hoje n�o utiliza mais o AngularJs, est�o usando 
JAVA, JSF + integra��o com COBOL. Quando li que podia usar a tecnologia que eu quisesse, tendo como a principal o JAVA, n�o pensei 
duas vezes em usar o AngularJs para o FRONT-END como cliente do webservice. 


****************************************************
INSTRU��ES SOBRE CONFIGURA��O/INSTALA��O NO ECLIPSE
****************************************************
Existem duas formas de configurar este sistema, segue abaixo:

1	Cria��o de um novo projeto JAVA Dynamic Web Module 3.0;

1.1.	Substitui��o das pastas �src� e �WebContent� pelas pastas correspondentes que foram baixadas do reposit�rio;

2	Copiar a pasta do projeto no �workspace� do eclipse;

2.1.	Importar projeto existente no workspace;



****************************************
INSTRU��ES SOBRE COMO OPERAR O PROGRAMA
****************************************
O sistema ficou bem intuitivo e com apenas duas telas consumindo o Webservice!

1	A tela MAPAS � utilizada para fazer a carga da malha de mapas no sistema, ou se preferir, pode ser enviada de outra aplica��o para 
    a URL do webservice, passando o JSON.
    
1.1.	Caminho do servi�o de MAPAS: ".../services/malhas/carregarMalhas"

2	A tela ROTAS � utilizada para fazer a carga do destino das entregas no sistema, ou se preferir, pode ser enviada de outra aplica��o 
    para a URL do webservice, passando o JSON. A resposta � um JSON contendo o roteiro das entregas.
    
2.1.	Caminho do servi�o de ROTAS: ".../services/rotas/obterRotas"

2.2.	Layout JSON de resposta

				{"erros":[

				{"mensagem":"texto1"},

				{"mensagem":"texto2"}],"rotas":[

				{"id":"1","origem":"A","destino":"D","descricao":"A B D", "km":"25.0","autonomia":"10.0","custoMedio":"6.25","roteiro":"","mapa":{"nome":"BA"}},

				{"id":"2","origem":"A","destino":"C","descricao":"A C", "km":"20.0","autonomia":"10.0","custoMedio":"5.0","roteiro":"","mapa":{"nome":"BA"}}]}



***********************
AGRADECIMENTOS
***********************
A todos os envolvidos, desde o recebimento do meu curr�culo at� a equipe respons�vel por desenvolver e me avaliar neste teste, agrade�o 
a oportunidade de poder participar deste processo e por realizar este teste! Foi muito empolgante cada etapa do processo, poder pensar 
um pouco em como s�o feitas essas entregas, como funciona essa log�stica e por fim por poder criar um poss�vel solu��o para o caso. 
Obrigado por me motivarem!



***********************
REFLEX�O
***********************
O algoritmo criado cumpre o objetivo proposto, mas eu poderia ter criado um mais elaborado se existissem mais vari�veis para se usar nos 
mapeamentos e nas buscas das melhores rotas. Apenas a Origem, o Destino e a Dist�ncia tornam as possibilidades mais engessadas, mas valeu!! 
Deu pra empolgar mesmo assim, gostei muito de ter passado esses dias bolando as poss�veis solu��es, seria bom ter mais desafios desse com 
mais frequ�ncia! Mais uma vez obrigado e espero que o resultado seja satisfat�rio! Forte abra�o a todos!



***********************
OBSERVA��ES
***********************
Pensei em usar outras tecnologias em conjunto, como CDI, SPRING MVC, MAVEN, mas acabei desistindo por conta do prazo de entrega. Devido �s 
minhas atividades aqui no trabalho, tive pouco tempo para pensar numa solu��o e implementar que optei por n�o gastar tempo configurando 
estas tecnologias, a n�o ser que fossem necess�rias para a solu��o do problema, o que n�o era, nesse caso.



***********************
CR�DITOS
***********************
Desenvolvedor do sistema e do algoritmo de mapeamento e busca:
MURILO C. M. COSTA
murilo.caet@gmail.com

