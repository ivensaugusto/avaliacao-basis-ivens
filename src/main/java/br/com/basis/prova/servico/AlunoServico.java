package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoDTOSalvar;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.servico.mapper.AlunoDetalhadoMapper;
import br.com.basis.prova.servico.mapper.AlunoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AlunoServico {

    private AlunoMapper alunoMapper;
    private AlunoDetalhadoMapper alunoDetalhadoMapper;
    private AlunoRepositorio alunoRepositorio;

    public AlunoServico(AlunoMapper alunoMapper, AlunoDetalhadoMapper alunoDetalhadoMapper, AlunoRepositorio alunoRepositorio) {
        this.alunoMapper = alunoMapper;
        this.alunoDetalhadoMapper = alunoDetalhadoMapper;
        this.alunoRepositorio = alunoRepositorio;
    }

    public AlunoDTO salvar(AlunoDTOSalvar alunoDTOSalvar) {
        Aluno aluno = alunoMapper.toEntity(alunoDTOSalvar);
        this.alunoRepositorio.save(aluno);
        // this.disciplinaRepositorio.saveAll(aluno.getDisciplinas());
        return alunoMapper.toDto(aluno);
    }

    public void excluir(Integer id) {
        this.alunoRepositorio.deleteById(id);
    }

    public List<AlunoDTO> consultar() {
        List<AlunoDTO> alunos = alunoMapper.toDto(this.alunoRepositorio.findAll());
        for (AlunoDTO aluno : alunos) {
            aluno.setIdade(LocalDate.now().getYear() - aluno.getDataNascimento().getYear());
        }
        return alunos;
    }

    public List<AlunoDetalhadoDTO> detalhar() {
        List<AlunoDetalhadoDTO> alunos = alunoDetalhadoMapper.toDto(this.alunoRepositorio.findAll());
        for (AlunoDetalhadoDTO aluno : alunos) {
            aluno.setIdade(LocalDate.now().getYear() - aluno.getDataNascimento().getYear());
        }
        return alunos;
    }

}
