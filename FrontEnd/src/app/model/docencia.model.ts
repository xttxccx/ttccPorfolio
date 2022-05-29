export class docencia {
    idDoc? : number;
    tituloDoc: String;
    fechaIDoc: number;
    fechaFDoc: number;
    descDoc: String;
    imgDoc: String;

    constructor(tituloDoc: String, fechaIDoc: number, fechaFDoc: number, descDoc: String, imgDoc: String) {
        this.tituloDoc = tituloDoc;
        this.fechaIDoc = fechaIDoc;
        this.fechaFDoc = fechaFDoc;
        this.descDoc = descDoc;
        this.imgDoc = imgDoc;
    }

}
