import { Component, Input, OnInit } from '@angular/core';
import { DisciplinaService } from './../../services/disciplina.service';
import { ListarDisciplinaComponent } from '../listar/listar-disciplina.component';
import { Disciplina } from '../../models/disciplina.model';

@Component({
  selector: 'app-disciplinas-grid',
  templateUrl: './disciplinas-grid.component.html',
  styleUrls: ['./disciplinas-grid.component.css']
})

export class DisciplinasGridComponent implements OnInit {

  @Input() disciplinas = [];

  constructor(
    private disciplinaService: DisciplinaService,
    private listarComponent: ListarDisciplinaComponent
  ) { }

  ngOnInit() {
    console.log(this.disciplinas);
  }

  getTamanhoListaAlunos(lista: Array<string>) {
    return lista.length === 0;
  }


  getDisciplinas() {
    return this.disciplinas;
  }

  alterar(disciplina: Disciplina) {
    this.listarComponent.alterar(disciplina);
    this.atualizar();
  }

  deletar(disciplina: Disciplina) {
    this.listarComponent.deletar(disciplina);
    this.atualizar();
  }

  atualizar() {
    this.disciplinas = this.listarComponent.atualizar();
    this.disciplinaService.consultar().subscribe(res => {
      this.disciplinas = res;
    });
  }
}
