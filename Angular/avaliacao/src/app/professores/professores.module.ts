import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfessoresComponent } from './professores.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    ProfessoresComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ]
})
export class ProfessoresModule { }
