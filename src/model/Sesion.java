package model;

public class Sesion {
    Usuario activoUsuario;

    public Sesion(Usuario usuario) {
        this.activoUsuario = usuario;
    }

    public String getNombreUsuarioActivo() {
        return this.activoUsuario.getNombre();
    }

    public PersonalCientifico getCientificoEnSesion() {
        return activoUsuario.getPersonal();//Seria getCientifico pero me parece que corresponde getPersonal
    }

    //public PersonalCientifico getCientificoEnSesion() {
    //    return this.activoUsuario.getCientifico();
    //}
}