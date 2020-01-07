package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaGravarDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.mapper.DisciplinaDetalhadaMapper;
import br.com.basis.prova.servico.mapper.DisciplinaGravarMapper;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DisciplinaServico {

    private DisciplinaRepositorio disciplinaRepositorio;
    private DisciplinaMapper disciplinaMapper;
    private DisciplinaDetalhadaMapper disciplinaDetalhadaMapper;
    private DisciplinaGravarMapper disciplinaGravarMapper;

    public DisciplinaServico(DisciplinaMapper disciplinaMapper, DisciplinaDetalhadaMapper disciplinaDetalhadaMapper,
                             DisciplinaGravarMapper disciplinaGravarMapper, DisciplinaRepositorio disciplinaRepositorio) {
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepositorio = disciplinaRepositorio;
        this.disciplinaDetalhadaMapper = disciplinaDetalhadaMapper;
        this.disciplinaGravarMapper = disciplinaGravarMapper;
    }

    public DisciplinaDTO salvar(DisciplinaGravarDTO disciplinaGravarDTO) {//TODO mensagem de erro disciplina já existe
        Disciplina disciplina = this.disciplinaRepositorio.findByNome(disciplinaGravarDTO.getNome());
        if (disciplina == null) {
            disciplina = disciplinaMapper.toEntity(disciplinaGravarDTO);
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
        List<DisciplinaDetalhadaDTO> disciplinas = disciplinaDetalhadaMapper.toDto(l);
        return disciplinas;
    }

    public DisciplinaDTO editar(DisciplinaGravarDTO disciplinaGravarDTO) {
        Disciplina disciplina = this.disciplinaRepositorio.findByNome(disciplinaGravarDTO.getNome());
        disciplinaGravarDTO.setId(disciplina.getId());
        disciplina = disciplinaGravarMapper.toEntity(disciplinaGravarDTO);
        this.disciplinaRepositorio.save(disciplina);
        return disciplinaMapper.toDto(disciplina);
    }

}
