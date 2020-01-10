import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { AlunosModule } from './alunos/alunos.module';
import { DisciplinasModule } from './disciplinas/disciplinas.module';
import { ProfessoresModule } from './professores/professores.module';
import { CoreModule } from './core/core.module';
import { AlunoService } from './services/aluno.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AlunosModule,
    DisciplinasModule,
    ProfessoresModule,
    CoreModule
  ],
  providers: [AlunoService],
  bootstrap: [AppComponent]
})

export class AppModule { }
