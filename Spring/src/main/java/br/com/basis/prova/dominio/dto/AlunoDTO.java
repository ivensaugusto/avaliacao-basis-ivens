package br.com.basis.prova.dominio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlunoDTO {

    @JsonIgnore
    private Integer id;
    private String nome;
    @JsonIgnore
    private String cpf;
    private String matricula;
    @JsonIgnore
    private LocalDate dataNascimento;
    private Integer idade;
    @JsonIgnore
    private List<DisciplinaDTO> disciplinas = new ArrayList<>();
}
