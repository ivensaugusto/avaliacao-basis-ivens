package br.com.basis.prova.repositorio;

import br.com.basis.prova.dominio.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Integer>, JpaSpecificationExecutor<Aluno> {
}
