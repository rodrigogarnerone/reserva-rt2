//Source file: C:\\Users\\rodri\\Desktop\\Nueva carpeta\\Usuario.java
package model;

public class Usuario
{
    private String clave;
    private String nombre;
    private Boolean habilitado;

    PersonalCientifico personalCientifico;;

    public Usuario(String nom, String con, PersonalCientifico cientifico) {
        this.nombre = nom;
        this.clave = con;
        this.habilitado = true;
        this.personalCientifico = cientifico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }



    public void habilitar()
    {

    }

    /**
     * @roseuid 5B2722EC0204
     */
    public void inhabilitar()
    {

    }

    /**
     * @roseuid 5B2722FA00FA
     */
    public void modificarPassword()
    {

    }

    public PersonalCientifico getPersonal() {
        return personalCientifico;
    }
}