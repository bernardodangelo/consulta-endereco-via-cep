#language: pt
Funcionalidade: Consulta de endereço por CEP

Cenário: Consulta bem sucedidade de CEP
  Dado que o usuário inseriu um cep válido "01001000"
  Quando o serviço é consultado utilizando o cep
  Então são retornados o cep, rua, complemento, bairro, cidade, estado e o frete
  
  Cenário: Consulta inválida de CEP
    Dado que o usuário inseriu um cep inválido "12345-678"
    Quando o serviço é consultado utilizando o cep
    Então a resposta deve ser um erro