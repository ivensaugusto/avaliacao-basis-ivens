package br.com.basis.prova.dominio;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROFESSOR")
@Getter
@Setter
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "MATRICULA", nullable = false)
    private String matricula;

    @Column(name = "AREA_ATUACAO", nullable = false)
    private String area;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @JsonManagedReference
    @ManyToMany(/*cascade = CascadeType.ALL, */fetch = FetchType.LAZY)
    @JoinTable(name = "DISCIPLINA_PROFESSOR",
            joinColumns = @JoinColumn(name = "ID_PROFESSOR", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_DISCIPLINA", referencedColumnName = "ID"))
    private List<Disciplina> disciplinas = new ArrayList<>();

}
