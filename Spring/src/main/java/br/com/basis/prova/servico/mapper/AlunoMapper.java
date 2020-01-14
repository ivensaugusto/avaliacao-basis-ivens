package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DisciplinaMapper.class})
public interface AlunoMapper extends EntityMapper<AlunoDTO, Aluno> {

    AlunoDTO toDto(Aluno aluno);
    Aluno toEntity(AlunoDTO alunoDTO);

}