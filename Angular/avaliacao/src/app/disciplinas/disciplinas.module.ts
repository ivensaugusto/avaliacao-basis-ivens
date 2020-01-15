import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';

import { DisciplinasComponent } from './disciplinas.component';
import { DisciplinaService } from './../services/disciplina.service';

@NgModule({
  declarations: [
    DisciplinasComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule
  ],
  providers: [DisciplinaService]
})
export class DisciplinasModule { }
