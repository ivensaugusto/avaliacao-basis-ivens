package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ProfessorMapper extends EntityMapper<ProfessorDTO, Professor> {
    List<ProfessorDetalhadoDTO> toDetalhadoDto(List<Professor> professores);
}
