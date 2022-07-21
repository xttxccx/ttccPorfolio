export class Formacion {
  
  id?: number;
  nombreF: string;
  fechaIF: number;
  fechaFF: number;
  descripcionF: string;
  imgF: string;

  constructor(
    nombreF: string,
    fechaIF: number,
    fechaFF: number,
    descripcionF: string,
    imgF: string) {

        this.nombreF = nombreF;
        this.fechaIF = fechaIF;
        this.fechaFF = fechaFF;
        this.descripcionF = descripcionF;
        this.imgF = imgF;
  }
}
