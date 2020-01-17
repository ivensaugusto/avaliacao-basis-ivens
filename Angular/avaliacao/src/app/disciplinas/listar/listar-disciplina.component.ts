import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { DisciplinaService } from '../../services/disciplina.service';
import { Disciplina } from '../../models/disciplina.model';

@Component({
  selector: 'app-listar',
  templateUrl: './listar-disciplina.component.html',
  styleUrls: ['./listar-disciplina.component.css']
})

export class ListarDisciplinaComponent implements OnInit {

  disciplinas: any = [];

  constructor(
    private title: Title,
    private disciplinaService: DisciplinaService
  ) { }

  ngOnInit(): void {
    this.title.setTitle('Lista de disciplinas');
    this.atualizar();
  }

  getPesquisar(nome: string) {
    const disciplinaEncontrada = this.disciplinas.filter((disciplina: { nome: string; }) =>
      disciplina.nome === nome
    );
    if (disciplinaEncontrada.length !== 0) {
      this.disciplinas = disciplinaEncontrada;
    } else {
      alert('Disciplina não encontrada, insira outro nome.');
    }
    console.log(disciplinaEncontrada);
  }

  atualizar() {
    this.disciplinaService.consultarDetalhado().subscribe(res => {
      this.disciplinas = res;
      console.log(this.disciplinas);

    });
    return this.disciplinas;
  }

  alterar(disciplinas: Disciplina) {
    console.log(disciplinas);
  }

  deletar(disciplinas: Disciplina) {
    const resp = this.disciplinaService.deletar(disciplinas).subscribe();
    console.log('apagado');
    console.log(resp);
    this.atualizar();
  }

}


