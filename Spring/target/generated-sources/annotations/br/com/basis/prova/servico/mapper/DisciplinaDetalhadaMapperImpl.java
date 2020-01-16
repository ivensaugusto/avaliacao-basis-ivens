package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.AlunoSemDisciplinasDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-16T16:03:47-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class DisciplinaDetalhadaMapperImpl implements DisciplinaDetalhadaMapper {

    @Override
    public List<Disciplina> toEntity(List<DisciplinaDetalhadaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Disciplina> list = new ArrayList<Disciplina>( dtoList.size() );
        for ( DisciplinaDetalhadaDTO disciplinaDetalhadaDTO : dtoList ) {
            list.add( toEntity( disciplinaDetalhadaDTO ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaDetalhadaDTO> toDto(List<Disciplina> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DisciplinaDetalhadaDTO> list = new ArrayList<DisciplinaDetalhadaDTO>( entityList.size() );
        for ( Disciplina disciplina : entityList ) {
            list.add( toDto( disciplina ) );
        }

        return list;
    }

    @Override
    public DisciplinaDetalhadaDTO toDto(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaDetalhadaDTO disciplinaDetalhadaDTO = new DisciplinaDetalhadaDTO();

        String nome = disciplinaProfessorNome( disciplina );
        if ( nome != null ) {
            disciplinaDetalhadaDTO.setNomeProfessor( nome );
        }
        disciplinaDetalhadaDTO.setId( disciplina.getId() );
        disciplinaDetalhadaDTO.setNome( disciplina.getNome() );
        disciplinaDetalhadaDTO.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaDetalhadaDTO.setAtiva( disciplina.getAtiva() );
        disciplinaDetalhadaDTO.setAlunos( alunoListToAlunoSemDisciplinasDTOList( disciplina.getAlunos() ) );

        return disciplinaDetalhadaDTO;
    }

    @Override
    public Disciplina toEntity(DisciplinaDetalhadaDTO disciplinaDetalhadaDTO) {
        if ( disciplinaDetalhadaDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setProfessor( disciplinaDetalhadaDTOToProfessor( disciplinaDetalhadaDTO ) );
        disciplina.setId( disciplinaDetalhadaDTO.getId() );
        disciplina.setNome( disciplinaDetalhadaDTO.getNome() );
        disciplina.setCargaHoraria( disciplinaDetalhadaDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaDetalhadaDTO.getAtiva() );
        disciplina.setAlunos( alunoSemDisciplinasDTOListToAlunoList( disciplinaDetalhadaDTO.getAlunos() ) );

        return disciplina;
    }

    private String disciplinaProfessorNome(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }
        Professor professor = disciplina.getProfessor();
        if ( professor == null ) {
            return null;
        }
        String nome = professor.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
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

    protected Professor disciplinaDetalhadaDTOToProfessor(DisciplinaDetalhadaDTO disciplinaDetalhadaDTO) {
        if ( disciplinaDetalhadaDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setNome( disciplinaDetalhadaDTO.getNomeProfessor() );

        return professor;
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
}
