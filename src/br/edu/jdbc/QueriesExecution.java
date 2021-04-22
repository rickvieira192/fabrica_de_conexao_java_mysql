package br.edu.jdbc;

import java.util.List;

public class QueriesExecution {

	
	public static void main(String[]ars) {
		
		AlunoDAO alunoDAO = new AlunoDAO();
		
		
		       //+++++++++++++++++++++++++++ //Consulta++++++++++++++++++++++++++++++++
		List<Aluno> alunos = alunoDAO.list();
		
		alunos.stream().forEach(System.out::println);
		
				// ++++++++++++++++++   // Consulta com filtro // +++++++++++++++++++++++++++++++++
		
		
		//Aluno alunoParaConsulta = alunoDAO.getById(1);
		
		//System.out.println(alunoParaConsulta);
		
		//++++++++++++++++++++++++       // Inserção +++++++++++++++++++++++++++++++ //
		
	//Aluno alunoParaInsercao = new Aluno(
		//	 "Matheus", 
			//   + 43, 
			  //"SP"
	//);
	
	//alunoDAO.create(alunoParaInsercao);
		
		
	// ++++++++++++++++++++++++++++ 	//Delete +++++++++++++++++++++++++++++++++++++//
		
	//	alunoDAO.list().stream().forEach(System.out::println);
		
	//	alunoDAO.delete(4);
		
	//	alunoDAO.list().stream().forEach(System.out::println);
		
		
		
		
		// ++++++++++++++++++++//  Atualizar +++++++++++++++++++++++++++++++++++++++++++++//
		
	//	alunoDAO.list().stream().forEach(System.out::println);
		
	//	Aluno alunoParaAtualizar = alunoDAO.getById(3);
	//	alunoParaAtualizar.setNome("Joaquim");
	//	alunoParaAtualizar.setIdade(18);
	//	alunoParaAtualizar.setEstado("SP");
		
	//	alunoDAO.update(alunoParaAtualizar);
		
	//	alunoDAO.list().stream().forEach(System.out::println);
	}
	
}
