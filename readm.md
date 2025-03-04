
# Agendamento de Notificação

Este projeto tem como objetivo demonstrar as habilidades em desenvolvimento backend com a linguagem Java. Foi pensando em um desafio de cadastro de notificação. 




## Stack utilizada



**Back-end:** Java, Spring, Postgres, Docker. 


## Rodando localmente

Clone o projeto

```bash
  git clone git@github.com:danilomassoni/agendamento_notificacao_api_desafio.git
```

Entre no diretório do projeto

```bash
  docker-compose up --build
```




## Documentação da API

#### Cadastro de notificações

```http
  POST /agendamento
```

| BODY   | TIPO       | DESCRIÇÃO                           |
| :---------- | :--------- | :---------------------------------- |
| `emailDestinatario` | `string` | **Obrigatório**. Email do destinatário |
| `telefoneDestinatario` | `string` | **Obrigatório**. Telefone do destinatário |
| `mensaggem` | `string` | **Obrigatório**. Mensagem que será enviada |
| `dataHoraEvento` | `LocalDateTime` | **Obrigatório**. Data hora do evento  dd-MM-yyyy HH:mm:ss |

#### Retorna uma notificação

```http
  GET /agendamento/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### Cancela a notificação conforme o ID

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer cancelar |




## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  mvn test
```

