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
    ) {
    this.alunoService = new AlunoService();
  }

  ngOnInit(): void {
    this.title.setTitle('Pesquisa de alunos');
    this.alunos = this.alunoService.consultar();
  }

}
