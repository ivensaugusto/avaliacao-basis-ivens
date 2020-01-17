package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProfessorMapper.class})
public interface ProfessorDetalhadoMapper extends EntityMapper<ProfessorDetalhadoDTO, Professor> {
    @Override
    ProfessorDetalhadoDTO toDto(Professor professor);

    @Override
    Professor toEntity(ProfessorDetalhadoDTO professorDetalhadoDTO);
}