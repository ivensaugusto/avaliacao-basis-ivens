package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaGravarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DisciplinaGravarMapper extends EntityMapper<DisciplinaGravarDTO, Disciplina> {
//    Disciplina toDto(DisciplinaGravarDTO disciplinaSalvar);
}
