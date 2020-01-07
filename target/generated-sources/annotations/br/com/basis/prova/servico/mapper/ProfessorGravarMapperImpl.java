package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.ProfessorGravarDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T22:59:50-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class ProfessorGravarMapperImpl implements ProfessorGravarMapper {

    @Override
    public List<Professor> toEntity(List<ProfessorGravarDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Professor> list = new ArrayList<Professor>( arg0.size() );
        for ( ProfessorGravarDTO professorGravarDTO : arg0 ) {
            list.add( toEntity( professorGravarDTO ) );
        }

        return list;
    }

    @Override
    public List<ProfessorGravarDTO> toDto(List<Professor> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<ProfessorGravarDTO> list = new ArrayList<ProfessorGravarDTO>( arg0.size() );
        for ( Professor professor : arg0 ) {
            list.add( toDto( professor ) );
        }

        return list;
    }

    @Override
    public ProfessorGravarDTO toDto(Professor professor) {
        if ( professor == null ) {
            return null;
        }

        ProfessorGravarDTO professorGravarDTO = new ProfessorGravarDTO();

        professorGravarDTO.setId( professor.getId() );
        professorGravarDTO.setNome( professor.getNome() );
        professorGravarDTO.setMatricula( professor.getMatricula() );
        professorGravarDTO.setArea( professor.getArea() );
        professorGravarDTO.setDataNascimento( professor.getDataNascimento() );
        professorGravarDTO.setDisciplinas( disciplinaListToDisciplinaDTOList( professor.getDisciplinas() ) );

        return professorGravarDTO;
    }

    @Override
    public Professor toEntity(ProfessorGravarDTO professorGravarDTO) {
        if ( professorGravarDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( professorGravarDTO.getId() );
        professor.setNome( professorGravarDTO.getNome() );
        professor.setMatricula( professorGravarDTO.getMatricula() );
        professor.setArea( professorGravarDTO.getArea() );
        professor.setDataNascimento( professorGravarDTO.getDataNascimento() );
        professor.setDisciplinas( disciplinaDTOListToDisciplinaList( professorGravarDTO.getDisciplinas() ) );

        return professor;
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
}
