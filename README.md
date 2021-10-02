<h1 align="center">
  <img alt="banner" title="banner" src="src/main/webapp/banner.png" />
</h1>

# :computer: carteira
O projeto *carteira* consiste em uma aplicação Web Java cujo objetivo é registrar transações realizadas no mercado financeiro.

Este projeto foi desenvolvido no Módulo 1 do Bootcamp Java Alura 2021.

### :hourglass: Status do projeto
Concluído.

### :hammer_and_wrench: Tecnologias

As seguintes tecnologias e ferramentas foram utilizadas no desenvolvimento deste projeto:

- [Java](https://www.oracle.com/java/)
- [Servlet](https://www.oracle.com/java/technologies/java-servlet-tec.html)
- [JSP (JavaServer Pages)](https://www.oracle.com/java/technologies/jspt.html)
- [JSTL (JavaServer Pages Standard Tag Library)](https://www.oracle.com/java/technologies/java-server-tag-library.html)
- [JDBC (Java Database Connectivity)](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)
- [Bootstrap](https://getbootstrap.com/)
- [Maven](https://maven.apache.org/)
- [Tomcat](http://tomcat.apache.org/)
- [MySQL](https://www.mysql.com/)
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)

A aplicação foi desenvolvida na linguagem Java. A tecnologia Servlet foi utilizada para tratar as requisições HTTP. As páginas Web foram construídas com JSP/JSTL e estilizadas com os recursos do framework Bootstrap. O acesso ao banco de dados foi realizado por meio do JDBC. O Maven foi empregado para gerenciar a construção e as dependências da aplicação.

O controle de versão do código é realizado com o Git. A aplicação roda no servidor Tomcat e utiliza o banco de dados MySQL. O docker é empregado para criar os contêineres necessários para executar a aplicação.

### :page_with_curl: Features
- [x] Cadastro de transações
- [x] Listagem de transações
- [x] Edição de transações
- [x] Exclusão de transações

### :pencil: Pré-requisitos

Antes de começar, você precisa ter instalado em sua máquina as seguintes ferramentas:
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)

### :rocket: Executando a aplicação

```bash
# Clone este repositório
$ git clone https://github.com/antonioeloy/carteira.git

# Execute os contêineres da aplicação
$ docker-compose up

# Acesse o seguinte endereço no navegador
$ http://localhost:8080/carteira/transacoes
```

### :gear: Testando a aplicação

A aplicação permite realizar um CRUD de transações, conforme imagens a seguir:

<h1 align="center">
  <img alt="listagem" title="listagem" src="src/main/webapp/listagem.PNG" />
</h1>

<h1 align="center">
  <img alt="cadastro" title="cadastro" src="src/main/webapp/cadastro.PNG" />
</h1>

<h1 align="center">
  <img alt="edicao" title="edicao" src="src/main/webapp/edicao.PNG" />
</h1>

### :copyright: Licença

Este projeto está licenciado nos termos da licença MIT.
