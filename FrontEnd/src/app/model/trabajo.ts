export class Trabajo {
    
    id? : number;
    nombreT : string;
    fechaIT : number;
    fechaFT : number;
    descripcionT : string;
    imgT : string;

    constructor(
        nombreT : string, 
        fechaIT : number, 
        fechaFT : number, 
        descripcionT : string, 
        imgT : string) {

            this.nombreT = nombreT;
            this.fechaIT = fechaIT;
            this.fechaFT = fechaFT;
            this.descripcionT = descripcionT;
            this.imgT = imgT;

    }

}
