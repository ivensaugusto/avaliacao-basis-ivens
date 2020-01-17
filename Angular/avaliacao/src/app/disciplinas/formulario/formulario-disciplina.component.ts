import { ProfessorService } from '../../services/professor.service';
import { Component, OnInit } from '@angular/core';

import { DisciplinaService } from '../../services/disciplina.service';
import { AlunoService } from '../../services/aluno.service';
import { SelectItem } from 'primeng/api/selectitem';
import { Disciplina } from '../../models/disciplina.model';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario-disciplina.component.html',
  styleUrls: ['./formulario-disciplina.component.css']
})
export class FormularioDisciplinaComponent implements OnInit {

  nomeProfessores: SelectItem[] = [];
  professores: any[] = [];
  disciplina: Disciplina = new Disciplina();
  disciplinas: Disciplina[] = [];
  professoresSelecionados: any;
  professoresSelecionadosAlteracao: any[];
  formDisciplinas: any;
  selectedValues: boolean;
  alunos: any;

  constructor(
    private title: Title,
    private alunoService: AlunoService,
    private professorService: ProfessorService,
    private disciplinaService: DisciplinaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.title.setTitle('Cadastro de disciplinas');
    this.consultarProfessores();
    this.atualizar();
    if (this.route.snapshot.params[`id`]) {
      this.buscarDisciplinaPorId(this.route.snapshot.params[`id`]);
    }
    this.selectedValues = true;
  }

  teste(item: any) {
    console.log(item);
  }

  salvarDisciplina(formDisciplinas: NgForm) {
    this.disciplina.nome = formDisciplinas.value.nome;
    this.disciplina.descricao = formDisciplinas.value.descricao;
    this.disciplina.cargaHoraria = formDisciplinas.value.cargaHoraria;
    this.disciplina.ativa = formDisciplinas.value.ativa ? 1 : 0;
    this.disciplina.idProfessor = formDisciplinas.value.professores;
    if (this.disciplina.id) {
      this.disciplinaService.alterar(this.disciplina).subscribe();
    } else {
      this.disciplinaService.adicionar(this.disciplina).subscribe();
    }
    formDisciplinas.reset();
    this.selectedValues = true;
  }

  buscarDisciplinaPorId(id: number) {
    this.disciplinaService.consultarPorId(id).subscribe(disciplina => {
      this.disciplina = disciplina;
      this.professoresSelecionados = this.disciplina.idProfessor;
    });
  }

  atualizar() {
    this.disciplinaService.consultarDetalhado().subscribe(res => {
      this.disciplinas = res;
    });
  }

  consultarProfessores() {
    this.professorService.consultar().subscribe(professor => {
      this.professores = professor;
      this.converterParaDropDown();
    });
  }

  converterParaDropDown() {
    this.professores.forEach(professor => {
      this.nomeProfessores.push({
        label: professor.nome,
        value: professor.id
      });
    });
  }

  toDropdown(itens: any[]) {
    return itens.map(item => item.id);
  }

  listarProfessoresSelecionados(event: any) {
    this.professoresSelecionados = event.value;
  }

}

