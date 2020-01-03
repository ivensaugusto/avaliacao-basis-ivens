package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DisciplinaMapper.class})
public interface AlunoMapper extends EntityMapper<AlunoDTO, Aluno> {
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    AlunoDTO toDto(Aluno aluno);
}