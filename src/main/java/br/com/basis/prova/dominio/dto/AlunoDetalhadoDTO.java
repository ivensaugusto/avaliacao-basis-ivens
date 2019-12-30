package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AlunoDetalhadoDTO {

    private Integer id;
    private String nome;
    private String matricula;
    private Integer idade;
    private List<String> disciplinas = new ArrayList<>();

}
