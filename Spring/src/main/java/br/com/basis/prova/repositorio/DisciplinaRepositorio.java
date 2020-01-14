package br.com.basis.prova.repositorio;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepositorio extends JpaRepository<Disciplina, Integer>, JpaSpecificationExecutor<Disciplina> {

    Disciplina findByNome(String nome);

    List<Disciplina> findByProfessor(Professor professor);

    List<Disciplina> findAllByAtivaAndAlunos(Integer ativa, Aluno aluno);

    List<Disciplina> findAllByAtivaAndProfessor(Integer ativa, Professor professor);

}
