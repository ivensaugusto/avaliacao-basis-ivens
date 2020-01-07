package br.com.basis.prova.repositorio;

import br.com.basis.prova.dominio.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepositorio extends JpaRepository<Professor, Integer>, JpaSpecificationExecutor<Professor> {

    @Modifying
    @Query(value = "DELETE FROM PROFESSOR " +
            "WHERE PROFESSOR.ID NOT IN ( " +
            "SELECT ID_PROFESSOR FROM DISCIPLINA)" +
            "AND PROFESSOR.MATRICULA = :matricula"
            , nativeQuery = true)
    void deleteByMatricula(@Param("matricula") String matricula);

    Professor findByMatricula(String matricula);

    Professor findByNome(String nome);
}
