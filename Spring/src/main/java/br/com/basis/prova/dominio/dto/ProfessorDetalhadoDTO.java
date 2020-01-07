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

    @JsonIgnore
    private Integer id;
    private String nome;
    private String matricula;
    @JsonIgnore
    private List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
    private List<String> nomeDisciplina;

}
