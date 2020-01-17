package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-17T15:30:38-0300",
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
        professorDetalhadoDTO.setArea( professor.getArea() );

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
        professor.setArea( professorDetalhadoDTO.getArea() );

        return professor;
    }
}
