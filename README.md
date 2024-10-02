# Projeto Vendas

## Objetivo

- Este projeto tem como objetivo criar um sistema de vendas simples, permitindo o cadastro de clientes, produtos e a realização de vendas. Após assistir a diversos cursos, senti a necessidade de colocar em prática o que aprendi ao longo da minha carreira. Por isso, decidi iniciar este projeto.

- Ele surgiu como um desafio pessoal para praticar o desenvolvimento de aplicações web utilizando Spring Boot.

- Além da criação do CRUD para clientes, pretendo adicionar funcionalidades para a criação de produtos e vendas.

- Também pretendo adicionar testes para as camadas de Unidade e Serviço.


## Requisitos

- Java 11 ou superior
- Maven 3.6.3 ou superior
- Git

## Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/usuario/projeto-venda.git
    cd projeto-venda
    ```

2. Compile o projeto usando Maven:
    ```sh
    mvn clean install
    ```

## Configuração

1. Configure o banco de dados no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

## Executando o Projeto

1. Execute a aplicação:
    ```sh
    mvn spring-boot:run
    ```

2. Acesse a aplicação em seu navegador:

- Você pode relaizar requisições para a aplicação utilizando o Postman ou o Insomnia. Basta acessar o endereço:
    ```
    http://localhost:8080
    ```

## Endpoints

- `GET /clientes`: Lista todos os clientes
- `POST /clientes`: Cria um novo cliente
- `PUT /clientes/{id}`: Atualiza um cliente existente
- `DELETE /clientes/{id}`: Deleta um cliente

## Testes

1. Para rodar os testes, execute:
    ```sh
    mvn test
    ```

## Estrutura do Projeto

- `src/main/java`: Código fonte principal
- `src/test/java`: Código fonte dos testes
- `src/main/resources`: Arquivos de configuração


