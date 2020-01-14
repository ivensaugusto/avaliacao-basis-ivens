import { Component, Input } from '@angular/core';
import { AlunoService } from 'src/app/services/aluno.service';


@Component({
  selector: 'app-alunos-grid',
  templateUrl: './alunos-grid.component.html',
  styleUrls: ['./alunos-grid.component.css']
})
export class AlunosGridComponent {

  @Input() alunos = [];

  constructor(private alunoService: AlunoService) { }

  getTamanhoDisciplinas(lista: Array<string>) {
    return lista.length === 0;
  }

  getAlunos() {
    return this.alunos;
  }

  alterar(alunos) {
    console.log(alunos);

  }

  deletar(alunos) {
    console.log(alunos);
  }

}
