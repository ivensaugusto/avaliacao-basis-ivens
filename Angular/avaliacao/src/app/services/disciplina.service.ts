import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Disciplina } from 'src/app/models/disciplina.model';

@Injectable()
export class DisciplinaService {

  url = 'http://localhost:8080/api/disciplinas';


  constructor(private http: HttpClient) { }


  adicionar(disciplina: Disciplina) {
    return this.http.post<any>(this.url, disciplina);
  }

  alterar(disciplina: Disciplina) {
    return this.http.put<any>(this.url, disciplina);
  }

  consultarDetalhado() {
    return this.http.get<any>(this.url + '/detalhes');
  }

  consultar() {
    return this.http.get<any>(this.url);
  }

  consultarPorId(id: number) {
    return this.http.get<any>(this.url + '/' + id);
  }

  deletar(disciplina: Disciplina) {
    return this.http.delete<any>(this.url + '/' + disciplina.id);
  }


}
