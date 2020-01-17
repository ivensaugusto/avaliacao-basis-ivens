package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoSemDisciplinasDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-17T15:30:38-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class AlunoMapperImpl implements AlunoMapper {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

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

        alunoDTO.setId( aluno.getId() );
        alunoDTO.setNome( aluno.getNome() );
        alunoDTO.setCpf( aluno.getCpf() );
        alunoDTO.setMatricula( aluno.getMatricula() );
        alunoDTO.setDataNascimento( aluno.getDataNascimento() );
        alunoDTO.setDisciplinas( disciplinaListToDisciplinaDetalhadaDTOList( aluno.getDisciplinas() ) );

        return alunoDTO;
    }

    @Override
    public Aluno toEntity(AlunoDTO alunoDTO) {
        if ( alunoDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( alunoDTO.getId() );
        aluno.setMatricula( alunoDTO.getMatricula() );
        aluno.setCpf( alunoDTO.getCpf() );
        aluno.setNome( alunoDTO.getNome() );
        aluno.setDataNascimento( alunoDTO.getDataNascimento() );
        aluno.setDisciplinas( disciplinaDetalhadaDTOListToDisciplinaList( alunoDTO.getDisciplinas() ) );

        return aluno;
    }

    @Override
    public AlunoDTO toDto(Optional<Aluno> byId) {
        if ( byId == null ) {
            return null;
        }

        AlunoDTO alunoDTO = new AlunoDTO();

        return alunoDTO;
    }

    protected AlunoSemDisciplinasDTO alunoToAlunoSemDisciplinasDTO(Aluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        AlunoSemDisciplinasDTO alunoSemDisciplinasDTO = new AlunoSemDisciplinasDTO();

        alunoSemDisciplinasDTO.setId( aluno.getId() );
        alunoSemDisciplinasDTO.setNome( aluno.getNome() );
        alunoSemDisciplinasDTO.setCpf( aluno.getCpf() );
        alunoSemDisciplinasDTO.setMatricula( aluno.getMatricula() );
        alunoSemDisciplinasDTO.setDataNascimento( aluno.getDataNascimento() );

        return alunoSemDisciplinasDTO;
    }

    protected List<AlunoSemDisciplinasDTO> alunoListToAlunoSemDisciplinasDTOList(List<Aluno> list) {
        if ( list == null ) {
            return null;
        }

        List<AlunoSemDisciplinasDTO> list1 = new ArrayList<AlunoSemDisciplinasDTO>( list.size() );
        for ( Aluno aluno : list ) {
            list1.add( alunoToAlunoSemDisciplinasDTO( aluno ) );
        }

        return list1;
    }

    protected DisciplinaDetalhadaDTO disciplinaToDisciplinaDetalhadaDTO(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaDetalhadaDTO disciplinaDetalhadaDTO = new DisciplinaDetalhadaDTO();

        disciplinaDetalhadaDTO.setId( disciplina.getId() );
        disciplinaDetalhadaDTO.setNome( disciplina.getNome() );
        disciplinaDetalhadaDTO.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaDetalhadaDTO.setDescricao( disciplina.getDescricao() );
        disciplinaDetalhadaDTO.setAtiva( disciplina.getAtiva() );
        disciplinaDetalhadaDTO.setAlunos( alunoListToAlunoSemDisciplinasDTOList( disciplina.getAlunos() ) );

        return disciplinaDetalhadaDTO;
    }

    protected List<DisciplinaDetalhadaDTO> disciplinaListToDisciplinaDetalhadaDTOList(List<Disciplina> list) {
        if ( list == null ) {
            return null;
        }

        List<DisciplinaDetalhadaDTO> list1 = new ArrayList<DisciplinaDetalhadaDTO>( list.size() );
        for ( Disciplina disciplina : list ) {
            list1.add( disciplinaToDisciplinaDetalhadaDTO( disciplina ) );
        }

        return list1;
    }

    protected Aluno alunoSemDisciplinasDTOToAluno(AlunoSemDisciplinasDTO alunoSemDisciplinasDTO) {
        if ( alunoSemDisciplinasDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( alunoSemDisciplinasDTO.getId() );
        aluno.setMatricula( alunoSemDisciplinasDTO.getMatricula() );
        aluno.setCpf( alunoSemDisciplinasDTO.getCpf() );
        aluno.setNome( alunoSemDisciplinasDTO.getNome() );
        aluno.setDataNascimento( alunoSemDisciplinasDTO.getDataNascimento() );

        return aluno;
    }

    protected List<Aluno> alunoSemDisciplinasDTOListToAlunoList(List<AlunoSemDisciplinasDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Aluno> list1 = new ArrayList<Aluno>( list.size() );
        for ( AlunoSemDisciplinasDTO alunoSemDisciplinasDTO : list ) {
            list1.add( alunoSemDisciplinasDTOToAluno( alunoSemDisciplinasDTO ) );
        }

        return list1;
    }

    protected Disciplina disciplinaDetalhadaDTOToDisciplina(DisciplinaDetalhadaDTO disciplinaDetalhadaDTO) {
        if ( disciplinaDetalhadaDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( disciplinaDetalhadaDTO.getId() );
        disciplina.setNome( disciplinaDetalhadaDTO.getNome() );
        disciplina.setDescricao( disciplinaDetalhadaDTO.getDescricao() );
        disciplina.setCargaHoraria( disciplinaDetalhadaDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaDetalhadaDTO.getAtiva() );
        disciplina.setAlunos( alunoSemDisciplinasDTOListToAlunoList( disciplinaDetalhadaDTO.getAlunos() ) );

        return disciplina;
    }

    protected List<Disciplina> disciplinaDetalhadaDTOListToDisciplinaList(List<DisciplinaDetalhadaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Disciplina> list1 = new ArrayList<Disciplina>( list.size() );
        for ( DisciplinaDetalhadaDTO disciplinaDetalhadaDTO : list ) {
            list1.add( disciplinaDetalhadaDTOToDisciplina( disciplinaDetalhadaDTO ) );
        }

        return list1;
    }
}
