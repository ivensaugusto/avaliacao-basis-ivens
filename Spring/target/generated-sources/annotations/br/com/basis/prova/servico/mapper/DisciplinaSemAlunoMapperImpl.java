package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaSemAlunoDTO;
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
public class DisciplinaSemAlunoMapperImpl implements DisciplinaSemAlunoMapper {

    @Override
    public List<Disciplina> toEntity(List<DisciplinaSemAlunoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Disciplina> list = new ArrayList<Disciplina>( dtoList.size() );
        for ( DisciplinaSemAlunoDTO disciplinaSemAlunoDTO : dtoList ) {
            list.add( toEntity( disciplinaSemAlunoDTO ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaSemAlunoDTO> toDto(List<Disciplina> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DisciplinaSemAlunoDTO> list = new ArrayList<DisciplinaSemAlunoDTO>( entityList.size() );
        for ( Disciplina disciplina : entityList ) {
            list.add( toDto( disciplina ) );
        }

        return list;
    }

    @Override
    public DisciplinaSemAlunoDTO toDto(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaSemAlunoDTO disciplinaSemAlunoDTO = new DisciplinaSemAlunoDTO();

        disciplinaSemAlunoDTO.setId( disciplina.getId() );
        disciplinaSemAlunoDTO.setNome( disciplina.getNome() );
        disciplinaSemAlunoDTO.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaSemAlunoDTO.setDescricao( disciplina.getDescricao() );
        disciplinaSemAlunoDTO.setAtiva( disciplina.getAtiva() );

        return disciplinaSemAlunoDTO;
    }

    @Override
    public Disciplina toEntity(DisciplinaSemAlunoDTO disciplinaDetalhadaDTO) {
        if ( disciplinaDetalhadaDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( disciplinaDetalhadaDTO.getId() );
        disciplina.setNome( disciplinaDetalhadaDTO.getNome() );
        disciplina.setDescricao( disciplinaDetalhadaDTO.getDescricao() );
        disciplina.setCargaHoraria( disciplinaDetalhadaDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaDetalhadaDTO.getAtiva() );

        return disciplina;
    }
}
