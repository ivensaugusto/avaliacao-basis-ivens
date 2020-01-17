import { Component, OnInit } from '@angular/core';
import { DisciplinaService } from './../../services/disciplina.service';
import { AlunoService } from 'src/app/services/aluno.service';
import { SelectItem } from 'primeng/api/selectitem';
import { Professor } from '../../models/professor.model';
import { MultiSelectModule } from 'primeng/multiselect';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { ProfessorService } from 'src/app/services/professor.service';


@Component({
  selector: 'app-formulario',
  templateUrl: './formulario-professor.component.html',
  styleUrls: ['./formulario-professor.component.css']
})
export class FormularioProfessorComponent implements OnInit {

  nomeDisciplinas: SelectItem[] = [];
  disciplinas: any[] = [];
  professor: Professor = new Professor();
  professores: any = [];
  disciplinasSelecionadas: any[];
  disciplinasSelecionadasAlteracao: any[];
  formProfessores: any;

  constructor(
    private title: Title,
    private alunoService: AlunoService,
    private professorService: ProfessorService,
    private disciplinaService: DisciplinaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.title.setTitle('Cadastro de professores');
    this.atualizar();
    this.consultarDisciplinas();
    if (this.route.snapshot.params[`id`]) {
      this.buscarProfessorPorId(this.route.snapshot.params[`id`]);
    }
  }

  salvarProfessor(formProfessores: NgForm) {
    this.professor.nome = formProfessores.value.nome;
    this.professor.matricula = formProfessores.value.matricula;
    this.professor.area = formProfessores.value.area;
    this.professor.dataNascimento = formProfessores.value.dataNascimento;
    this.listarDisciplinas();
    if (this.professor.id) {
      this.professorService.alterar(this.professor).subscribe(a => {
        console.log(a);
      });
    } else {
      this.professorService.adicionar(this.professor).subscribe();
    }
    // console.log(JSON.parse(JSON.stringify(this.professor)));
    formProfessores.reset();
  }

  buscarProfessorPorId(id: number) {
    this.consultarDisciplinas();
    this.professorService.consultarPorId(id).subscribe(professor => {
      this.professor = professor;
      this.professor.dataNascimento = new Date(this.professor.dataNascimento);
      this.disciplinasSelecionadas = this.toDropdown(this.professor.disciplinas);
    });
  }

  atualizar() {
    this.professorService.consultar().subscribe(res => {
      this.professores = res;
    });
  }

  consultarDisciplinas() {
    this.disciplinaService.consultar().subscribe(disciplina => {
      this.disciplinas = disciplina;
      this.converterParaDropDown(this.disciplinas);
    });
  }

  converterParaDropDown(disc) {
    disc.forEach(disciplina => {
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
    this.professor.disciplinas = [];
    if (this.disciplinasSelecionadas) {
      this.disciplinasSelecionadas.forEach(diciplinaSelecionada => {
        this.professor.disciplinas.push(this.disciplinas.find(iten => iten.id === diciplinaSelecionada));
      });
    }
    // this.disciplinasSelecionadas = [];
  }

  nomeProfessor(disc: number) {
    return this.professorService.consultarPorId(disc);
  }

}
