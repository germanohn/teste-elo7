# Teste de Programação Elo7

Projeto para vaga de backend na Elo7.

A descrição do problema está presente nesse [gist](https://github.com/germanohn/teste-elo7/blob/main/explorando_marte_programming_test.md).

### Descrição do projeto

Na pasta src-cpp está a solução para o problema em C++ em que o
console é usado como entrada da mesma forma que na descrição do
problema. Para testar, compile o programa com
`gcc main.cpp sonda.cpp -o main` e então rode o executável com `./main`.

Na pasta src-java está a solução para o problema em Java. O projeto
foi criado e rodado usando a IDE IntelliJ. Para rodar a versão usando
o console, como no enunciado do problema, basta rodar a class Main. Já
para utilizar a solução com o web service e testar as requisições
http, como descrito na documentação Swagger, basta executar a classe
SondasApplication.

#### Tecnologias usadas

- Spring Boot: para desenvolver o serviço web.
- Swagger: para a documentação da API.

#### Documentação

Todas as classes, métodos e variáveis públicas foram documentadas
usando javadoc.

Além disso, foi feita uma documentação da API usando Swagger que, uma
vez que a aplicação esteja sendo executada, pode ser acessada em
http://localhost:8080/swagger-ui.html#/.

#### Detalhes da Implementação

Para facilitar o processamento das instruções para uma sonda, as
direções foram mapeadas para inteiros entre 0 e 3 e as rotações para
os inteiros -1 e +1. Além disso, foi mapeado em duas listas "dx" e
"dy" o impacto que cada movimento em uma dada direção cardinal tem nas
coordenadas x e y. Assim, foi possível implementar de forma simples as
operações de movimento, evitando uma série de condicionais.

#### Testes Unitários

Foram desenvolvidos alguns testes unitários na classe
SondasApplicationTests dentro da pasta src-java que podem ser
executados executando a classe.