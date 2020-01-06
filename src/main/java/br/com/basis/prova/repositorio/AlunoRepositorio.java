package br.com.basis.prova.repositorio;

import br.com.basis.prova.dominio.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Integer>, JpaSpecificationExecutor<Aluno> {
    @Modifying
    @Query(value = "DELETE FROM ALUNO " +
            "WHERE ALUNO.ID NOT IN ( " +
            "SELECT ID_ALUNO FROM ALUNO_DISCIPLINA)" +
            "AND ALUNO.MATRICULA = :matricula"
            , nativeQuery = true)
    void deleteByMatricula(@Param("matricula") String matricula);

}
