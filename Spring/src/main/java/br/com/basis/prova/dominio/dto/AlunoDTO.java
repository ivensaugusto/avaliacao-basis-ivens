package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlunoDTO {

    private Integer id;

    @NotNull
    @Size(min = 1, max = 100, message = "Nome inválido")
    private String nome;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    @Size(min = 6, max = 6)
    private String matricula;

    @NotNull
    private LocalDate dataNascimento;

    private Integer idade;

    private List<DisciplinaDTO> disciplinas = new ArrayList<>();
}
