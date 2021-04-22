package br.edu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlunoDAO {

	// Consulta
	public List<Aluno> list() {

		List<Aluno> alunos = new ArrayList<>();

		try (Connection comm = ConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM aluno";

			PreparedStatement stmt = comm.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Aluno aluno = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"),
						rs.getString("estado"));

				alunos.add(aluno);

			}

		} catch (SQLException e) {
			System.out.println("Listagem de alunos Falho!");
			e.printStackTrace();

		}

		return alunos;
	}

	// Consulta com filtro

	public Aluno getById(int id) {

		Aluno aluno = new Aluno();

		try (Connection comm = ConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM aluno WHERE id = ?";

			PreparedStatement stmt = comm.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setIdade(rs.getInt("idade"));
				aluno.setEstado(rs.getString("estado"));

			}

		} catch (SQLException e) {
			System.out.println("Listagem de alunos Falhou");
			e.printStackTrace();
		}

		return aluno;

	}

	// Inserção

	public void create(Aluno aluno) {

		try (Connection comm = ConnectionFactory.getConnection()) {

			String sql = "INSERT INTO aluno(nome, idade, estado) VALUES (?,?,?)";

			PreparedStatement stmt = comm.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setString(3, aluno.getEstado());

			int rowsAffeted = stmt.executeUpdate();

			System.out.println("INSERÇÃO BEM SUCEDIDA! Foi adicionado " + rowsAffeted + "linha");

		} catch (SQLException e) {
			System.out.println("INSERÇÃO FALHOU!");
			e.printStackTrace();
		}
	}

	// Delete

	public void delete(int id) {

		try (Connection comm = ConnectionFactory.getConnection()) {

			String sql = "DELETE FROM aluno WHERE id = ?";

			PreparedStatement stmt = comm.prepareStatement(sql);
			stmt.setInt(1, id);

			int rowsAffeted = stmt.executeUpdate();

			System.out.println("DELETE BEM SUCEDIDO! Foi Deletado" + rowsAffeted + "linha");

		} catch (SQLException e) {
			System.out.println("O DELETE FALHOU");
			e.printStackTrace();
		}

	}

	// Atualiza

	public void update(Aluno aluno) {

		try (Connection comm = ConnectionFactory.getConnection()) {

			String sql = "UPDATE aluno SET nome=?, idade= ?, estado=? WHERE id = ?";

			PreparedStatement stmt = comm.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setString(3, aluno.getEstado());
			stmt.setInt(4, aluno.getId());

			int rowsAffected = stmt.executeUpdate();

			System.out.println("ATUALIZAÇÃO BEM SUCEDIDA! Foi atualizado " + rowsAffected + "linha");
		} catch (SQLException e) {
			System.out.println("Atualização Falhou!");
			e.printStackTrace();
		}
	}
}
