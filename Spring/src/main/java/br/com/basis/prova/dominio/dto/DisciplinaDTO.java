package br.com.basis.prova.dominio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO {

    @JsonIgnore
    private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    @JsonIgnore
    private Integer ativa;
    @JsonIgnore
    private Integer idProfessor;
}