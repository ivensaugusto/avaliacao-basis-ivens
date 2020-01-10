import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-alunos-grid',
  templateUrl: './alunos-grid.component.html',
  styleUrls: ['./alunos-grid.component.css']
})
export class AlunosGridComponent {

  @Input() alunos = [];

  constructor() {
  }

  getTamanhoDisciplinas(lista: Array<string>) {
    return lista.length === 0;
  }

  getPesquisar(nome) {
    return this.alunos.filter(aluno => {
      return aluno.nome === nome;
    });
  }

  getAlunos() {
    return this.alunos;
  }

}
