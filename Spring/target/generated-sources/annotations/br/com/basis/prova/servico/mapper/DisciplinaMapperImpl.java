package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaGravarDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-10T10:20:03-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class DisciplinaMapperImpl implements DisciplinaMapper {

    @Override
    public List<Disciplina> toEntity(List<DisciplinaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Disciplina> list = new ArrayList<Disciplina>( dtoList.size() );
        for ( DisciplinaDTO disciplinaDTO : dtoList ) {
            list.add( toEntity( disciplinaDTO ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaDTO> toDto(List<Disciplina> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DisciplinaDTO> list = new ArrayList<DisciplinaDTO>( entityList.size() );
        for ( Disciplina disciplina : entityList ) {
            list.add( toDto( disciplina ) );
        }

        return list;
    }

    @Override
    public DisciplinaDTO toDto(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();

        Integer id = disciplinaProfessorId( disciplina );
        if ( id != null ) {
            disciplinaDTO.setIdProfessor( id );
        }
        disciplinaDTO.setId( disciplina.getId() );
        disciplinaDTO.setNome( disciplina.getNome() );
        disciplinaDTO.setDescricao( disciplina.getDescricao() );
        disciplinaDTO.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaDTO.setAtiva( disciplina.getAtiva() );

        return disciplinaDTO;
    }

    @Override
    public Disciplina toEntity(DisciplinaDTO disciplinaDTO) {
        if ( disciplinaDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setProfessor( disciplinaDTOToProfessor( disciplinaDTO ) );
        disciplina.setId( disciplinaDTO.getId() );
        disciplina.setNome( disciplinaDTO.getNome() );
        disciplina.setDescricao( disciplinaDTO.getDescricao() );
        disciplina.setCargaHoraria( disciplinaDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaDTO.getAtiva() );

        return disciplina;
    }

    @Override
    public Disciplina toEntity(DisciplinaGravarDTO disciplinaGravarDTO) {
        if ( disciplinaGravarDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setProfessor( disciplinaGravarDTOToProfessor( disciplinaGravarDTO ) );
        disciplina.setId( disciplinaGravarDTO.getId() );
        disciplina.setNome( disciplinaGravarDTO.getNome() );
        disciplina.setDescricao( disciplinaGravarDTO.getDescricao() );
        disciplina.setCargaHoraria( disciplinaGravarDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaGravarDTO.getAtiva() );

        return disciplina;
    }

    private Integer disciplinaProfessorId(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }
        Professor professor = disciplina.getProfessor();
        if ( professor == null ) {
            return null;
        }
        Integer id = professor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Professor disciplinaDTOToProfessor(DisciplinaDTO disciplinaDTO) {
        if ( disciplinaDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( disciplinaDTO.getIdProfessor() );

        return professor;
    }

    protected Professor disciplinaGravarDTOToProfessor(DisciplinaGravarDTO disciplinaGravarDTO) {
        if ( disciplinaGravarDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( disciplinaGravarDTO.getIdProfessor() );

        return professor;
    }
}
