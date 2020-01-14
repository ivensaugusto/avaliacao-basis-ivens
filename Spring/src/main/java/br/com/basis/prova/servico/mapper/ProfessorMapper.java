package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProfessorMapper extends EntityMapper<ProfessorDTO, Professor> {
/*
    @Override
   *//* @Mapping(target = "idProfessor", source = "professor.id")*//*
    ProfessorDTO toDto(Professor professor);

    @Override
  *//*  @Mapping(target = "professor.id", source = "idProfessor")*//*
    Professor toEntity(ProfessorDTO professorDTO);*/
}
