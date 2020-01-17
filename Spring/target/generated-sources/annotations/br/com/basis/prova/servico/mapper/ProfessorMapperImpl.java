package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-17T15:30:38-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class ProfessorMapperImpl implements ProfessorMapper {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

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

    @Override
    public ProfessorDTO toDto(Professor professor) {
        if ( professor == null ) {
            return null;
        }

        ProfessorDTO professorDTO = new ProfessorDTO();

        professorDTO.setId( professor.getId() );
        professorDTO.setNome( professor.getNome() );
        professorDTO.setMatricula( professor.getMatricula() );
        professorDTO.setArea( professor.getArea() );
        professorDTO.setDataNascimento( professor.getDataNascimento() );
        professorDTO.setDisciplinas( disciplinaMapper.toDto( professor.getDisciplinas() ) );

        return professorDTO;
    }

    @Override
    public Professor toEntity(ProfessorDTO professorDTO) {
        if ( professorDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setId( professorDTO.getId() );
        professor.setNome( professorDTO.getNome() );
        professor.setMatricula( professorDTO.getMatricula() );
        professor.setArea( professorDTO.getArea() );
        professor.setDataNascimento( professorDTO.getDataNascimento() );
        professor.setDisciplinas( disciplinaMapper.toEntity( professorDTO.getDisciplinas() ) );

        return professor;
    }
}
