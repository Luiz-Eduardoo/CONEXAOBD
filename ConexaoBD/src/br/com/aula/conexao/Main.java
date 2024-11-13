package br.com.aula.conexao;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // método que cria a conexão com o wamp
        Scanner scanner = new Scanner(System.in); // cria um Scanner para perguntar diretamente ao usuario
        int escolherOpcao;
       
        do {
            System.out.println("");
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Deletar Aluno");
            System.out.println("4. Ler registro de Alunos");
            System.out.println("0. Sair");

            escolherOpcao = scanner.nextInt();
            scanner.nextLine();

            switch (escolherOpcao) {
                case 1:
                    InserirDados.main(null); // usa o metodo de InserirDados
                    break;
                case 2:
                    AtualizarDados.main(null); // usa o metodo de AtualizarDados
                    break;
                case 3:
                    DeletarDados.main(null); // usa o metodo de DeletarDados
                    break;
                case 4:
                    LerDados.main(null); // usa o metodo de LerDados
                    break;
                case 0: // fecha o sistema
                    System.out.println("Saindo do sistema..."); 
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // caso o usuario escolha uma opção invalida
            }
        } while (escolherOpcao != 0); // entra em um loop infinito até o usuario decidir encerrar
    }
}
