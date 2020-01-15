import { Component, OnInit } from '@angular/core';

import { DisciplinaService } from './../../services/disciplina.service';
import { AlunoService } from 'src/app/services/aluno.service';
import { SelectItem } from 'primeng/api/selectitem';
import { Aluno } from '../aluno.model';
import { MultiSelectModule } from 'primeng/multiselect';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})

export class FormularioComponent implements OnInit {

  nomeDisciplinas: SelectItem[] = [];
  disciplinas: any[] = [];
  aluno: Aluno = new Aluno();
  alunos: any = [];
  disciplinasSelecionadas: any[];

  constructor(
    private title: Title,
    private alunoService: AlunoService,
    private disciplinaService: DisciplinaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.title.setTitle('Cadastro de alunos');
    this.consultarDisciplinas();
    this.atualizar();
    console.log(this.buscarAlunoporId(this.route.snapshot.params[`id`]));
    console.log(this.route.snapshot.params[`id`]);
    console.log(this.alunos);
    console.log(this.disciplinas);
    console.log(this.nomeDisciplinas);



  }

  salvarAluno(formAlunos: NgForm) {
    this.aluno.nome = formAlunos.value.nome;
    this.aluno.cpf = formAlunos.value.CPF;
    this.aluno.matricula = formAlunos.value.matricula;
    this.aluno.dataNascimento = formAlunos.value.dataNascimento;
    this.listarDisciplinas();
    if (this.aluno.disciplinas.length === 0) {
      alert('O aluno deve estar matriculado em alguma disciplina.');
    } else {
      this.alunoService.adicionar(this.aluno).subscribe();
      console.log(this.aluno);
      formAlunos.reset();
    }
  }

  buscarAlunoporId(id: number) {
    return this.alunos.find(aluno => aluno.id === id);
  }

  atualizar() {
    this.alunoService.consultar().subscribe(res => {
      this.alunos = res;
    });
    return this.alunos;
  }

  consultarDisciplinas() {
    this.disciplinaService.consultar().subscribe(disciplina => {
      this.disciplinas = disciplina;
      this.converterParaDropDown();
    });
  }

  converterParaDropDown() {
    this.disciplinas.forEach(disciplina => {
      this.nomeDisciplinas.push({
        label: disciplina.nome,
        value: disciplina.id
      });
    });
  }


  listarDisciplinasSelecionadas(event: any) {
    this.disciplinasSelecionadas = event.value;
  }

  listarDisciplinas() {
    this.aluno.disciplinas = [];
    if (this.disciplinasSelecionadas) {
      this.disciplinasSelecionadas.forEach(diciplinaSelecionada => {
        this.aluno.disciplinas.push(this.disciplinas.find(iten => iten.id === diciplinaSelecionada));
      });
    }
    this.disciplinasSelecionadas = [];
  }

}
