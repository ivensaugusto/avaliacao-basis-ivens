package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoDTOSalvar;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.servico.mapper.AlunoDetalhadoMapper;
import br.com.basis.prova.servico.mapper.AlunoMapper;
import br.com.basis.prova.servico.mapper.AlunoMapperSalvar;
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
    private AlunoMapperSalvar alunoMapperSalvar;
    //private AlunoDetalhadoDTO alunoDetalhadoDTO;

    public AlunoServico(AlunoMapper alunoMapper, AlunoDetalhadoMapper alunoDetalhadoMapper,
                        AlunoMapperSalvar alunoMapperSalvar, AlunoRepositorio alunoRepositorio) {
        this.alunoMapper = alunoMapper;
        this.alunoDetalhadoMapper = alunoDetalhadoMapper;
        this.alunoRepositorio = alunoRepositorio;
        this.alunoMapperSalvar = alunoMapperSalvar;

    }

    public AlunoDTO salvar(AlunoDTOSalvar alunoDTOSalvar) {//TODO mensagem de erro matricula já existe
        Aluno aluno = this.alunoRepositorio.findByMatricula(alunoDTOSalvar.getMatricula());
        if (aluno == null) {
            aluno = alunoMapperSalvar.toEntity(alunoDTOSalvar);
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

    public AlunoDTO editar(AlunoDTOSalvar alunoDTOSalvar) {
        Aluno aluno = this.alunoRepositorio.findByMatricula(alunoDTOSalvar.getMatricula());
        alunoDTOSalvar.setId(aluno.getId());
        aluno = alunoMapperSalvar.toEntity(alunoDTOSalvar);
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
