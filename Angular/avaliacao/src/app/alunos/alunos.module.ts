import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { MultiSelectModule } from 'primeng/multiselect';
import { DropdownModule } from 'primeng/dropdown';
import { CalendarModule } from 'primeng/calendar';
import { PaginatorModule } from 'primeng/paginator';
import { TableModule } from 'primeng/table';

import { SharedModule } from '../shared/shared.module';
import { DisciplinasModule } from '../disciplinas/disciplinas.module';

import { FormularioComponent } from './formulario/formulario.component';
import { ListarComponent } from './listar/listar.component';
import { AlunosGridComponent } from './alunos-grid/alunos-grid.component';

import { AlunoService } from '../services/aluno.service';
import { DisciplinaService } from './../services/disciplina.service';
import { ProfessorService } from './../services/professor.service';

@NgModule({
  declarations: [
    ListarComponent,
    FormularioComponent,
    AlunosGridComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    RouterModule,
    FormsModule,
    CalendarModule,
    DropdownModule,
    TableModule,
    PaginatorModule,
    DisciplinasModule,
    MultiSelectModule,
    HttpClientModule,
    SharedModule
  ],
  exports: [
    ListarComponent,
    FormularioComponent,
    AlunosGridComponent
  ],
  providers: [
    AlunoService,
    DisciplinaService
  ]
})
export class AlunosModule { }
