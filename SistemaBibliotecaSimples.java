import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBibliotecaSimples {

    static Scanner SC = new Scanner(System.in);
    static ArrayList<String> CPFS = new ArrayList<>();
    static ArrayList<String> USERNAMES = new ArrayList<>();
    static ArrayList<String> CODIGOS = new ArrayList<>();
    static ArrayList<String> TITULOS = new ArrayList<>();
    static ArrayList<String> AUTORES = new ArrayList<>();
    static ArrayList<Boolean> LIVROEMPRESTADO = new ArrayList<>();
    static ArrayList<String> EMPRESTIMO = new ArrayList<>();
    static ArrayList<Integer> CONTAGEMLIVROS = new ArrayList<>();
    static ArrayList<int[]> IDLIVROSEMPRESTADOS = new ArrayList<>();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        // Mostrar Menu
        while (true) {
            System.out.println(
                    "1 - Cadastrar usuário\n2 - Cadastrar livro\n3 - Realizar empréstimo\n4 - Devolver todos os livros\n5 - Ver livros disponíveis\n6 - Sair\n>");
            int escolhaMenu = SC.nextInt();
            switch (escolhaMenu) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    cadastroLivro();
                    break;
                case 3:
                    emprestimoLivro();
                    break;
                case 4:
                    devolverLivros();
                    break;
                case 5:
                    System.out.println("Não Feito");
                    break;
                case 6:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    public static void cadastrarUsuario() {
        System.out.println("Cadastro Usuario!");
        System.out.println("Insira o seu CPF: ");
        String cpf = SC.next();
        for (String cpf1 : CPFS) {
            if (cpf1.equals(cpf)) {
                System.out.println("CPF Ja cadastrado tente novamente!");
                cadastrarUsuario();
            }
        }
        CPFS.add(cpf);
        System.out.println("Insira o seu nome: ");
        String nome = SC.next();
        USERNAMES.add(nome);
        String emprestimoInicial = "Não Possui Emprestimo!";
        System.out.println("Cadastro de usuario efetuado!");
        EMPRESTIMO.add(emprestimoInicial);
        int contagemLivrosUser = 0;
        CONTAGEMLIVROS.add(contagemLivrosUser);

    }

    public static void cadastroLivro() {
        System.out.println("Cadastro de livros!");
        System.out.println("Insira o codigo do livro\n>");
        String codigo = SC.next();
        for (String code : CODIGOS) {
            if (code.equals(codigo)) {
                System.out.println("Codigo de livro ja cadastrado tente novamente!");
                cadastroLivro();
            }

        }
        CODIGOS.add(codigo);
        System.out.println("Insira o nome do livro\n>");
        String nomeLivro = SC.next();
        TITULOS.add(nomeLivro);
        System.out.println("Insira o autor do livro\n>");
        String autor = SC.next();
        boolean statusInicial = false;
        AUTORES.add(autor);
        LIVROEMPRESTADO.add(statusInicial);
        System.out.println("Cadastro de livro efetuado!");
    }

    public static void emprestimoLivro() {
        System.out.println("Emprestimo de livros!");
        int index = 0;
        System.out.println("Insira o seu cpf\n>");
        String cpf = SC.next();
        for (String cpf1 : CPFS) {
            if (!cpf1.equals(cpf)) {
                System.out.println("CPF Invalido tente novamente!");
                emprestimoLivro();
            }
        }
        int indexConta = buscarIndex(cpf);
        for (String titulos : TITULOS) {
            System.out.println("CODIGO: " + CODIGOS.get(index) + " Nome: " + TITULOS.get(index) + " EMPRESTADO? "
                    + LIVROEMPRESTADO.get(index));
            index++;
        }
        System.out.println("Insrira o codigo que do livro que Você deseja\n>");
        String codigoLivro = SC.next();
        int indexLivro = -1;
        for (int i = 0; i < CODIGOS.size(); i++) {
            if (CODIGOS.get(i).equals(codigoLivro)) {
                indexLivro = i;
                break;
            }
        }

        if (indexLivro == -1) {
            System.out.println("Código inválido, tente novamente!");
            emprestimoLivro();
            return;
        }
        if (LIVROEMPRESTADO.get(indexLivro) != false) {
            System.out.println("Livro ja emprestado tente novamente! ");
            return;
        }
        if (CONTAGEMLIVROS.get(indexConta) == 3) {
            System.out.println("Você excedeu o limite de livros que pode emprestar!");
            System.out.println("Retornando ao Menu inicial...");
            mostrarMenu();
        } else {
            System.out.println("Livro Emprestado!");
            int contagem = CONTAGEMLIVROS.get(indexConta) + 1;
            CONTAGEMLIVROS.set(indexConta, contagem);
            String livrosUsuario = EMPRESTIMO.get(indexConta) + ", " + TITULOS.get(indexLivro);
            EMPRESTIMO.set(indexConta, livrosUsuario);
            LIVROEMPRESTADO.set(indexLivro, true);
            
        }
    }

    public static void devolverLivros() {
        System.out.println("Devolver Livros!");
        System.out.println("Insira o cpf da pessoa que você quer devolver\n>");
        String cpf = SC.next();
        
        if (CPFS.contains(cpf)) {
            int indexConta = buscarIndex(cpf);
            
            // Marca os livros como disponíveis novamente
            int[] livrosEmprestados = IDLIVROSEMPRESTADOS.get(indexConta);
            for (int indexLivro : livrosEmprestados) {
                LIVROEMPRESTADO.set(indexLivro, false);
            }
    
            // Limpa os dados de empréstimo do usuário
            CONTAGEMLIVROS.set(indexConta, 0);
            EMPRESTIMO.set(indexConta, "Não possui Emprestimo");
            IDLIVROSEMPRESTADOS.set(indexConta, new int[0]); // esvazia a lista de livros emprestados
    
            System.out.println("Livros devolvidos com sucesso!");
    
        } else {
            System.out.println("CPF Invalido. Tente novamente!");
            devolverLivros();
        }
    }

    public static int buscarIndex(String cpf) {
        int indexConta = 0;
        for (String name : CPFS) {
            if (name.equals(cpf)) {
                return indexConta;
            }
            indexConta++;
        }
        return indexConta;
    }
}
