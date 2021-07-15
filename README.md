# Sobre o projeto

## Integrantes do projeto

[Guilherme Tonello](https://github.com/GuilhermeTonello)

## Tecnologias utilizadas

 - JSP
 - Servlets
 - [Tomcat](https://tomcat.apache.org/download-90.cgi)
 - [JSTL](https://tomcat.apache.org/taglibs/standard/)
 - [PostgreSQL](https://www.postgresql.org/)
 - [Bootstrap](https://getbootstrap.com/)

## Sobre o projeto
 
O projeto tem como objetivo ser um controle de estoque simples com adi��o, remo��o e atualiza��o de produtos e usu�rios.

## Banco de dados

#### Criando o banco de dados:
```sql
CREATE DATABASE "controle-estoque-jsp";
```

#### Tabela para administradores (possui login no sistema):
```sql
CREATE TABLE administradores (
	id BIGSERIAL PRIMARY KEY,
	login VARCHAR(255) NOT NULL,
	senha VARCHAR(255) NOT NULL
);
```

#### Tabela para usu�rios (n�o possui login no sistema)
```sql
CREATE TABLE usuarios (
	id BIGSERIAL PRIMARY KEY,
	login VARCHAR(255) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL
);
```

#### Tabela para os produtos
```sql
CREATE TABLE produtos (
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	quantidade INTEGER,
	valor NUMERIC
);
```

## Imagens

#### P�gina de login
![p�gina login](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/imagens-readme/pagina-login.png?raw=true)

#### P�gina de cadastro de produto
![p�gina novo produto](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/imagens-readme/pagina-novoproduto.png?raw=true)

#### P�gina mostrando as informa��es de um produto
![p�gina produto](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/imagens-readme/pagina-produto.png?raw=true)

#### P�gina mostrando todos os produtos
![p�gina produtos](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/imagens-readme/pagina-produtos.png?raw=true)

## Observa��es finais

Algumas depend�ncias est�o inclusas no projeto, elas s�o:
 - [JSTL](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/WebContent/WEB-INF/lib/jstl-1.2.jar)
 - [PostgreSQL Driver](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/WebContent/WEB-INF/lib/postgresql-9.1-901-1.jdbc4.jar)
 - [Bootstrap](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/WebContent/resources/css/bootstrap.min.css)
