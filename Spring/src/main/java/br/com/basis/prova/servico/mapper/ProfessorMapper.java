package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DisciplinaMapper.class})
public interface ProfessorMapper extends EntityMapper<ProfessorDTO, Professor> {
    @Override
    ProfessorDTO toDto(Professor professor);

    @Override
    Professor toEntity(ProfessorDTO professorDTO);
}
