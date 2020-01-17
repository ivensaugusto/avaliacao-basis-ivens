import { Aluno } from '../models/aluno.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AlunoService {

  url = 'http://localhost:8080/api/alunos';

  constructor(private http: HttpClient) { }

  adicionar(aluno: Aluno) {
    return this.http.post<any>(this.url, aluno);
  }

  alterar(aluno: Aluno) {
    return this.http.put<any>(this.url, aluno);
  }

  consultar() {
    return this.http.get<any>(this.url + '/detalhes');
  }

  consultarPorId(id: number) {
    return this.http.get<any>(this.url + '/' + id);
  }

  deletar(aluno: Aluno) {
    return this.http.delete<any>(this.url + '/' + aluno.id);
  }


}
