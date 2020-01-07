package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaGravarDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-06T22:59:49-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class DisciplinaGravarMapperImpl implements DisciplinaGravarMapper {

    @Override
    public Disciplina toEntity(DisciplinaGravarDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( arg0.getId() );
        disciplina.setNome( arg0.getNome() );
        disciplina.setDescricao( arg0.getDescricao() );
        disciplina.setCargaHoraria( arg0.getCargaHoraria() );
        disciplina.setAtiva( arg0.getAtiva() );

        return disciplina;
    }

    @Override
    public DisciplinaGravarDTO toDto(Disciplina arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DisciplinaGravarDTO disciplinaGravarDTO = new DisciplinaGravarDTO();

        disciplinaGravarDTO.setId( arg0.getId() );
        disciplinaGravarDTO.setNome( arg0.getNome() );
        disciplinaGravarDTO.setDescricao( arg0.getDescricao() );
        disciplinaGravarDTO.setCargaHoraria( arg0.getCargaHoraria() );
        disciplinaGravarDTO.setAtiva( arg0.getAtiva() );

        return disciplinaGravarDTO;
    }

    @Override
    public List<Disciplina> toEntity(List<DisciplinaGravarDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Disciplina> list = new ArrayList<Disciplina>( arg0.size() );
        for ( DisciplinaGravarDTO disciplinaGravarDTO : arg0 ) {
            list.add( toEntity( disciplinaGravarDTO ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaGravarDTO> toDto(List<Disciplina> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DisciplinaGravarDTO> list = new ArrayList<DisciplinaGravarDTO>( arg0.size() );
        for ( Disciplina disciplina : arg0 ) {
            list.add( toDto( disciplina ) );
        }

        return list;
    }
}
