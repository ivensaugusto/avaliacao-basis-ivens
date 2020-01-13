package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaGravarDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-13T14:39:27-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class DisciplinaGravarMapperImpl implements DisciplinaGravarMapper {

    @Override
    public Disciplina toEntity(DisciplinaGravarDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( dto.getId() );
        disciplina.setNome( dto.getNome() );
        disciplina.setDescricao( dto.getDescricao() );
        disciplina.setCargaHoraria( dto.getCargaHoraria() );
        disciplina.setAtiva( dto.getAtiva() );

        return disciplina;
    }

    @Override
    public DisciplinaGravarDTO toDto(Disciplina entity) {
        if ( entity == null ) {
            return null;
        }

        DisciplinaGravarDTO disciplinaGravarDTO = new DisciplinaGravarDTO();

        disciplinaGravarDTO.setId( entity.getId() );
        disciplinaGravarDTO.setNome( entity.getNome() );
        disciplinaGravarDTO.setDescricao( entity.getDescricao() );
        disciplinaGravarDTO.setCargaHoraria( entity.getCargaHoraria() );
        disciplinaGravarDTO.setAtiva( entity.getAtiva() );

        return disciplinaGravarDTO;
    }

    @Override
    public List<Disciplina> toEntity(List<DisciplinaGravarDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Disciplina> list = new ArrayList<Disciplina>( dtoList.size() );
        for ( DisciplinaGravarDTO disciplinaGravarDTO : dtoList ) {
            list.add( toEntity( disciplinaGravarDTO ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaGravarDTO> toDto(List<Disciplina> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DisciplinaGravarDTO> list = new ArrayList<DisciplinaGravarDTO>( entityList.size() );
        for ( Disciplina disciplina : entityList ) {
            list.add( toDto( disciplina ) );
        }

        return list;
    }
}
