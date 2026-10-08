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

No NetBeans, execute a classe `AplicacaoLoginSeguro` com a raiz do projeto como diretório de trabalho.

No Atlas, crie um usuário de banco com acesso ao banco `login_seguro` e autorize o IP público do seu computador. Na URI, codifique os caracteres especiais da senha para URL. Mantenha `tls=true` para proteger a conexão com o Atlas.

`APP_SESSION_COOKIE_SECURE=false` é usado no site local com HTTP. Se publicar o site com HTTPS, altere para `true`.

Não envie `application-local.properties`, `acesso-admin.local.txt` ou `.env` ao GitHub. O arquivo `application-local.properties.example` pode ser publicado, pois contém apenas exemplos. A conta administrativa mencionada existe no Atlas da apresentação; ela não é criada automaticamente em outro banco.

Gitflow

- `main`: versão estável para entrega.
- `develop`: integração das alterações.
- `feature/*`: desenvolvimento de funcionalidades ou documentação.
- `release/*`: preparação de uma versão.
- `hotfix/*`: correções urgentes da versão estável.
