package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {ProfessorMapper.class})
public interface DisciplinaMapper extends EntityMapper<DisciplinaDTO, Disciplina> {

    @Override
    DisciplinaDTO toDto(Disciplina disciplina);

    @Override
    Disciplina toEntity(DisciplinaDTO disciplinaDTO);

}
