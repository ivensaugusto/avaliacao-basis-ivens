package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTOSalvar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AlunoMapperSalvar extends EntityMapper<AlunoDTOSalvar, Aluno> {
 //   Aluno toDto(AlunoDTOSalvar alunoSalvar);
}