package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaSemAlunoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProfessorMapper.class})
public interface DisciplinaSemAlunoMapper extends EntityMapper<DisciplinaSemAlunoDTO, Disciplina> {

    @Override
    DisciplinaSemAlunoDTO toDto(Disciplina disciplina);

    @Override
    Disciplina toEntity(DisciplinaSemAlunoDTO disciplinaDetalhadaDTO);

}

