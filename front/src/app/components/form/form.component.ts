import { Component, OnInit } from '@angular/core';
import { Auto } from 'src/app/models/interfaces';
import { AutoService } from 'src/app/services/auto.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  autos: any = [];

  formAuto: Auto = {
    id: NaN,
    marca: '',
    modelo: '',
    fecha_ingreso: '',
  }

  constructor(private autoService: AutoService) { }

  limpiarFormulario() {
    this.formAuto.marca = "";
    this.formAuto.modelo = "";
  }

  getAutos() {
    this.autoService.getAll().subscribe(auto => this.autos = auto);
  }

  async eliminarAuto(id: number) {
    let respuesta = confirm('Se eliminara el Auto con ' + `${id}` + ' ' + 'seleccionado.');
    if (respuesta) {
      await this.autoService.deleteAuto(id).subscribe();
      this.getAutos();
    } else {
      alert("Se cancelo la accion Eliminar el auto con id: " + `${id}`);
    }
  }
  async editarAuto(auto : Auto){

  }

  async onSubmit() {
    await this.autoService.saveAuto(this.formAuto);
    this.getAutos();
    this.limpiarFormulario();
  }

  ngOnInit() {
    this.getAutos();
  }

}
