package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorGravarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProfessorGravarMapper extends EntityMapper<ProfessorGravarDTO, Professor> {

    @Override
   /* @Mapping(target = "idProfessor", source = "professor.id")*/
    ProfessorGravarDTO toDto(Professor professor);

    @Override
  /*  @Mapping(target = "professor.id", source = "idProfessor")*/
    Professor toEntity(ProfessorGravarDTO professorGravarDTO);

}
