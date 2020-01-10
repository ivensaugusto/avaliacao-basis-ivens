export class ProfessorService {

  ultimoId = 1;

  professores = [
    {
      nome: 'Matias',
      matricula: '000001',
      nomeDisciplina: 'Quimica'
    }
  ];

  adicionar(nom: string) {
    const professor = {
      nome: nom,
      matricula: '999999',
      nomeDisciplina: 'Quimica'
    };

    this.professores.push(professor);
    console.log(JSON.stringify(this.professores));
  }

  consultar() {
    return this.professores;
  }


}
