import { Component, OnInit } from '@angular/core';

import { DisciplinaService } from './../../services/disciplina.service';
import { AlunoService } from 'src/app/services/aluno.service';
import { SelectItem } from 'primeng/api/selectitem';
import { Aluno } from '../aluno.model';
import { MultiSelectModule } from 'primeng/multiselect';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})

export class FormularioComponent implements OnInit {

  nomeDisciplinas: SelectItem[] = [];
  disciplinas: any[] = [];
  aluno: Aluno = new Aluno();
  disciplinasSelecionadas: any[];

  constructor(
    private alunoService: AlunoService,
    private disciplinaService: DisciplinaService
  ) { }

  ngOnInit(): void {
    this.consultarDisciplinas();
  }

  salvarAluno(formAlunos: NgForm) {
    this.aluno.nome = formAlunos.value.nome;
    this.aluno.cpf = formAlunos.value.CPF;
    this.aluno.matricula = formAlunos.value.matricula;
    this.aluno.dataNascimento = formAlunos.value.dataNascimento;
    this.listarDisciplinas();
    this.alunoService.adicionar(this.toJson(this.aluno)).subscribe();
    console.log(JSON.parse(JSON.stringify(this.aluno)));
    formAlunos.reset();
  }

  listarDisciplinasSelecionadas(event: any) {
    this.disciplinasSelecionadas = event.value;
  }

  listarDisciplinas() {
    this.aluno.disciplinas = [];
    this.disciplinasSelecionadas.forEach(diciplinaSelecionada => {
      const disciplinaObj = this.disciplinas.find(iten => iten.id === diciplinaSelecionada);
      if (disciplinaObj) {
        this.aluno.disciplinas.push(disciplinaObj);
      }
    });
    this.disciplinasSelecionadas = [];
  }

  toJson(obj: any) {
    return JSON.parse(JSON.stringify(obj));
  }

  consultarAluno() {
    return this.alunoService.consultar();
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

}
