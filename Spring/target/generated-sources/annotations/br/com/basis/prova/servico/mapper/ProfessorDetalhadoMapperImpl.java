package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-07T09:06:44-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class ProfessorDetalhadoMapperImpl implements ProfessorDetalhadoMapper {

    @Override
    public List<Professor> toEntity(List<ProfessorDetalhadoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Professor> list = new ArrayList<Professor>( dtoList.size() );
        for ( ProfessorDetalhadoDTO professorDetalhadoDTO : dtoList ) {
            list.add( toEntity( professorDetalhadoDTO ) );
        }

        return list;
    }

    @Override
    public List<ProfessorDetalhadoDTO> toDto(List<Professor> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProfessorDetalhadoDTO> list = new ArrayList<ProfessorDetalhadoDTO>( entityList.size() );
        for ( Professor professor : entityList ) {
            list.add( toDto( professor ) );
        }

        return list;
    }

    @Override
    public ProfessorDetalhadoDTO toDto(Professor professor) {
        if ( professor == null ) {
            return null;
        }

        ProfessorDetalhadoDTO professorDetalhadoDTO = new ProfessorDetalhadoDTO();

        professorDetalhadoDTO.setId( professor.getId() );
        professorDetalhadoDTO.setNome( professor.getNome() );
        professorDetalhadoDTO.setMatricula( professor.getMatricula() );
        professorDetalhadoDTO.setDisciplinas( disciplinaListToDisciplinaDTOList( professor.getDisciplinas() ) );

        return professorDetalhadoDTO;
    }

    @Override
    public Professor toEntity(ProfessorDetalhadoDTO professorDetalhadoDTO) {
        if ( professorDetalhadoDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( professorDetalhadoDTO.getId() );
        professor.setNome( professorDetalhadoDTO.getNome() );
        professor.setMatricula( professorDetalhadoDTO.getMatricula() );
        professor.setDisciplinas( disciplinaDTOListToDisciplinaList( professorDetalhadoDTO.getDisciplinas() ) );

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