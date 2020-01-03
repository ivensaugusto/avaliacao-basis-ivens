package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTOSalvar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-03T11:46:06-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class AlunoMapperSalvarImpl implements AlunoMapperSalvar {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Override
    public Aluno toEntity(AlunoDTOSalvar arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( arg0.getId() );
        aluno.setMatricula( arg0.getMatricula() );
        aluno.setCpf( arg0.getCpf() );
        aluno.setNome( arg0.getNome() );
        aluno.setDataNascimento( arg0.getDataNascimento() );
        aluno.setDisciplinas( disciplinaMapper.toEntity( arg0.getDisciplinas() ) );

        return aluno;
    }

    @Override
    public AlunoDTOSalvar toDto(Aluno arg0) {
        if ( arg0 == null ) {
            return null;
        }

        AlunoDTOSalvar alunoDTOSalvar = new AlunoDTOSalvar();

        alunoDTOSalvar.setId( arg0.getId() );
        alunoDTOSalvar.setNome( arg0.getNome() );
        alunoDTOSalvar.setCpf( arg0.getCpf() );
        alunoDTOSalvar.setMatricula( arg0.getMatricula() );
        alunoDTOSalvar.setDataNascimento( arg0.getDataNascimento() );
        alunoDTOSalvar.setDisciplinas( disciplinaMapper.toDto( arg0.getDisciplinas() ) );

        return alunoDTOSalvar;
    }

    @Override
    public List<Aluno> toEntity(List<AlunoDTOSalvar> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Aluno> list = new ArrayList<Aluno>( arg0.size() );
        for ( AlunoDTOSalvar alunoDTOSalvar : arg0 ) {
            list.add( toEntity( alunoDTOSalvar ) );
        }

        return list;
    }

    @Override
    public List<AlunoDTOSalvar> toDto(List<Aluno> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<AlunoDTOSalvar> list = new ArrayList<AlunoDTOSalvar>( arg0.size() );
        for ( Aluno aluno : arg0 ) {
            list.add( toDto( aluno ) );
        }

        return list;
    }
}
