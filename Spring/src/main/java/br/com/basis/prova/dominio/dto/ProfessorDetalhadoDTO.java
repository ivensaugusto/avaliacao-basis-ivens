package br.com.basis.prova.dominio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorDetalhadoDTO {

    private Integer id;

    @NotNull
    @Size(min = 1, max = 50, message = "Nome inválido")
    private String nome;

    @NotNull
    @Size(min = 6, max = 6)
    private String matricula;

    @NotNull
    @Size(min = 1, max = 200, message = "Área inválida")
    private String area;

//    private List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
    private List<String> nomeDisciplinas;

}
