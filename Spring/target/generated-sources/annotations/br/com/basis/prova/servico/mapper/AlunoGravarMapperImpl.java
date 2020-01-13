package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoGravarDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-13T14:39:27-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class AlunoGravarMapperImpl implements AlunoGravarMapper {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Override
    public List<Aluno> toEntity(List<AlunoGravarDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Aluno> list = new ArrayList<Aluno>( dtoList.size() );
        for ( AlunoGravarDTO alunoGravarDTO : dtoList ) {
            list.add( toEntity( alunoGravarDTO ) );
        }

        return list;
    }

    @Override
    public List<AlunoGravarDTO> toDto(List<Aluno> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AlunoGravarDTO> list = new ArrayList<AlunoGravarDTO>( entityList.size() );
        for ( Aluno aluno : entityList ) {
            list.add( toDto( aluno ) );
        }

        return list;
    }

    @Override
    public AlunoGravarDTO toDto(Aluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        AlunoGravarDTO alunoGravarDTO = new AlunoGravarDTO();

        alunoGravarDTO.setId( aluno.getId() );
        alunoGravarDTO.setNome( aluno.getNome() );
        alunoGravarDTO.setCpf( aluno.getCpf() );
        alunoGravarDTO.setMatricula( aluno.getMatricula() );
        alunoGravarDTO.setDataNascimento( aluno.getDataNascimento() );
        alunoGravarDTO.setDisciplinas( disciplinaMapper.toDto( aluno.getDisciplinas() ) );

        return alunoGravarDTO;
    }

    @Override
    public Aluno toEntity(AlunoGravarDTO alunoGravarDTO) {
        if ( alunoGravarDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( alunoGravarDTO.getId() );
        aluno.setMatricula( alunoGravarDTO.getMatricula() );
        aluno.setCpf( alunoGravarDTO.getCpf() );
        aluno.setNome( alunoGravarDTO.getNome() );
        aluno.setDataNascimento( alunoGravarDTO.getDataNascimento() );
        aluno.setDisciplinas( disciplinaMapper.toEntity( alunoGravarDTO.getDisciplinas() ) );

        return aluno;
    }
}
