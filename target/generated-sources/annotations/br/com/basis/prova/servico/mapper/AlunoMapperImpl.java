package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-03T13:34:57-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class AlunoMapperImpl implements AlunoMapper {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Override
    public Aluno toEntity(AlunoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( dto.getId() );
        aluno.setMatricula( dto.getMatricula() );
        aluno.setCpf( dto.getCpf() );
        aluno.setNome( dto.getNome() );
        aluno.setDataNascimento( dto.getDataNascimento() );
        aluno.setDisciplinas( disciplinaMapper.toEntity( dto.getDisciplinas() ) );

        return aluno;
    }

    @Override
    public List<Aluno> toEntity(List<AlunoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Aluno> list = new ArrayList<Aluno>( dtoList.size() );
        for ( AlunoDTO alunoDTO : dtoList ) {
            list.add( toEntity( alunoDTO ) );
        }

        return list;
    }

    @Override
    public List<AlunoDTO> toDto(List<Aluno> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AlunoDTO> list = new ArrayList<AlunoDTO>( entityList.size() );
        for ( Aluno aluno : entityList ) {
            list.add( toDto( aluno ) );
        }

        return list;
    }

    @Override
    public AlunoDTO toDto(Aluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setDataNascimento( aluno.getDataNascimento() );
        alunoDTO.setId( aluno.getId() );
        alunoDTO.setNome( aluno.getNome() );
        alunoDTO.setCpf( aluno.getCpf() );
        alunoDTO.setMatricula( aluno.getMatricula() );
        alunoDTO.setDisciplinas( disciplinaMapper.toDto( aluno.getDisciplinas() ) );

        return alunoDTO;
    }
}
