package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // método que cria a conexão com o wamp
        Scanner scanner = new Scanner(System.in); // cria um Scanner para perguntar diretamente ao usuario
        if (conexao != null) { // Verifica se a conexão foi realizada
            String sql = "DELETE FROM Alunos WHERE id = ?"; // método que deleta as informações de um aluno
            System.out.print("Digite o ID do aluno que deseja deletar: ");
            int id = scanner.nextInt(); // usuario insere o ID do aluno que quer deletar
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql); // faz a consulta da conexão ao sql
                stmt.setInt(1, id); // substitui o ? na linha que faz o processo de deletar um aluno
                int rowsDeleted = stmt.executeUpdate(); // consulta a atualização no código sql para executar
                if (rowsDeleted > 0) { // ve se o numero de id inserido é maior que 0
                    System.out.println("Registro deletado com sucesso!");
                } else {
                    System.out.println("Nenhum registro encontrado com o ID especificado."); // caso o usuario insira um id que não existe. avisa o usuario
                }
            } catch (SQLException e) {
                System.err.println("Erro ao deletar dados: " + e.getMessage()); // mensagem caso de erro no processo de deletar os dados
            } finally {
                try {
                    if (conexao != null) conexao.close();  // fecha a conexão
                } catch (SQLException c) {
                    System.err.println("Erro ao fechar conexão: " + c.getMessage()); // caso de erro, o sistema avisa ao usuario
                }
            }
        }
    }
}
