export class perfil{
    id?: number;
    nombre: String;
    apodo: String;
    img: String;

    constructor(nombre:String, apodo:String, img:String){
        this.nombre = nombre;
        this.apodo = apodo;
        this.img = img;
    }
}