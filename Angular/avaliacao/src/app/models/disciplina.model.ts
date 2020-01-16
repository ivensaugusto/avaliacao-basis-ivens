import { Professor } from './professor.model';
import { Aluno } from './aluno.model';

export class Disciplina {

  constructor(
    public id?: number,
    public nome?: string,
    public descricao?: string,
    public cargaHoraria?: number,
    public ativa?: number,
    public idProfessor?: number,
    // public alunos?: Aluno[]
  ) {
    // this.alunos = [];
  }
}
