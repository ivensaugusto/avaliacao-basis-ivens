package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTOSalvar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DisciplinaMapperSalvar extends EntityMapper<DisciplinaDTOSalvar, Disciplina> {
//    Disciplina toDto(DisciplinaDTOSalvar disciplinaSalvar);
}
