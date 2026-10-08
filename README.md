Login seguro com base no PFC

Sistema de login desenvolvido em Java com Spring Boot para atividade acadêmica.

Tecnologias utilizadas

Java 21
Spring Boot
Spring Security
Thymeleaf
MongoDB Atlas
Spring Session
BCrypt

Requisitos

Java 21
Maven
MongoDB Atlas

Configuração

Copie o arquivo `application-local.properties.example` para
`application-local.properties` e preencha os dados:

MONGODB_URI=mongodb+srv://USUARIO:SENHA@SEU_CLUSTER.mongodb.net/login_seguro?retryWrites=true&w=majority&tls=true
MONGODB_DATABASE=login_seguro
PORT=8081
APP_SESSION_COOKIE_SECURE=false

Administrador

E-mail: admin@gmail.com
Senha: fornecida separadamente ao professor.

Como executar

Na pasta principal do projeto, execute:

```bash
mvn spring-boot:run
```

Acesse http://localhost:8081.

No NetBeans, execute a classe AplicacaoLoginSeguro com a raiz do projeto como diretório de trabalho.

No Atlas, crie um usuário de banco com acesso ao banco login_seguro e autorize o IP público do seu computador. Na URI, codifique os caracteres especiais da senha para URL. Mantenha `tls=true` para proteger a conexão com o Atlas.





