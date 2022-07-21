### Projeto Final IMD0040 - III Unidade
#### Participantes: Davi Carvalho, Larissa Jales e Péricles Gomes
#### O propósito do MiniMarket é a criação de um sistema de automação de estoque de produtos. 
##### O projeto foi dividido nos seguintes pacotes: 
- *Connection*: Onde se situam as classes de conexão com o banco de dados. Tanto genéricas, utilizando hibernate, como específicas de cada entidade;
- *Domain*: Que contém as classes específicas de domínio, bem como as responsáveis pela interação com usuário;
- *Enum*: Onde segregamos os enumetations utilizados para nossas instâncias constantes. 

###### O programa conta com um banco de dados local em sqlite. Ao executar a aplicação, um arquivo de nome db.sqlite é gerado no mesmo diretório.

#### Instruções de como realizar o build 
Para o gerenciamento do projeto, utilizamos algumas fases do ciclo de vida da ferramenta *Maven*, tais como *compile* e *install*, responsáveis, respectivamente, por buildar uma versão compilada do programa e instalar as dependências descritas no arquivo pom.xml. 
Para construí-lo e obter uma versão executável de produção basta chamar pela ação *package* e um arquivo *.jar* será encontrado na pasta target.

#### Instruções de como executar o programa
Em ambiente de desenvolvimento pode-se executar a função *Main* presente na classe *App.java*.
Para executar o arquivo *.jar* gerado no item anterior basta, em linha de comando, efetuar a entrada `java -jar caminho-programa/nome-programa.jar`.

#### Diagrama do projeto (MiniMarket) 
![diagrama-do-projeto](https://github.com/periclesgdc/lp2-projeto-final/blob/main/diagrama.png)

#### Link para o vídeo de apresentação
https://youtu.be/8Ya-ODezW6k
