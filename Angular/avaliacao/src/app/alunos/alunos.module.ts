import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AlunosGridComponent } from './alunos-grid/alunos-grid.component';
import { FormularioComponent } from './formulario/formulario.component';
import { ListarComponent } from './listar/listar.component';

import { DropdownModule } from 'primeng/dropdown';
import { CalendarModule } from 'primeng/calendar';
import { PaginatorModule } from 'primeng/paginator';
import { TableModule } from 'primeng/table';
import { SharedModule } from '../shared/shared.module';


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
    SharedModule
  ],
  exports: [
    ListarComponent,
    FormularioComponent,
    AlunosGridComponent
  ]
})
export class AlunosModule { }
