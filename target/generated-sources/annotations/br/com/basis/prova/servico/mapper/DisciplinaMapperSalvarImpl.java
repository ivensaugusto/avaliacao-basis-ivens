package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTOSalvar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-03T13:34:57-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_232 (Private Build)"
)
@Component
public class DisciplinaMapperSalvarImpl implements DisciplinaMapperSalvar {

    @Override
    public Disciplina toEntity(DisciplinaDTOSalvar dto) {
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
    public DisciplinaDTOSalvar toDto(Disciplina entity) {
        if ( entity == null ) {
            return null;
        }

        DisciplinaDTOSalvar disciplinaDTOSalvar = new DisciplinaDTOSalvar();

        disciplinaDTOSalvar.setId( entity.getId() );
        disciplinaDTOSalvar.setNome( entity.getNome() );
        disciplinaDTOSalvar.setDescricao( entity.getDescricao() );
        disciplinaDTOSalvar.setCargaHoraria( entity.getCargaHoraria() );
        disciplinaDTOSalvar.setAtiva( entity.getAtiva() );

        return disciplinaDTOSalvar;
    }

    @Override
    public List<Disciplina> toEntity(List<DisciplinaDTOSalvar> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Disciplina> list = new ArrayList<Disciplina>( dtoList.size() );
        for ( DisciplinaDTOSalvar disciplinaDTOSalvar : dtoList ) {
            list.add( toEntity( disciplinaDTOSalvar ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaDTOSalvar> toDto(List<Disciplina> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DisciplinaDTOSalvar> list = new ArrayList<DisciplinaDTOSalvar>( entityList.size() );
        for ( Disciplina disciplina : entityList ) {
            list.add( toDto( disciplina ) );
        }

        return list;
    }
}
