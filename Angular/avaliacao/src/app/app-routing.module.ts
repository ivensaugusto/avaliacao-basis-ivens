import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './alunos/listar/listar.component';
import { FormularioComponent } from './alunos/formulario/formulario.component';
import { ListarDisciplinaComponent } from './disciplinas/listar/listar-disciplina.component';
import { FormularioDisciplinaComponent } from './disciplinas/formulario/formulario-disciplina.component';
import { ListarProfessorComponent } from './professores/listar/listar-professor.component';
import { FormularioProfessorComponent } from './professores/formulario/formulario-professor.component';


const routes: Routes = [
  { path: 'listaAlunos', component: ListarComponent },
  { path: 'cadastroAlunos', component: FormularioComponent },
  { path: 'cadastroAlunos/:id', component: FormularioComponent },
  { path: 'listaDisciplinas', component: ListarDisciplinaComponent },
  { path: 'cadastroDisciplinas', component: FormularioDisciplinaComponent },
  { path: 'cadastroDisciplinas/:id', component: FormularioDisciplinaComponent },
  { path: 'listaProfessores', component: ListarProfessorComponent },
  { path: 'cadastroProfessores', component: FormularioProfessorComponent },
  { path: 'cadastroProfessores/:id', component: FormularioProfessorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
