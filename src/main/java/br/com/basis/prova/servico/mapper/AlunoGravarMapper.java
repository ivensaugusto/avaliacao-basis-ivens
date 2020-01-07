package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoGravarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DisciplinaMapper.class})
public interface AlunoGravarMapper extends EntityMapper<AlunoGravarDTO, Aluno> {
   /* @Mapping(source = "dataNascimento", target = "dataNascimento")*/
   AlunoGravarDTO toDto(Aluno aluno);

    Aluno toEntity(AlunoGravarDTO alunoGravarDTO);
}