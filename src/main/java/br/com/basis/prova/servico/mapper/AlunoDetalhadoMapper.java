package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface AlunoDetalhadoMapper extends EntityMapper<AlunoDetalhadoDTO, Aluno> {
    List<AlunoDetalhadoDTO> toDto(List<Aluno> aluno);
}

