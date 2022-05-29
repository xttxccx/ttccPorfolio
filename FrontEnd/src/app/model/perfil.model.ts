export class perfil{
    id? : number;
    nombre: string;
    apodo: string;
    imgPerfil: string;
    banner: string;
    titulo: string;
    descripcion: string;

    constructor(nombre: string, apodo: string, imgPerfil: string, banner: string, titulo: string, descripcion: string) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.imgPerfil = imgPerfil;
        this.banner = banner;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }      
}




/*export interface perfil {
    id : number;
    nombre: string;
    apodo: string;
    imgPerfil: string;
    banner: string;
    titulo: string;
    descripcion: string;
}





public Perfil(Long id, String nombre, String apodo, String imgPerfil, String banner, String titulo, String descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.apodo = apodo;
    this.imgPerfil = imgPerfil;
    this.banner = banner;
    this.titulo = titulo;
    this.descripcion = descripcion;
} */