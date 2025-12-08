# Sistema de Gestão de Cinema

## 1. Descrição do Projeto
Este projeto consiste no desenvolvimento de um **Sistema de Gestão de Cinema**, criado como trabalho prático da disciplina de Linguagem de Programação 3. O objetivo principal é gerenciar o fluxo de um cinema, incluindo o cadastro de filmes, criação de sessões, gerenciamento de salas e venda de ingressos para clientes, com suporte a cartões fidelidade.

A aplicação foi construída sobre a linguagem Java, utilizando a arquitetura **MVC (Model-View-Controller)** para separação de responsabilidades. O sistema faz uso intensivo de **Padrões de Projeto** para garantir um código limpo e organizado, além de implementar persistência de dados relacional através de **ORM com JPA (EclipseLink)** conectado a um banco de dados **MySQL**.

## 2. Arquitetura e Tecnologias Utilizadas
O projeto foi estruturado seguindo as boas práticas de desenvolvimento corporativo.

* **Arquitetura MVC:**
    * **Model:** Contém as regras de negócio e mapeamento das entidades (pacote `model`).
    * **View:** (Em desenvolvimento) Responsável pela interação com o usuário. Atualmente, a classe `Main` simula as requisições da view.
    * **Controller:** Intermedia a comunicação entre a View e o Model, recebendo DTOs e acionando os DAOs (pacote `controller`).

* **Tecnologias:**
    * **Java (JDK 17+):** Linguagem base do sistema.
    * **Maven:** Gerenciamento de dependências e build do projeto.
    * **JPA / EclipseLink:** Framework ORM para persistência dos dados.
    * **MySQL:** Banco de dados relacional.
    * **NetBeans:** IDE utilizada para o desenvolvimento.
    * **Git/GitHub:** Ferramentas de versionamento e repositório remoto.

## 3. Padrões de Projeto Aplicados
Diversos padrões ("Design Patterns") foram aplicados para resolver problemas comuns de forma elegante:

* **Singleton:** Utilizado na classe `EntityManagerFactorySingleton` para garantir que exista apenas uma instância da `EntityManagerFactory` em toda a aplicação, otimizando recursos.
* **Object Factory:** Implementado na classe `EntityManagerObjectFactory` para encapsular a lógica de criação e fornecimento dos objetos `EntityManager`.
* **DAO (Data Access Object) Genérico:** A interface `GenericDAO<T>` padroniza as operações de CRUD (add, update, remove, getById, getAll) para todas as entidades, reduzindo a repetição de código.
* **DTO (Data Transfer Object):** Utilizados para transportar dados entre a View e o Controller (ex: `FilmeRequestDTO`, `ClienteResponseDTO`), evitando expor as entidades JPA diretamente na interface.
* **Adapter / Mapper:** Classes como `FilmeMap` e `ClienteMap` funcionam como adaptadores que convertem os DTOs em Entidades e vice-versa, isolando as camadas.

## 4. Modelagem e Relacionamentos JPA
O domínio do sistema conta com as seguintes entidades implementadas: **Filme, Sala, Sessao, Cliente, Ingresso e CartaoFidelidade**.

Abaixo, exemplos de relacionamentos mapeados no sistema:

### Exemplo 1: Cliente e Cartão Fidelidade (@OneToOne)
Um cliente pode possuir apenas um cartão fidelidade, e o ciclo de vida do cartão depende do cliente.
* Utilizou-se a anotação `@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)` na classe `Cliente` para garantir que, ao salvar o cliente, o cartão também seja persistido.

### Exemplo 2: Filme e Sessão (@OneToMany / @ManyToOne)
Um filme pode ter várias sessões, mas uma sessão pertence a um único filme.
* Na classe `Filme`, usamos `@OneToMany(mappedBy = "filme")`.
* Na classe `Sessao`, usamos `@ManyToOne` com `@JoinColumn(name = "filme_id")` para criar a chave estrangeira no banco.

## 5. Versionamento e Organização
O projeto está hospedado no GitHub e organizado de forma incremental. O uso do Git permitiu manter um histórico seguro das alterações.
* **Commits:** Foram realizados commits descritivos a cada funcionalidade implementada (ex: criação de entidades, implementação de DAOs, ajustes nos Controllers).
* **Estrutura:** O repositório segue a estrutura padrão do Maven (`src/main/java`), com pacotes bem definidos (`dao`, `dto`, `controller`, `model`, `util`).

## 6. Interface Gráfica
Atualmente, o projeto encontra-se com o "backend" estruturado e funcional. A camada de persistência e as regras de negócio foram validadas através da classe principal (`Tplp332111.java`), que atua como um "cliente" dos Controllers.
O código está pronto e modularizado para ser acoplado a uma interface gráfica **Java Swing** (classes `MainFrame` e `SessaoView`) na próxima etapa do desenvolvimento.

## 7. Aprendizados e Desafios
> *Seção reservada para reflexão do aluno.*

* **Aprendizados:** O projeto permitiu consolidar o entendimento sobre como o JPA facilita a manipulação de bancos de dados, eliminando a necessidade de escrever SQL puro para operações básicas. A aplicação prática dos DTOs mostrou a importância de separar os dados internos (banco) dos dados externos (tela).
* **Desafios:** Um dos principais desafios foi configurar corretamente o relacionamento em cascata (`CascadeType`) entre as entidades, como no caso de salvar uma `Sessao` que referencia uma `Sala` nova, ou salvar um `Cliente` junto com seus `Ingressos`. Isso foi resolvido ajustando as anotações nas entidades e garantindo a correta inicialização das listas nos construtores ou atributos.

---
*Projeto desenvolvido para a disciplina de LP3 - 2025.2*
