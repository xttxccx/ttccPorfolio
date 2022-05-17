export class docencia {
    id? : number;
    anio: String;
    empleo: String;
    descripcion: String;
    img: String;

    constructor(anio: String, empleo: String, descripcion: String, img: String) {
        this.anio = anio;
        this.empleo = empleo;
        this.descripcion = descripcion;
        this.img = img;

    }

}
