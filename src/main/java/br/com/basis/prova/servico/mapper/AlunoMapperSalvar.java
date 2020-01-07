package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTOSalvar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DisciplinaMapper.class})
public interface AlunoMapperSalvar extends EntityMapper<AlunoDTOSalvar, Aluno> {
   /* @Mapping(source = "dataNascimento", target = "dataNascimento")*/
   AlunoDTOSalvar toDto(Aluno aluno);

    Aluno toEntity(AlunoDTOSalvar alunoDTOSalvar);
}