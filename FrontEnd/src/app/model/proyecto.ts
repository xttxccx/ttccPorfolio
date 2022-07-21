export class Proyecto {

    id? : number;
    nombreP : string;
    anioP : number;
    descripcionP : string;
    imgP : string;
    linkP : string;

    constructor(
        nombreP : string,
        anioP : number,
        descripcionP : string,
        imgP : string,
        linkP : string) {

            this.nombreP = nombreP;
            this.anioP = anioP;
            this.descripcionP = descripcionP;
            this.imgP = imgP;
            this.linkP = linkP;

    }
}
