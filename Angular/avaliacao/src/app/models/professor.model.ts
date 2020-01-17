import { Disciplina } from './disciplina.model';

export class Professor {

  constructor(
    public id?: number,
    public nome?: string,
    public matricula?: string,
    public area?: string,
    public dataNascimento?: Date,
    public disciplinas?: Disciplina[]
  ) {
    // this.disciplinas = new Disciplina();
  }
}
