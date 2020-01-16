import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Professor } from '../models/professor.model';

@Injectable()
export class ProfessorService {

  url = 'http://localhost:8080/api/professores';

  constructor(private http: HttpClient) { }

  adicionar(professor: Professor) {
    return this.http.post<any>(this.url, professor);
  }

  consultar() {
    return this.http.get<any>(this.url + '/detalhes');
  }

  consultarPorId(id: number) {
    return this.http.get<any>(this.url + '/' + id);
  }

  deletar(professor: Professor) {
    return this.http.delete<any>(this.url + '/' + professor.id);
  }

}
