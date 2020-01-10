import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DisciplinasComponent } from './disciplinas.component';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    DisciplinasComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ]
})
export class DisciplinasModule { }
