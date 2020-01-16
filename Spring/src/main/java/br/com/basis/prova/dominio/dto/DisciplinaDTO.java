package br.com.basis.prova.dominio.dto;

import br.com.basis.prova.dominio.Aluno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO {

    private Integer id;

    @NotNull
    @Size(min = 1, max = 50, message = "Nome de disciplina inválido")
    private String nome;

    @NotNull
    @Size(min = 1, max = 100, message = "Descrição inválida")
    private String descricao;

    @NotNull
    private Integer cargaHoraria;

    private Integer ativa;
    private Integer idProfessor;

}