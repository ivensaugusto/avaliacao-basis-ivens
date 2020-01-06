package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDTOSalvar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProfessorMapperSalvar extends EntityMapper<ProfessorDTOSalvar, Professor> {

    @Override
   /* @Mapping(target = "idProfessor", source = "professor.id")*/
    ProfessorDTOSalvar toDto(Professor professor);

    @Override
  /*  @Mapping(target = "professor.id", source = "idProfessor")*/
    Professor toEntity(ProfessorDTOSalvar professorDTOSalvar);

}
