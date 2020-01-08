import { Component, OnInit } from '@angular/core';

import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  // localhost:8080/api/alunos/detalhes -> fazer metodo buscar alunos...

  alunos = [
    {
      nome: 'Ivens', matricula: '1', idade: 33,
      nomeDisciplinas: ['matematica', 'portugues']
    },
    {
      nome: 'Marionildo',
      matricula: '4',
      idade: 23,
      nomeDisciplinas: [
        'historia',
        'geografia'
      ]
    },
    {
      nome: 'Marionildo',
      matricula: '5',
      idade: 23,
      nomeDisciplinas: [
        'historia',
        'geografia'
      ]
    },
    {
      nome: 'runivaldo',
      matricula: '6',
      idade: 23,
      nomeDisciplinas: [
        'historia',
        'geografia'
      ]
    },
    {
      nome: 'ze',
      matricula: '7',
      idade: 23,
      nomeDisciplinas: [
        'historia',
        'geografia'
      ]
    },
    {
      nome: 'ze',
      matricula: '8',
      idade: 23,
      nomeDisciplinas: [
        'costura',
        'alvenaria'
      ]
    },
    {
      nome: 'jodisvaldo',
      matricula: '10',
      idade: 73,
      nomeDisciplinas: [
        'costura',
        'alvenaria'
      ]
    },
    {
      nome: 'parvolino',
      matricula: '20',
      idade: 23,
      nomeDisciplinas: []
    },
    {
      nome: 'parvolino2',
      matricula: '20',
      idade: 23,
      nomeDisciplinas: [
        'costura',
        'alvenaria'
      ]
    },
    {
      nome: 'parvolino2',
      matricula: '20',
      idade: 23,
      nomeDisciplinas: [
        'costura',
        'alvenaria'
      ]
    },
    {
      nome: 'luduigue',
      matricula: '21',
      idade: 23,
      nomeDisciplinas: [
        'Solda',
        'Confeitaria'
      ]
    },
    {
      nome: 'macaco',
      matricula: '24',
      idade: 23,
      nomeDisciplinas: [
        'oec'
      ]
    }
  ];

  constructor(private title: Title) {
  }

  ngOnInit(): void {
    this.title.setTitle('Pesquisa de alunos');
  }

  getTamanhoDisciplinas(lista: Array<string>) {
    return lista.length === 0;
  }

  getAlunos() {
    return this.alunos;
  }

  getPesquisar(matricula) {
    return this.getAlunos().filter(alu2 => {
      return alu2.matricula === matricula;
    });
  }

}
