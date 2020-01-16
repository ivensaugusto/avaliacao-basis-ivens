package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
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
public class ProfessorMapperImpl implements ProfessorMapper {

    @Override
    public Professor toEntity(ProfessorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( dto.getId() );
        professor.setNome( dto.getNome() );
        professor.setMatricula( dto.getMatricula() );
        professor.setArea( dto.getArea() );
        professor.setDataNascimento( dto.getDataNascimento() );
        professor.setDisciplinas( disciplinaDTOListToDisciplinaList( dto.getDisciplinas() ) );

        return professor;
    }

    @Override
    public ProfessorDTO toDto(Professor entity) {
        if ( entity == null ) {
            return null;
        }

        ProfessorDTO professorDTO = new ProfessorDTO();

        professorDTO.setId( entity.getId() );
        professorDTO.setNome( entity.getNome() );
        professorDTO.setMatricula( entity.getMatricula() );
        professorDTO.setArea( entity.getArea() );
        professorDTO.setDataNascimento( entity.getDataNascimento() );
        professorDTO.setDisciplinas( disciplinaListToDisciplinaDTOList( entity.getDisciplinas() ) );

        return professorDTO;
    }

    @Override
    public List<Professor> toEntity(List<ProfessorDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Professor> list = new ArrayList<Professor>( dtoList.size() );
        for ( ProfessorDTO professorDTO : dtoList ) {
            list.add( toEntity( professorDTO ) );
        }

        return list;
    }

    @Override
    public List<ProfessorDTO> toDto(List<Professor> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProfessorDTO> list = new ArrayList<ProfessorDTO>( entityList.size() );
        for ( Professor professor : entityList ) {
            list.add( toDto( professor ) );
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
