package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar(); // método que cria a conexão com o wamp
		Scanner scanner = new Scanner(System.in); // cria um Scanner para perguntar diretamente ao usuario
		
		if (conexao != null) {
			String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)"; // método para inserir os dados
			try {
			
				System.out.print("Digite o nome do aluno: ");
                String nome = scanner.nextLine();

                System.out.print("Digite a idade do aluno: ");
                int idade = scanner.nextInt();
                
				PreparedStatement stmt = conexao.prepareStatement(sql); // faz a consulta da conexão ao sql
				stmt.setString(1, nome); // Define o novo nome na consulta SQL
				stmt.setInt(2, idade); // Define a nova idade na consulta SQL
				stmt.executeUpdate(); // atualiza o banco de dados
				
				System.out.println("Dados inseridos com sucesso.");
			} catch (SQLException e) {
				System.err.println("Erro ao inserir dados: " + e.getMessage()); // mensagem caso de erro no processo de inserir os dados
			} finally {
				try {
					if (conexao != null) conexao.close(); // Fecha a conexão
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexão: " + e.getMessage()); // caso de erro, mostra o aviso
				}
			}
		}
	}
}
