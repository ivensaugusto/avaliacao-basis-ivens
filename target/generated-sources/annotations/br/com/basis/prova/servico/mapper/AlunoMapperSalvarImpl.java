package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoDTOSalvar;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-03T13:34:57-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class AlunoMapperSalvarImpl implements AlunoMapperSalvar {

    @Override
    public Aluno toEntity(AlunoDTOSalvar dto) {
        if ( dto == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( dto.getId() );
        aluno.setMatricula( dto.getMatricula() );
        aluno.setCpf( dto.getCpf() );
        aluno.setNome( dto.getNome() );
        aluno.setDataNascimento( dto.getDataNascimento() );
        aluno.setDisciplinas( disciplinaDTOListToDisciplinaList( dto.getDisciplinas() ) );

        return aluno;
    }

    @Override
    public AlunoDTOSalvar toDto(Aluno entity) {
        if ( entity == null ) {
            return null;
        }

        AlunoDTOSalvar alunoDTOSalvar = new AlunoDTOSalvar();

        alunoDTOSalvar.setId( entity.getId() );
        alunoDTOSalvar.setNome( entity.getNome() );
        alunoDTOSalvar.setCpf( entity.getCpf() );
        alunoDTOSalvar.setMatricula( entity.getMatricula() );
        alunoDTOSalvar.setDataNascimento( entity.getDataNascimento() );
        alunoDTOSalvar.setDisciplinas( disciplinaListToDisciplinaDTOList( entity.getDisciplinas() ) );

        return alunoDTOSalvar;
    }

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

    protected Disciplina disciplinaDTOToDisciplina(DisciplinaDTO disciplinaDTO) {
        if ( disciplinaDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( disciplinaDTO.getId() );
        disciplina.setNome( disciplinaDTO.getNome() );
        disciplina.setDescricao( disciplinaDTO.getDescricao() );
        disciplina.setCargaHoraria( disciplinaDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaDTO.getAtiva() );

        return disciplina;
    }

    protected List<Disciplina> disciplinaDTOListToDisciplinaList(List<DisciplinaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Disciplina> list1 = new ArrayList<Disciplina>( list.size() );
        for ( DisciplinaDTO disciplinaDTO : list ) {
            list1.add( disciplinaDTOToDisciplina( disciplinaDTO ) );
        }

        return list1;
    }

    protected DisciplinaDTO disciplinaToDisciplinaDTO(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();

        disciplinaDTO.setId( disciplina.getId() );
        disciplinaDTO.setNome( disciplina.getNome() );
        disciplinaDTO.setDescricao( disciplina.getDescricao() );
        disciplinaDTO.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaDTO.setAtiva( disciplina.getAtiva() );

        return disciplinaDTO;
    }

    protected List<DisciplinaDTO> disciplinaListToDisciplinaDTOList(List<Disciplina> list) {
        if ( list == null ) {
            return null;
        }

        List<DisciplinaDTO> list1 = new ArrayList<DisciplinaDTO>( list.size() );
        for ( Disciplina disciplina : list ) {
            list1.add( disciplinaToDisciplinaDTO( disciplina ) );
        }

        return list1;
    }
}
