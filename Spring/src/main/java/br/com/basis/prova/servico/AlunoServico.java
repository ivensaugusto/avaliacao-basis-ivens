package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.AlunoDetalhadoMapper;
import br.com.basis.prova.servico.mapper.AlunoMapper;
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
    private DisciplinaRepositorio disciplinaRepositorio;

    public AlunoServico(AlunoMapper alunoMapper, AlunoDetalhadoMapper alunoDetalhadoMapper,
                        AlunoRepositorio alunoRepositorio, DisciplinaRepositorio disciplinaRepositorio) {

        this.alunoMapper = alunoMapper;
        this.alunoDetalhadoMapper = alunoDetalhadoMapper;
        this.alunoRepositorio = alunoRepositorio;
        this.disciplinaRepositorio = disciplinaRepositorio;
    }

    public AlunoDTO salvar(AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        if (verificarCPF(aluno)) {
            throw new RegraNegocioException("CPF já existe");
        }
        if (verificarMatricula(aluno)) {
            throw new RegraNegocioException("Matrícula já existe");
        }
        alunoRepositorio.save(aluno);
        return alunoMapper.toDto(aluno);
    }

    private boolean verificarCPF(Aluno aluno) {
        Aluno alunoCpf = alunoRepositorio.findByCpf(aluno.getCpf());
        return !(alunoCpf == null || alunoCpf.getId().equals(aluno.getId()));
    }

    private boolean verificarMatricula(Aluno aluno) {
        Aluno alunoMatricula = alunoRepositorio.findByMatricula(aluno.getMatricula());
        return !(alunoMatricula == null || alunoMatricula.getId().equals(aluno.getId()));
    }

    public AlunoDTO consultarPorId(Integer id) {
        AlunoDTO alunoDTO = alunoMapper.toDto(alunoRepositorio.findById(id).get());
        alunoDTO.setIdade(LocalDate.now().getYear() - alunoDTO.getDataNascimento().getYear());
        return alunoDTO;
    }

    public List<AlunoDTO> consultar() {
        List<AlunoDTO> alunos = alunoMapper.toDto(alunoRepositorio.findAll());
        preencherIdades(alunos);
        return alunos;
    }

    private void preencherIdades(List<AlunoDTO> alunos) {
        alunos.forEach(alunoDTO -> {
            alunoDTO.setIdade(LocalDate.now().getYear() - alunoDTO.getDataNascimento().getYear());
        });
    }

    public List<AlunoDetalhadoDTO> detalhar() {
        List<AlunoDetalhadoDTO> alunos = alunoDetalhadoMapper.toDto(this.alunoRepositorio.findAll());

        alunos.forEach(alunoDetalhadoDTO -> {
            List<String> listNomeDisciplinasDTO = new ArrayList<String>();
            alunoDetalhadoDTO.setIdade(LocalDate.now().getYear() - alunoDetalhadoDTO.getDataNascimento().getYear());
            List<DisciplinaDTO> disciplinasDTO = alunoDetalhadoDTO.getDisciplinas();
            for (DisciplinaDTO disciplinaDTO : disciplinasDTO) {
                if (disciplinaDTO.getAtiva() == 1) {
                    listNomeDisciplinasDTO.add(disciplinaDTO.getNome());
                }
            }
            alunoDetalhadoDTO.setNomeDisciplinas(listNomeDisciplinasDTO);
        });
        return alunos;
    }

    public void excluir(Integer id) {

        Aluno aluno = alunoRepositorio.findById(id).orElseThrow(() ->
                new RegraNegocioException("Aluno não encontrado"));

        List<Disciplina> disciplinas = disciplinaRepositorio.findAllByAtivaAndAlunos(1, aluno);

        if (!disciplinas.isEmpty()) {
            throw new RegraNegocioException("Aluno matriculado em disciplinas");
        }

        alunoRepositorio.delete(aluno);
    }

}
