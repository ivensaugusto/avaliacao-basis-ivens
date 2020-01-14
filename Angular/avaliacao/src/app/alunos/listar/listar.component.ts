import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AlunoService } from 'src/app/services/aluno.service';


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
    this.title.setTitle('Pesquisa de alunos');
    this.alunoService.consultar().subscribe(res => {
      this.alunos = res;
    });
  }

  getPesquisar(matricula: string) {
    this.alunos = this.alunos.filter((aluno: { matricula: any; }) =>
      aluno.matricula === matricula
    );
    console.log(this.alunos);

  }

}
