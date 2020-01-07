package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProfessorDetalhadoMapper extends EntityMapper<ProfessorDetalhadoDTO, Professor> {

    @Override
    ProfessorDetalhadoDTO toDto(Professor professor);

    @Override
    Professor toEntity(ProfessorDetalhadoDTO professorDetalhadoDTO);
}