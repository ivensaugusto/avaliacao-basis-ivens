package br.com.basis.prova.dominio.dto;

import br.com.basis.prova.dominio.Disciplina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AlunoDetalhadoDTO {

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
    @DateTimeFormat(pattern = "dd/mm/yyy")
    private LocalDate dataNascimento;

    private Integer idade;
    private List<DisciplinaDTO> disciplinas = new ArrayList<>();
    private List<String> nomeDisciplinas = new ArrayList<>();

}

