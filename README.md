***********************
RESUMO DO SISTEMA
***********************
Este software foi desenvolvido com o intuito de solucionar um problema bastante corriqueiro no dia a dia de algumas empresas/pessoas. 
Voltado para a área de entrega de mercadorias, o serviço fornecido é o de calcular a melhor rota de entrega, mais curta e com o menor 
custo, tendo como dados para utilização no mapeamento e busca apenas o ponto inicial(A), o ponto final(B) e a distância entre os dois 
pontos. Essa limitação de dados trava um pouco o sistema deixando ele às cegas(de certa forma), pois não da pra ter noção de direção, 
tráfego, e por ai vai! Bom, com esses dados carregados no sistema, o usuário informará o destino das mercadorias, autonomia do 
veículo (em Km), custo médio e receberá o roteiro que deve seguir. 



***********************
ARQUITETURA DO SISTEMA
***********************
1	<b>Construção do “BACK-END” + WebService</b>

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



2	<b>Construção do “FRON-END” + Cliente</b>

2.1.	Linguagem AngularJs

2.2.	LIBS

2.2.1.	angularJs-1.5.8

2.2.2.	bootstrap- 3.3.7



3	<b>Protocolo para troca de mensagens WebService/Cliente</b>

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


Já havia trabalhado com AngularJs em um projeto ano passado, aqui nessa mesma empresa que trabalho hoje, e foi uma experiência 
fantástica! AngularJs é fantástico!!  Infelizmente o projeto que atuo hoje não utiliza mais o AngularJs, estão usando 
JAVA, JSF + integração com COBOL. Quando li que podia usar a tecnologia que eu quisesse, tendo como a principal o JAVA, não pensei 
duas vezes em usar o AngularJs para o FRONT-END como cliente do webservice. 


****************************************************
INSTRUÇÕES SOBRE CONFIGURAÇÃO/INSTALAÇÃO NO ECLIPSE
****************************************************
Existem duas formas de configurar este sistema, segue abaixo:

1	<b>Criação de um novo projeto JAVA Dynamic Web Module 3.0;</b>

1.1.	Substituição das pastas ‘src’ e ‘WebContent’ pelas pastas correspondentes que foram baixadas do repositório;

2	<b>Copiar a pasta do projeto no ‘workspace’ do eclipse;</b>

2.1.	Importar projeto existente no workspace;



****************************************
INSTRUÇÕES SOBRE COMO OPERAR O PROGRAMA
****************************************
O sistema ficou bem intuitivo e com apenas duas telas consumindo o Webservice!

1	A tela MAPAS é utilizada para fazer a carga da malha de mapas no sistema, ou se preferir, pode ser enviada de outra aplicação para 
    a URL do webservice, passando o JSON.
    
1.1.	Caminho do serviço de MAPAS: “.../services/malhas/carregarMalhas

2	A tela ROTAS é utilizada para fazer a carga do destino das entregas no sistema, ou se preferir, pode ser enviada de outra aplicação 
    para a URL do webservice, passando o JSON. A resposta é um JSON contendo o roteiro das entregas.
    
2.1.	Caminho do serviço de ROTAS: “.../services/rotas/obterRotas”
2.2.	Layout JSON de resposta

				{"erros":[

				{"mensagem":"texto1"},

				{"mensagem":"texto2"}],"rotas":[

				{"id":"1","origem":"A","destino":"D","descricao":"A B D", "km":"25.0","autonomia":"10.0","custoMedio":"6.25","roteiro":"","mapa":{"nome":"BA"}},

				{"id":"2","origem":"A","destino":"C","descricao":"A C", "km":"20.0","autonomia":"10.0","custoMedio":"5.0","roteiro":"","mapa":{"nome":"BA"}}]}



***********************
AGRADECIMENTOS
***********************
A todos os envolvidos, desde o recebimento do meu currículo até a equipe responsável por desenvolver e me avaliar neste teste, agradeço 
a oportunidade de poder participar deste processo e por realizar este teste! Foi muito empolgante cada etapa do processo, poder pensar 
um pouco em como são feitas essas entregas, como funciona essa logística e por fim por poder criar um possível solução para o caso. 
Obrigado por me motivarem!



***********************
REFLEXÃO
***********************
O algoritmo criado cumpre o objetivo proposto, mas eu poderia ter criado um mais elaborado se existissem mais variáveis para se usar nos 
mapeamentos e nas buscas das melhores rotas. Apenas a Origem, o Destino e a Distância tornam as possibilidades mais engessadas, mas valeu!! 
Deu pra empolgar mesmo assim, gostei muito de ter passado esses dias bolando as possíveis soluções, seria bom ter mais desafios desse com 
mais frequência! Mais uma vez obrigado e espero que o resultado seja satisfatório! Forte abraço a todos!



***********************
OBSERVAÇÕES
***********************
Pensei em usar outras tecnologias em conjunto, como CDI, SPRING MVC, MAVEN, mas acabei desistindo por conta do prazo de entrega. Devido às 
minhas atividades aqui no trabalho, tive pouco tempo para pensar numa solução e implementar que optei por não gastar tempo configurando 
estas tecnologias, a não ser que fossem necessárias para a solução do problema, o que não era, nesse caso.



***********************
CRÉDITOS
***********************
Desenvolvedor do sistema e do algoritmo de mapeamento e busca:
MURILO C. M. COSTA
murilo.caet@gmail.com

