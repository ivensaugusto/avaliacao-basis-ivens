import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AlunoService } from 'src/app/services/aluno.service';
import { Aluno } from '../aluno.model';


@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})

export class ListarComponent implements OnInit {
  // localhost:8080/api/alunos/detalhes -> fazer metodo buscar alunos...

  alunos: any = [];

  constructor(
    private title: Title,
    private alunoService: AlunoService
  ) { }

  ngOnInit(): void {
    this.title.setTitle('Lista de alunos');
    this.atualizar();
  }

  getPesquisar(matricula: string) {
    this.alunos = this.alunos.filter((aluno: { matricula: string; }) =>
      aluno.matricula === matricula
    );
    console.log(this.alunos);
  }

  atualizar() {
    this.alunoService.consultar().subscribe(res => {
      this.alunos = res;
    });
    return this.alunos;
  }

  alterar(alunos: Aluno) {
    console.log(alunos);
  }

  deletar(alunos: Aluno) {
    const resp = this.alunoService.deletar(alunos).subscribe();
    console.log('apagado');
    console.log(resp);
    this.atualizar();
  }

}
