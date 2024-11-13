package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LerDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar(); // método que cria a conexão com o wamp
        if (conexao != null) { // Verifica se a conexão foi realizada
            String sql = "SELECT * FROM alunos"; // método que cria a tabela com todas as informações
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql); // faz a consulta da conexão ao sql
                ResultSet resultSet = stmt.executeQuery(); // realiza a consulta e armazena o resultado
                    
                System.out.println("Registros da tabela 'alunos':");
                while (resultSet.next()) { // mostra todas as informações
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    int idade = resultSet.getInt("idade");
                    
                    System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade); // mostra cada registro
                }
            } catch (SQLException e) {
                System.err.println("Erro ao ler dados: " + e.getMessage()); // mensagem caso de erro no processo de ler os dados
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
