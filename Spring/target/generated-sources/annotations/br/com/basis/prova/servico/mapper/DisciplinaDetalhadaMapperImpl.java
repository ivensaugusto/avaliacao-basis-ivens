package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-14T08:16:34-0300",
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

    protected Professor disciplinaDetalhadaDTOToProfessor(DisciplinaDetalhadaDTO disciplinaDetalhadaDTO) {
        if ( disciplinaDetalhadaDTO == null ) {
            return null;
        }

        Professor professor = new Professor();

        professor.setNome( disciplinaDetalhadaDTO.getNomeProfessor() );

        return professor;
    }
}
