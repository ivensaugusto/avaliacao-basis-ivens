import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './alunos/listar/listar.component';
import { FormularioComponent } from './alunos/formulario/formulario.component';
import { DisciplinasComponent } from './disciplinas/disciplinas.component';
import { ProfessoresComponent } from './professores/professores.component';


const routes: Routes = [
  { path: 'listaAlunos', component: ListarComponent },
  { path: 'cadastroAlunos', component: FormularioComponent },
  { path: 'cadastroAlunos/:id', component: FormularioComponent },
  { path: 'listaDisciplinas', component: DisciplinasComponent },
  { path: 'listaProfessores', component: ProfessoresComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
