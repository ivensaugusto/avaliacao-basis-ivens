export class Aluno {

  constructor(
    public id?: number,
    public nome?: string,
    public cpf?: string,
    public matricula?: string,
    public dataNascimento?: Date,
    public disciplinas?: any[]
  ) {
    this.disciplinas = [];
  }
}
