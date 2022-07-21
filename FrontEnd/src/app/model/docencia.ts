export class Docencia {

    id? : number;
    nombreD : string;
    fechaID : number;
    fechaFD : number;
    descripcionD : string;
    imgD : string;

    constructor(
        nombreD : string, 
        fechaID : number, 
        fechaFD : number, 
        descripcionD : string, 
        imgD : string) {

            this.nombreD = nombreD;
            this.fechaID = fechaID;
            this.fechaFD = fechaFD;
            this.descripcionD = descripcionD;
            this.imgD = imgD;

    }

}
