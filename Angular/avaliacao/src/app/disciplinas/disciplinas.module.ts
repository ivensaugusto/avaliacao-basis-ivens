import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { MultiSelectModule } from 'primeng/multiselect';
import { DropdownModule } from 'primeng/dropdown';
import { CheckboxModule } from 'primeng/checkbox';
import { PaginatorModule } from 'primeng/paginator';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';

import { SharedModule } from '../shared/shared.module';

import { FormularioDisciplinaComponent } from './formulario/formulario-disciplina.component';
import { ListarDisciplinaComponent } from './listar/listar-disciplina.component';
import { DisciplinasGridComponent } from './disciplinas-grid/disciplinas-grid.component';

import { DisciplinaService } from './../services/disciplina.service';
import { AlunoService } from '../services/aluno.service';
import { ProfessorService } from './../services/professor.service';

@NgModule({
  declarations: [
    DisciplinasGridComponent,
    ListarDisciplinaComponent,
    FormularioDisciplinaComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    RouterModule,
    FormsModule,
    DropdownModule,
    CheckboxModule,
    TableModule,
    PaginatorModule,
    DropdownModule,
    ButtonModule,
    MultiSelectModule,
    HttpClientModule,
    SharedModule
  ],
  exports: [
    ListarDisciplinaComponent,
    FormularioDisciplinaComponent,
    DisciplinasGridComponent
  ],
  providers: [
    AlunoService,
    DisciplinaService,
    ProfessorService
  ]
})
export class DisciplinasModule { }
