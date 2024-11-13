package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // método que cria a conexão com o wamp
        Scanner scanner = new Scanner(System.in); // cria um Scanner para perguntar diretamente ao usuario
        if (conexao != null) { // Verifica se a conexão foi realizada
            String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?"; // método que atualiza as informações de um aluno
            try {
                
                System.out.print("Digite o ID do aluno que deseja atualizar: ");
                int id = scanner.nextInt(); // recebe o novo id do novo aluno e substitui o ? na linha sql
                scanner.nextLine();
                
                
                System.out.print("Digite o novo nome do aluno: ");
                String nome = scanner.nextLine(); // recebe o novo nome do aluno e substitui o ? na linha sql
                
                System.out.print("Digite a nova idade do aluno: ");
                int idade = scanner.nextInt(); // recebe a nova idade do aluno e substitui o ? na linha sql
                
                PreparedStatement stmt = conexao.prepareStatement(sql); // faz a consulta da conexão ao sql
                stmt.setString(1, nome); // Define o novo nome na consulta SQL
                stmt.setInt(2, idade); // Define a nova idade na consulta SQL
                stmt.setInt(3, id); // Define o ID na consulta SQL
                
                int rowsUpdated = stmt.executeUpdate(); // atualiza o banco de dados
                
                if (rowsUpdated > 0) {
                    System.out.println("Registro atualizado com sucesso!");
                } else {
                    System.out.println("Nenhum registro encontrado com o ID especificado."); // caso o usuario insira um id que não existe. avisa o usuario
                }
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar dados: " + e.getMessage()); // mensagem caso de erro no processo de atualizar os dados
            } finally {
                try {
                    if (conexao != null) conexao.close(); // Fecha a conexão
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage()); // caso de erro, o sistema avisa ao usuario
                }
                
            }
        }
    }
}
