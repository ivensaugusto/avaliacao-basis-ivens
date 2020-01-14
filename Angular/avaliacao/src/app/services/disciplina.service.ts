import { Observable } from 'rxjs/internal/Observable';
import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable()
export class DisciplinaService {

  ultimoId = 1;

  disciplinas = [
    {
      nome: 'matematica',
      cargaHoraria: 60,
      nomeProfessor: 'ze'
    },
    {
      nome: 'portugues',
      cargaHoraria: 60,
      nomeProfessor: 'paulo'
    },
    {
      nome: 'historia',
      cargaHoraria: 30,
      nomeProfessor: 'zacarias'
    },
    {
      nome: 'geografia',
      cargaHoraria: 30,
      nomeProfessor: 'fudencio'
    },
    {
      nome: 'historia da pemba',
      cargaHoraria: 30,
      nomeProfessor: 'djambé'
    },
    {
      nome: 'costura',
      cargaHoraria: 30,
      nomeProfessor: 'marilenia'
    },
    {
      nome: 'alvenaria',
      cargaHoraria: 30,
      nomeProfessor: 'jeremias'
    },
    {
      nome: 'Solda',
      cargaHoraria: 30,
      nomeProfessor: 'Marcio'
    },
    {
      nome: 'Confeitaria',
      cargaHoraria: 30,
      nomeProfessor: 'Simão'
    },
    {
      nome: 'oec',
      cargaHoraria: 20,
      nomeProfessor: 'Tonhão'
    }
  ];

  url = 'http://localhost:8080/api/disciplinas';


  constructor(private http: HttpClient) { }


  adicionar(nom: string) {
    const disciplina = {
      nome: nom,
      cargaHoraria: 60,
      nomeProfessor: 'ze'
    };

    this.disciplinas.push(disciplina);
    console.log(JSON.stringify(this.disciplinas));
  }

  consultar() {
    return this.http.get<any>('http://localhost:8080/api/disciplinas');
  }

}
