package br.com.basis.prova.dominio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDetalhadaDTO {

    private Integer id;
    private String nome;
    private Integer cargaHoraria;
    private String nomeProfessor;

}
