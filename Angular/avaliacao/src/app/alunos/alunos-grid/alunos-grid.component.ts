import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-alunos-grid',
  templateUrl: './alunos-grid.component.html',
  styleUrls: ['./alunos-grid.component.css']
})
export class AlunosGridComponent {

  @Input() alunos = [];


  getTamanhoDisciplinas(lista: Array<string>) {
    return lista.length === 0;
  }

  getAlunos() {
    /// chamar servico
    return this.alunos;
  }

  getPesquisar(matricula) {
    return this.getAlunos().filter(alu2 => {
      return alu2.matricula === matricula;
    });
  }

}
