package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTOSalvar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T15:37:49-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class ProfessorMapperSalvarImpl implements ProfessorMapperSalvar {

    @Override
    public List<Professor> toEntity(List<ProfessorDTOSalvar> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Professor> list = new ArrayList<Professor>( dtoList.size() );
        for ( ProfessorDTOSalvar professorDTOSalvar : dtoList ) {
            list.add( toEntity( professorDTOSalvar ) );
        }

        return list;
    }

    @Override
    public List<ProfessorDTOSalvar> toDto(List<Professor> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProfessorDTOSalvar> list = new ArrayList<ProfessorDTOSalvar>( entityList.size() );
        for ( Professor professor : entityList ) {
            list.add( toDto( professor ) );
        }

        return list;
    }

    @Override
    public ProfessorDTOSalvar toDto(Professor professor) {
        if ( professor == null ) {
            return null;
        }

        ProfessorDTOSalvar professorDTOSalvar = new ProfessorDTOSalvar();

        professorDTOSalvar.setId( professor.getId() );
        professorDTOSalvar.setNome( professor.getNome() );
        professorDTOSalvar.setMatricula( professor.getMatricula() );
        professorDTOSalvar.setArea( professor.getArea() );
        professorDTOSalvar.setDataNascimento( professor.getDataNascimento() );
        professorDTOSalvar.setDisciplinas( disciplinaListToDisciplinaDTOList( professor.getDisciplinas() ) );

        return professorDTOSalvar;
    }

    @Override
    public Professor toEntity(ProfessorDTOSalvar professorDTOSalvar) {
        if ( professorDTOSalvar == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( professorDTOSalvar.getId() );
        professor.setNome( professorDTOSalvar.getNome() );
        professor.setMatricula( professorDTOSalvar.getMatricula() );
        professor.setArea( professorDTOSalvar.getArea() );
        professor.setDataNascimento( professorDTOSalvar.getDataNascimento() );
        professor.setDisciplinas( disciplinaDTOListToDisciplinaList( professorDTOSalvar.getDisciplinas() ) );

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
