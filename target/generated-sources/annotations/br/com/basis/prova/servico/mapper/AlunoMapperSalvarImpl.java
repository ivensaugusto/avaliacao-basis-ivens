package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoDTOSalvar;
import br.com.basis.prova.dominio.dto.DisciplinaDTOSalvar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T22:39:36-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class AlunoMapperSalvarImpl implements AlunoMapperSalvar {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Override
    public List<Aluno> toEntity(List<AlunoDTOSalvar> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Aluno> list = new ArrayList<Aluno>( dtoList.size() );
        for ( AlunoDTOSalvar alunoDTOSalvar : dtoList ) {
            list.add( toEntity( alunoDTOSalvar ) );
        }

        return list;
    }

    @Override
    public List<AlunoDTOSalvar> toDto(List<Aluno> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AlunoDTOSalvar> list = new ArrayList<AlunoDTOSalvar>( entityList.size() );
        for ( Aluno aluno : entityList ) {
            list.add( toDto( aluno ) );
        }

        return list;
    }

    @Override
    public AlunoDTOSalvar toDto(Aluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        AlunoDTOSalvar alunoDTOSalvar = new AlunoDTOSalvar();

        alunoDTOSalvar.setId( aluno.getId() );
        alunoDTOSalvar.setNome( aluno.getNome() );
        alunoDTOSalvar.setCpf( aluno.getCpf() );
        alunoDTOSalvar.setMatricula( aluno.getMatricula() );
        alunoDTOSalvar.setDataNascimento( aluno.getDataNascimento() );
        alunoDTOSalvar.setDisciplinas( disciplinaListToDisciplinaDTOSalvarList( aluno.getDisciplinas() ) );

        return alunoDTOSalvar;
    }

    @Override
    public Aluno toEntity(AlunoDTOSalvar alunoDTOSalvar) {
        if ( alunoDTOSalvar == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( alunoDTOSalvar.getId() );
        aluno.setMatricula( alunoDTOSalvar.getMatricula() );
        aluno.setCpf( alunoDTOSalvar.getCpf() );
        aluno.setNome( alunoDTOSalvar.getNome() );
        aluno.setDataNascimento( alunoDTOSalvar.getDataNascimento() );
        aluno.setDisciplinas( disciplinaDTOSalvarListToDisciplinaList( alunoDTOSalvar.getDisciplinas() ) );

        return aluno;
    }

    protected DisciplinaDTOSalvar disciplinaToDisciplinaDTOSalvar(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaDTOSalvar disciplinaDTOSalvar = new DisciplinaDTOSalvar();

        disciplinaDTOSalvar.setId( disciplina.getId() );
        disciplinaDTOSalvar.setNome( disciplina.getNome() );
        disciplinaDTOSalvar.setDescricao( disciplina.getDescricao() );
        disciplinaDTOSalvar.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaDTOSalvar.setAtiva( disciplina.getAtiva() );

        return disciplinaDTOSalvar;
    }

    protected List<DisciplinaDTOSalvar> disciplinaListToDisciplinaDTOSalvarList(List<Disciplina> list) {
        if ( list == null ) {
            return null;
        }

        List<DisciplinaDTOSalvar> list1 = new ArrayList<DisciplinaDTOSalvar>( list.size() );
        for ( Disciplina disciplina : list ) {
            list1.add( disciplinaToDisciplinaDTOSalvar( disciplina ) );
        }

        return list1;
    }

    protected List<Disciplina> disciplinaDTOSalvarListToDisciplinaList(List<DisciplinaDTOSalvar> list) {
        if ( list == null ) {
            return null;
        }

        List<Disciplina> list1 = new ArrayList<Disciplina>( list.size() );
        for ( DisciplinaDTOSalvar disciplinaDTOSalvar : list ) {
            list1.add( disciplinaMapper.toEntity( disciplinaDTOSalvar ) );
        }

        return list1;
    }
}
