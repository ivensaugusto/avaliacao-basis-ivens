package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlunoGravarDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String matricula;
    private LocalDate dataNascimento;
    private Integer idade;
    private List<DisciplinaGravarDTO> disciplinas = new ArrayList<>();
}