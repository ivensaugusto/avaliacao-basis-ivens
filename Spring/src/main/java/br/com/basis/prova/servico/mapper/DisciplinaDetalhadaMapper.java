package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProfessorMapper.class})
public interface DisciplinaDetalhadaMapper extends EntityMapper<DisciplinaDetalhadaDTO, Disciplina> {

    @Override
    @Mapping(target = "nomeProfessor", source = "professor.nome")
    DisciplinaDetalhadaDTO toDto(Disciplina disciplina);

    @Override
    @Mapping(target = "professor.nome", source = "nomeProfessor")
    Disciplina toEntity(DisciplinaDetalhadaDTO disciplinaDetalhadaDTO);


}

