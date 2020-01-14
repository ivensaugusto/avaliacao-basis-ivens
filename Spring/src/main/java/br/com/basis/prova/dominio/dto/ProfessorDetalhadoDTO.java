package br.com.basis.prova.dominio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorDetalhadoDTO {

    private Integer id;
    private String nome;
    private String matricula;
    private List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
    private List<String> nomeDisciplinas;

}
