package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-02T22:09:23-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class AlunoDetalhadoMapperImpl implements AlunoDetalhadoMapper {

    @Override
    public Aluno toEntity(AlunoDetalhadoDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( arg0.getId() );
        aluno.setMatricula( arg0.getMatricula() );
        aluno.setCpf( arg0.getCpf() );
        aluno.setNome( arg0.getNome() );
        aluno.setDataNascimento( arg0.getDataNascimento() );
        aluno.setDisciplinas( disciplinaDTOListToDisciplinaList( arg0.getDisciplinas() ) );

        return aluno;
    }

    @Override
    public AlunoDetalhadoDTO toDto(Aluno arg0) {
        if ( arg0 == null ) {
            return null;
        }

        AlunoDetalhadoDTO alunoDetalhadoDTO = new AlunoDetalhadoDTO();

        alunoDetalhadoDTO.setId( arg0.getId() );
        alunoDetalhadoDTO.setNome( arg0.getNome() );
        alunoDetalhadoDTO.setCpf( arg0.getCpf() );
        alunoDetalhadoDTO.setMatricula( arg0.getMatricula() );
        alunoDetalhadoDTO.setDataNascimento( arg0.getDataNascimento() );
        alunoDetalhadoDTO.setDisciplinas( disciplinaListToDisciplinaDTOList( arg0.getDisciplinas() ) );

        return alunoDetalhadoDTO;
    }

    @Override
    public List<Aluno> toEntity(List<AlunoDetalhadoDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Aluno> list = new ArrayList<Aluno>( arg0.size() );
        for ( AlunoDetalhadoDTO alunoDetalhadoDTO : arg0 ) {
            list.add( toEntity( alunoDetalhadoDTO ) );
        }

        return list;
    }

    @Override
    public List<AlunoDetalhadoDTO> toDto(List<Aluno> aluno) {
        if ( aluno == null ) {
            return null;
        }

        List<AlunoDetalhadoDTO> list = new ArrayList<AlunoDetalhadoDTO>( aluno.size() );
        for ( Aluno aluno1 : aluno ) {
            list.add( toDto( aluno1 ) );
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
