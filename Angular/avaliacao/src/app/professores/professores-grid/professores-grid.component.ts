import { Component, Input } from '@angular/core';
import { ProfessorService } from 'src/app/services/professor.service';
import { ListarProfessorComponent } from '../listar/listar-professor.component';
import { Professor } from '../../models/professor.model';

@Component({
  selector: 'app-professores-grid',
  templateUrl: './professores-grid.component.html',
  styleUrls: ['./professores-grid.component.css']
})
export class ProfessoresGridComponent {

  @Input() professores = [];

  constructor(
    private professorService: ProfessorService,
    private listarProfessorComponent: ListarProfessorComponent
  ) { }

  getTamanhoListaDisciplinas(lista: Array<string>) {
    return lista.length === 0;
  }

  getProfessores() {
    return this.professores;
  }

  alterar(professor: Professor) {
    this.listarComponent.alterar(professor);
    this.atualizar();
  }

  deletar(professor: Professor) {
    this.listarComponent.deletar(professor);
    this.atualizar();
  }

  atualizar() {
    this.professores = this.listarComponent.atualizar();
    this.professoreservice.consultar().subscribe(res => {
      this.professores = res;
    });
  }
}
