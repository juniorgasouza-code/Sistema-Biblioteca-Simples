import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBiblioteSImples {
    static Scanner SC = new Scanner(System.in);
    static ArrayList<String> usuarioCPF;
    static ArrayList<String> usuarioNome;
    static ArrayList<String> livrosCodigo;
    static ArrayList<String> livrosTitulo;
    static ArrayList<String> livrosAutor;
    static ArrayList<Boolean> livrosEmprestado;

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        // Mostrar Menu
        System.out.println(
                "1 - Cadastrar usuário\n2 - Cadastrar livro\n3 - Realizar empréstimo\n4 - Devolver livro\n5 - Ver livros disponíveis\n6 - Sair\n>");
        int escolhaMenu = SC.nextInt();
        switch (escolhaMenu) {
            case 1:
                // Cadastro de livros
                cadastroUsuario();
                break;
            case 2:

                break;

            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                System.exit(0);
            default:
                break;
        }
    }

    public static void cadastroUsuario() {
        System.out.println("Cadastro de  Usuario!");
        System.out.println("Insira o cpf\n>");
        String cpf = SC.next();
        if (!usuarioCPF.contains(cpf)) {
            usuarioNome.add(cpf);
            System.out.println("Insira o nome do Usuario\n>");
            String nome = SC.next();
            usuarioNome.add(nome);
        }else{
            System.out.println("CPF ja cadastrado!");
            cadastroUsuario();
        }
        
    }
}
