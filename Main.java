import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        int X;

        do {
            System.out.println("1- Cadastrar\n2- Editar\n3- Apresentar\n4- Excluir\n5- Sair");
            X = teclado.nextInt();
            teclado.nextLine();
            
            switch (X) {
                case 1:
                    cadastrarPessoa(teclado, pessoas);
                    break;
                case 2:
                    editarPessoa(teclado, pessoas);
                    break;
                case 3:
                    apresentarPessoa(pessoas);
                    break;
                case 4:
                    excluirPessoa(teclado, pessoas);
                    break;
                case 5:
                    System.out.println("\u001B[31m" + "Saindo do programa..." + "\u001B[0m");
                    break;
                default:
                    System.out.println("A opção inserida não existe.");
                    break;
            }
        } while (X != 5);
        
        teclado.close();
    }

    public static void cadastrarPessoa(Scanner teclado, ArrayList pessoas) {
        System.out.println("Digite o nome: ");
        String nome = teclado.nextLine();

        System.out.println("Digite a idade: ");
        int idade = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Digite o e-mail: ");
        String email = teclado.nextLine();

        pessoas.add(new Pessoa(idade, nome, email));

        System.out.println("\u001B[36m" + "Pessoa cadastrada com sucesso!" + "\u001B[0m");
    }

    public static void editarPessoa(Scanner teclado, ArrayList<Pessoa> pessoas) {
        System.out.println("Escolha qual usuário deseja editar: ");
        mostraPessoas(pessoas);
        int user = teclado.nextInt();
        teclado.nextLine();
        Pessoa escolhida = pessoas.get(user-1);
        System.out.println("Digite o novo nome: ");
        escolhida.setNome(teclado.nextLine());
        
        System.out.println("Digite a nova idade: ");
        escolhida.setIdade(teclado.nextInt());
        teclado.nextLine();

        System.out.println("Digite o novo e-mail: ");
        escolhida.setEmail(teclado.nextLine());

        System.out.println("\u001B[36m" + "Pessoa alterada com sucesso!" + "\u001B[0m");
    }

    public static void apresentarPessoa(ArrayList<Pessoa> pessoas) {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (int i = 0; i < pessoas.size(); i++) { 
                Pessoa pessoaAtual = pessoas.get(i);
                System.out.println("\u001B[35m" + (i+1) + " - Nome: " + pessoaAtual.getNome() + " | Idade: " + pessoaAtual.getIdade() + " | E-mail: " + pessoaAtual.getEmail()+ "\u001B[0m");
            }
            System.out.println("\u001B[36m" + "Essas são todas as pessoas cadastradas!" + "\u001B[0m");
        }
    }

    public static void excluirPessoa(Scanner teclado, ArrayList<Pessoa> pessoas) {
        System.out.println("Escolha qual usuário deseja editar: ");
        mostraPessoas(pessoas);
        int user = teclado.nextInt();
        teclado.nextLine();
        pessoas.remove(user-1);
        System.out.println("\u001B[36m" + "Pessoa excluída com sucesso!" + "\u001B[0m");
    }

    public static void mostraPessoas(ArrayList<Pessoa> pessoas) {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (int i = 0; i < pessoas.size(); i++) { 
                Pessoa pessoaAtual = pessoas.get(i);
                System.out.println("\u001B[33m" + (i+1) + " - " + pessoaAtual.getNome()+ "\u001B[0m");
            }
        }
    }
}