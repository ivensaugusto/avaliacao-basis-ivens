import { CalendarModule } from 'primeng/calendar';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { DropdownModule } from 'primeng/dropdown';
import { PaginatorModule } from 'primeng/paginator';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { MultiSelectModule } from 'primeng/multiselect';
import { ProfessorService } from '../services/professor.service';

import { SharedModule } from '../shared/shared.module';

import { ProfessoresGridComponent } from './professores-grid/professores-grid.component';
import { FormularioProfessorComponent } from './formulario/formulario-professor.component';
import { ListarProfessorComponent } from './listar/listar-professor.component';
import { AlunoService } from '../services/aluno.service';
import { DisciplinaService } from '../services/disciplina.service';


@NgModule({
  declarations: [
    ProfessoresGridComponent,
    FormularioProfessorComponent,
    ListarProfessorComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MultiSelectModule,
    DropdownModule,
    CalendarModule,
    PaginatorModule,
    TableModule,
    ButtonModule,
    SharedModule
  ],
  exports: [
    ProfessoresGridComponent,
    FormularioProfessorComponent,
    ListarProfessorComponent
  ],
  providers: [
    AlunoService,
    DisciplinaService,
    ProfessorService
  ]
})
export class ProfessoresModule { }
