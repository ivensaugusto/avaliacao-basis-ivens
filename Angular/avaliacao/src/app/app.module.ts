import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';

import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { ListarComponent } from './alunos/listar/listar.component';
import { TooltipModule } from 'primeng/tooltip';
import { PaginatorModule } from 'primeng/paginator';
import { DisciplinasComponent } from './disciplinas/disciplinas.component';
import { ProfessoresComponent } from './professores/professores.component';
import { FormComponent } from './Alunos/form/form.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ListarComponent,
    DisciplinasComponent,
    ProfessoresComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    TableModule,
    ButtonModule,
    TooltipModule,
    PaginatorModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
