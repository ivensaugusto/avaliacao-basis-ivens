import { DisciplinaService } from './../services/disciplina.service';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AlunosGridComponent } from './alunos-grid/alunos-grid.component';
import { FormularioComponent } from './formulario/formulario.component';
import { ListarComponent } from './listar/listar.component';

import { DropdownModule } from 'primeng/dropdown';
import { CalendarModule } from 'primeng/calendar';
import { PaginatorModule } from 'primeng/paginator';
import { TableModule } from 'primeng/table';
import { SharedModule } from '../shared/shared.module';
import { DisciplinasModule } from '../disciplinas/disciplinas.module';
import { MultiSelectModule } from 'primeng/multiselect';

import { AlunoService } from '../services/aluno.service';

@NgModule({
  declarations: [
    ListarComponent,
    FormularioComponent,
    AlunosGridComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    FormsModule,
    CalendarModule,
    DropdownModule,
    TableModule,
    PaginatorModule,
    SharedModule,
    DisciplinasModule,
    MultiSelectModule,
    HttpClientModule
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
