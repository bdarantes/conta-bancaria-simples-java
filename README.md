
# 💰 Sistema Bancário Simples em Java

Este é um projeto de terminal desenvolvido em **Java puro**, com o objetivo de simular um sistema bancário simples que permite criar clientes e contas, realizar depósitos, saques, transferências e consultar saldos. Toda a lógica foi construída utilizando **orientação a objetos**, boas práticas de organização de código e foco na clareza didática.

---

## 🧠 Objetivos do Projeto

Este projeto tem fins educacionais e foi pensado para aplicar conceitos importantes da linguagem Java, como:

- Classes, herança e polimorfismo
- Encapsulamento e abstração
- Uso de `BigDecimal` para operações monetárias
- Interação via terminal (`Scanner`)
- Organização em camadas (model, service, util)

---

## 📁 Estrutura de Diretórios

```
src/
├── models/
│   ├── Cliente.java          
│   ├── Conta.java           
│   ├── ContaCorrente.java    
│   └── ContaPoupanca.java   
├── services/
│   └── BancoService.java    
├── utils/
│   └── Menu.java             
└── App.java               
```

---

## ⚙️ Funcionalidades

- ✅ Criar cliente e associar conta
- 🏦 Criar contas do tipo **Corrente** ou **Poupança**
- 📥 Realizar **depósitos**
- 📤 Realizar **saques**
- 🔄 Fazer **transferência entre contas**
- 📊 Consultar **saldo**
- 🔐 Validação de operações com mensagens de erro apropriadas

---

## ▶️ Como Executar o Projeto

### ✔️ Requisitos

- Java JDK 17 ou superior
- Terminal(Linux ou MacOS) ou prompt de comando(Windows)

### 💻 Compilando e Executando

1. Clone o repositório:

```bash
git clone git@github.com:bdarantes/conta-bancaria-simples-java.git
```

2. Acesse o diretório do projeto:

```bash
cd src
```

3. Compile todos os arquivos `.java`:

```bash
javac */*.java *.java
```

4. Execute a classe principal:

```bash
java App
```

---

## 📌 Exemplo de Interação

```
===== BANCO SIMPLES EM JAVA =====

1 - Criar nova conta
2 - Depositar
3 - Sacar
4 - Transferir
5 - Consultar saldo
6 - Sair

Escolha uma opção: 
```

---

## 🧱 Detalhes Técnicos

- `Conta.java` é uma **classe abstrata** com os atributos e métodos comuns a todas as contas.
- `ContaCorrente` e `ContaPoupanca` **herdam** de `Conta` e podem conter regras específicas (ex: taxa de operação futura).
- `Cliente.java` representa os dados básicos do titular da conta.
- `BancoService.java` cuida de toda a **lógica de manipulação das contas**, armazenando-as em memória (usando `List` ou `Map`).
- `Menu.java` lida com a **interface de texto com o usuário**, utilizando `Scanner`.

---

## 🔒 Boas Práticas Adotadas

- Separação por responsabilidade (model, service, util)
- Encapsulamento de atributos
- Métodos coesos e bem nomeados
- Uso seguro de `BigDecimal` para valores financeiros
- Validação de entradas e mensagens de erro claras

---

## 🛠️ Melhorias Futuras

- 📁 Persistência de dados em arquivos (JSON, XML ou binário)
- 🗃️ Integração com banco de dados (JDBC)
- 🧪 Testes unitários com JUnit
- 🌐 API REST com Spring Boot

---

## 📄 Licença

Este projeto é livre para estudo e modificação, sem fins comerciais.
- 💻 Interface gráfica (Swing ou JavaFX)
---

Feito com ☕, prática e aprendizado 💻 por Braz Daniel
