import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
// import 'rxjs/add/operator/toPromise';

@Injectable()
export class AlunoService {

  ultimoId = 1;

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

  url = 'http://localhost:8080/api/alunos/detalhes';


  constructor(private http: HttpClient) { }

  adicionar(nom: string) {
    const aluno = {
      nome: nom,
      matricula: '4',
      idade: 23,
      nomeDisciplinas: [
        'historia',
        'geografia'
      ]
    };

    this.alunos.push(aluno);
    console.log(JSON.stringify(this.alunos));
  }

  consultar() {
    return this.http.get<any>('http://localhost:8080/api/alunos/detalhes');
  }

}
