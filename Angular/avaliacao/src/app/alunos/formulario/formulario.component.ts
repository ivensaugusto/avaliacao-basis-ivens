import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  diciplinas = [
    {
      nome: 'matematica',
      cargaHoraria: 60,
      nomeProfessor: 'ze'
    },
    {
      nome: 'portugues',
      cargaHoraria: 60,
      nomeProfessor: 'paulo'
    },
    {
      nome: 'historia',
      cargaHoraria: 30,
      nomeProfessor: 'zacarias'
    },
    {
      nome: 'geografia',
      cargaHoraria: 30,
      nomeProfessor: 'fudencio'
    },
    {
      nome: 'historia da pemba',
      cargaHoraria: 30,
      nomeProfessor: 'djambé'
    },
    {
      nome: 'costura',
      cargaHoraria: 30,
      nomeProfessor: 'marilenia'
    },
    {
      nome: 'alvenaria',
      cargaHoraria: 30,
      nomeProfessor: 'jeremias'
    },
    {
      nome: 'Solda',
      cargaHoraria: 30,
      nomeProfessor: 'Marcio'
    },
    {
      nome: 'Confeitaria',
      cargaHoraria: 30,
      nomeProfessor: 'Simão'
    },
    {
      nome: 'oec',
      cargaHoraria: 20,
      nomeProfessor: 'Tonhão'
    }
  ];
  nomeDisciplinas: { label: string; value: string; }[] = [
    { label: 'matematica', value: 'matematica' },
    { label: 'portugues', value: 'portugues' },
    { label: 'historia', value: 'historia' }
  ];

  constructor() { }

  ngOnInit() {
  }

}
