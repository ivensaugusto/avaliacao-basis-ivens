import { Component, Input } from '@angular/core';
import { AlunoService } from 'src/app/services/aluno.service';
import { ListarComponent } from '../listar/listar.component';
import { Aluno } from '../../models/aluno.model';


@Component({
  selector: 'app-alunos-grid',
  templateUrl: './alunos-grid.component.html',
  styleUrls: ['./alunos-grid.component.css']
})
export class AlunosGridComponent {

  @Input() alunos = [];

  constructor(
    private alunoService: AlunoService,
    private listarComponent: ListarComponent
  ) { }

  getTamanhoListaDisciplinas(lista: Array<string>) {
    return lista.length === 0;
  }

  getAlunos() {
    return this.alunos;
  }

  alterar(aluno: Aluno) {
    this.listarComponent.alterar(aluno);
    this.atualizar();
  }

  deletar(aluno: Aluno) {
    this.listarComponent.deletar(aluno);
    this.atualizar();
  }

  atualizar() {
    this.alunos = this.listarComponent.atualizar();
    this.alunoService.consultar().subscribe(res => {
      this.alunos = res;
    });
  }
}
