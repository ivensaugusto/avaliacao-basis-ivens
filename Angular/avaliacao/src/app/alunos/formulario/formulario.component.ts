import { Component, OnInit } from '@angular/core';

import { DisciplinaService } from './../../services/disciplina.service';
import { AlunoService } from 'src/app/services/aluno.service';
import { SelectItem } from 'primeng/api/selectitem';
import { Aluno } from '../../models/aluno.model';
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
  disciplinasSelecionadasAlteracao: any[];
  formAlunos: any;

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
    if (this.route.snapshot.params[`id`]) {
      this.buscarAlunoPorId(this.route.snapshot.params[`id`]);
    }
  }

  salvarAluno(formAlunos: NgForm) {
    this.aluno.nome = formAlunos.value.nome;
    this.aluno.cpf = formAlunos.value.CPF;
    this.aluno.matricula = formAlunos.value.matricula;
    this.aluno.dataNascimento = formAlunos.value.dataNascimento;
    this.listarDisciplinas();
    const res = this.alunoService.adicionar(this.aluno).subscribe();
    if (res) {
      alert('Gravado com sucesso.');
      console.log(res);
    }
    formAlunos.reset();
  }

  buscarAlunoPorId(id: number) {
    this.consultarDisciplinas();
    this.alunoService.consultarPorId(id).subscribe(aluno => {
      this.aluno = aluno;
      this.aluno.dataNascimento = new Date(this.aluno.dataNascimento);
      this.disciplinasSelecionadas = this.toDropdown(this.aluno.disciplinas);
    });
  }

  atualizar() {
    this.alunoService.consultar().subscribe(res => {
      this.alunos = res;
    });
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

  toDropdown(itens: any[]) {
    return itens.map(item => item.id);
  }

  listarDisciplinasSelecionadas(event: any) {
    this.disciplinasSelecionadas = event.value;
    // console.log('event ' + event.value);
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
