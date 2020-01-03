package br.com.basis.prova.dominio;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ALUNO")
@Getter
@Setter
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "MATRICULA", nullable = false)
    private String matricula;

    @Column(name = "CPF", nullable = false)
    @CPF
    private String cpf;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ALUNO_DISCIPLINA",
            joinColumns = @JoinColumn(name = "ID_ALUNO", referencedColumnName = "ID"),
            inverseJoinColumns= @JoinColumn(name = "ID_DISCIPLINA", referencedColumnName = "ID"))
    private List<Disciplina> disciplinas = new ArrayList<>();

}

