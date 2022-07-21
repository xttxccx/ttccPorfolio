export class Perfil {

    id?: number;
    nombre: string;
    apodo: string;
    imgPerfil: string;
    banner: string;
    titulo: string;
    descripcion: string;

    constructor(
        nombre: string,
        apodo: string,
        imgPerfil: string,
        banner: string,
        titulo: string,
        descripcion: string) {

            this.nombre = nombre;
            this.apodo = apodo;
            this.imgPerfil = imgPerfil;
            this.banner = banner;
            this.titulo = titulo;
            this.descripcion = descripcion;

  }
}
