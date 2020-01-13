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

    @Modifying
    @Query(value = "DELETE FROM DISCIPLINA " +
            "WHERE DISCIPLINA.ID NOT IN ( " +
            "SELECT ID_DISCIPLINA FROM ALUNO_DISCIPLINA)" +
            "AND DISCIPLINA.NOME = :nome"
            , nativeQuery = true)
    void deleteByNome(@Param("nome") String nome);

    Disciplina findByNome(String nome);

    List<Disciplina> findByProfessor(Professor professor);

    List<Disciplina> findAllByAtivaAndAlunos(Integer ativa, Aluno aluno);

}
