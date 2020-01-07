package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDTOSalvar;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.mapper.DisciplinaDetalhadoMapper;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import br.com.basis.prova.servico.mapper.DisciplinaMapperSalvar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DisciplinaServico {

    private DisciplinaRepositorio disciplinaRepositorio;
    private DisciplinaMapper disciplinaMapper;
    private DisciplinaDetalhadoMapper disciplinaDetalhadoMapper;
    private DisciplinaMapperSalvar disciplinaMapperSalvar;

    public DisciplinaServico(DisciplinaMapper disciplinaMapper, DisciplinaDetalhadoMapper disciplinaDetalhadoMapper,
                             DisciplinaMapperSalvar disciplinaMapperSalvar, DisciplinaRepositorio disciplinaRepositorio) {
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepositorio = disciplinaRepositorio;
        this.disciplinaDetalhadoMapper = disciplinaDetalhadoMapper;
        this.disciplinaMapperSalvar = disciplinaMapperSalvar;
    }

    public DisciplinaDTO salvar(DisciplinaDTOSalvar disciplinaDTOSalvar) {//TODO mensagem de erro disciplina já existe
        Disciplina disciplina = this.disciplinaRepositorio.findByNome(disciplinaDTOSalvar.getNome());
        if (disciplina == null) {
            disciplina = disciplinaMapper.toEntity(disciplinaDTOSalvar);
            this.disciplinaRepositorio.save(disciplina);
        }
        return disciplinaMapper.toDto(disciplina);
    }

    public void excluir(Integer id) {
        try {
            this.disciplinaRepositorio.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            //TODO mensagem de erro de disciplina com alunos.
        }
    }

    public void excluirPorNome(String nome) { //TODO mensagem de erro de disciplina com alunos.
        this.disciplinaRepositorio.deleteByNome(nome);
    }

    public List<DisciplinaDTO> consultar() {
        List<DisciplinaDTO> disciplinas = disciplinaMapper.toDto(this.disciplinaRepositorio.findAll());
        return disciplinas;
    }

    public List<DisciplinaDetalhadaDTO> detalhar() {
        List<Disciplina> l = this.disciplinaRepositorio.findAll();
        List<DisciplinaDetalhadaDTO> disciplinas = disciplinaDetalhadoMapper.toDto(l);
        return disciplinas;
    }

    public DisciplinaDTO editar(DisciplinaDTOSalvar disciplinaDTOSalvar) {
        Disciplina disciplina = this.disciplinaRepositorio.findByNome(disciplinaDTOSalvar.getNome());
        disciplinaDTOSalvar.setId(disciplina.getId());
        disciplina = disciplinaMapperSalvar.toEntity(disciplinaDTOSalvar);
        this.disciplinaRepositorio.save(disciplina);
        return disciplinaMapper.toDto(disciplina);
    }

}
