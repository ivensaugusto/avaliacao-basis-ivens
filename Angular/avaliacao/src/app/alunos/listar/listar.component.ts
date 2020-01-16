import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AlunoService } from 'src/app/services/aluno.service';
import { Aluno } from '../../models/aluno.model';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})

export class ListarComponent implements OnInit {

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
    const alunoEncontrado = this.alunos.filter((aluno: { matricula: string; }) =>
      aluno.matricula === matricula
    );
    if (alunoEncontrado.length !== 0) {
      this.alunos = alunoEncontrado;
    } else {
      alert('Aluno não encontrado, insira outra matricula.');
    }
    console.log(alunoEncontrado);
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
