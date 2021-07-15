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
 
O projeto tem como objetivo ser um controle de estoque simples com adição, remoção e atualização de produtos e usuários.

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

#### Tabela para usuários (não possui login no sistema)
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

#### Página de login
![página login](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/imagens-readme/pagina-login.png?raw=true)

#### Página de cadastro de produto
![página novo produto](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/imagens-readme/pagina-novoproduto.png?raw=true)

#### Página mostrando as informações de um produto
![página produto](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/imagens-readme/pagina-produto.png?raw=true)

#### Página mostrando todos os produtos
![página produtos](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/imagens-readme/pagina-produtos.png?raw=true)

## Observações finais

Algumas dependências estão inclusas no projeto, elas são:
 - [JSTL](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/WebContent/WEB-INF/lib/jstl-1.2.jar)
 - [PostgreSQL Driver](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/WebContent/WEB-INF/lib/postgresql-9.1-901-1.jdbc4.jar)
 - [Bootstrap](https://github.com/GuilhermeTonello/controle-estoque-jsp/blob/master/WebContent/resources/css/bootstrap.min.css)
