import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ProfessorService } from 'src/app/services/professor.service';
import { Professor } from 'src/app/models/professor.model';


@Component({
  selector: 'app-listar',
  templateUrl: './listar-professor.component.html',
  styleUrls: ['./listar-professor.component.css']
})
export class ListarProfessorComponent implements OnInit {

  professores: Professor[] = [];

  constructor(
    private title: Title,
    private professorService: ProfessorService
  ) { }

  ngOnInit(): void {
    this.title.setTitle('Lista de professores');
    this.atualizar();
  }

  getPesquisar(matricula: string) {
    const professoEncontrado = this.professores.filter((professor: { matricula: string; }) =>
      professor.matricula === matricula
    );
    if (professoEncontrado.length !== 0) {
      this.professores = professoEncontrado;
    } else {
      alert('Professor não encontrado, insira outra matricula.');
    }
    console.log(professoEncontrado);
  }

  atualizar() {
    this.professorService.consultar().subscribe(res => {
      this.professores = res;
    });
    return this.professores;
  }

  alterar(professores: Professor) {
    console.log(professores);
  }

  deletar(professores: Professor) {
    this.professorService.deletar(professores).subscribe();
    console.log('apagado');
    this.atualizar();
  }

}

