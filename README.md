# 📚 Sistema de Biblioteca Digital Simples

Este é um projeto em Java que simula um sistema básico de empréstimos de livros de uma biblioteca digital. Ele foi desenvolvido como exercício para a aplicação de **lógica de programação estruturada**, sem uso de orientação a objetos, com uso de estruturas como `List`, `Map` e menus interativos.

## 🛠️ Tecnologias e Conceitos Utilizados

- Linguagem Java
- Programação Estruturada
- Listas (`ArrayList`)
- Estrutura de menus
- Validação de dados
- Fluxos lógicos (condicionais, laços, controle)

---

## 🎯 Funcionalidades

### 1. Cadastro de Usuários
- Cada usuário é identificado por um CPF único.
- Armazena nome e CPF.

### 2. Cadastro de Livros
- Cada livro possui: título, autor e um código único (ex: `L001`).

### 3. Empréstimo de Livros
- Um usuário pode pegar até **3 livros** emprestados.
- Um livro só pode estar emprestado para um único usuário.

### 4. Devolução de Livros
- Usuário devolve um ou mais livros emprestados.

### 5. Visualizar Livros Disponíveis
- Lista todos os livros que ainda **não foram emprestados**.

### 6. Sair do Sistema
- Encerra a execução do programa.

---

## 🧠 Regras de Negócio

- Um CPF não pode ser cadastrado duas vezes.
- Cada livro tem um código único.
- Um usuário só pode ter no máximo **3 livros emprestados**.
- Um livro não pode ser emprestado se já estiver com outro usuário.

---

## 🧪 Como Usar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/sistema-biblioteca.git
