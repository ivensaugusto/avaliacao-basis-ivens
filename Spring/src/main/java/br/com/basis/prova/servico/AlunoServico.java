package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoGravarDTO;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.servico.mapper.AlunoDetalhadoMapper;
import br.com.basis.prova.servico.mapper.AlunoMapper;
import br.com.basis.prova.servico.mapper.AlunoGravarMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AlunoServico {

    private AlunoMapper alunoMapper;
    private AlunoDetalhadoMapper alunoDetalhadoMapper;
    private AlunoRepositorio alunoRepositorio;
    private AlunoGravarMapper alunoGravarMapper;
    //private AlunoDetalhadoDTO alunoDetalhadoDTO;

    public AlunoServico(AlunoMapper alunoMapper, AlunoDetalhadoMapper alunoDetalhadoMapper,
                        AlunoGravarMapper alunoGravarMapper, AlunoRepositorio alunoRepositorio) {
        this.alunoMapper = alunoMapper;
        this.alunoDetalhadoMapper = alunoDetalhadoMapper;
        this.alunoRepositorio = alunoRepositorio;
        this.alunoGravarMapper = alunoGravarMapper;

    }

    public AlunoDTO salvar(AlunoGravarDTO alunoGravarDTO) {//TODO mensagem de erro matricula já existe
        Aluno aluno = this.alunoRepositorio.findByMatricula(alunoGravarDTO.getMatricula());
        if (aluno == null) {
            aluno = alunoGravarMapper.toEntity(alunoGravarDTO);
            this.alunoRepositorio.save(aluno);
        }
        return alunoMapper.toDto(aluno);
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

            List<String> listNomeDisciplinasDTO = new ArrayList<String>();
            List<DisciplinaDTO> disciplinasDTO = aluno.getDisciplinas();
            for (DisciplinaDTO disciplinaDTO : disciplinasDTO) {
                if (disciplinaDTO.getAtiva() == 1) {// 1 igual a ativo true.
                    listNomeDisciplinasDTO.add(disciplinaDTO.getNome());
                }
            }
            aluno.setNomeDisciplinas(listNomeDisciplinasDTO);

        }
        return alunos;
    }

    public AlunoDTO editar(AlunoGravarDTO alunoGravarDTO) {
        Aluno aluno = this.alunoRepositorio.findByMatricula(alunoGravarDTO.getMatricula());
        alunoGravarDTO.setId(aluno.getId());
        aluno = alunoGravarMapper.toEntity(alunoGravarDTO);
        this.alunoRepositorio.save(aluno);
        return alunoMapper.toDto(aluno);
    }

    public void excluir(Integer id) {
        try {
            this.alunoRepositorio.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO mensagem de erro de aluno com disciplinas.
        }

    }

    public void excluirPorMatricula(String matricula) {
        this.alunoRepositorio.deleteByMatricula(matricula);
    }


}
