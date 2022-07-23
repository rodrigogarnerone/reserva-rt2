package model;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneradorObjetos {

    ArrayList<PersonalCientifico> cientificos;
    Usuario usuario;
    Sesion sesion;
    ArrayList<TipoRecursoTecnologico> tiposRT;
    ArrayList<Modelo> modelos;
    ArrayList<Marca> marcas;
    ArrayList<Estado> estados;
    ArrayList<CambioEstadoRT> cambiosEstadoRT;
    ArrayList<CambioEstadoTurno> cambiosEstadoTurnos;
    ArrayList<Turno> turnos;
    ArrayList<RecursoTecnologico> recursosTecnologicos;
    ArrayList<AsignacionCientificoCI> asignacionesCientificos;
    ArrayList<CentroInvestigacion> centrosInvestigacion;
    InterfazEmail interfazEmail;

    //Cientificos
    public ArrayList<PersonalCientifico> getCientificos() {
        return cientificos;
    }

    public void generarCientificos() {
        cientificos = new ArrayList<>(Arrays.asList(
                new PersonalCientifico("víctormendizabal@gmail.com", "víctormendizabal@unc.edu.ar"),
                new PersonalCientifico("pepitamontserrat@gmail.com", "pepitamontserrat@unc.edu.ar"),
                new PersonalCientifico("clarisalobo@gmail.com", "clarisalobo@unc.edu.ar"),
                new PersonalCientifico("rafaelrocamora@gmail.com", "rafaelrocamora@unc.edu.ar")
        ));
    }
    //Cientificos

    //Usuario
    public Usuario getUsuario() {
        return usuario;
    }

    public void generarUsuario(){
        usuario = new Usuario("Víctor", "victor", cientificos.get(0));
    }
    //Usuario

    //Sesion
    public Sesion getSesion() {
        return sesion;
    }

    public void generarSesion(){
        sesion = new Sesion(usuario);
    }

    //Sesion

    //Tipos de Recursos Tecnologicos
    public ArrayList<TipoRecursoTecnologico> getTiposRT() {
        return tiposRT;
    }

    public void generarTiposRT() {
        tiposRT = new ArrayList<>(Arrays.asList(
                new TipoRecursoTecnologico("Balanza de precision"),
                new TipoRecursoTecnologico("Microscopio de medicion")
        ));
    }
    //Tipos de Recursos Tecnologicos

    //Modelos

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public void generarModelos() {
        modelos = new ArrayList<>(Arrays.asList(
                new Modelo("TXB622L"),
                new Modelo("LBAL-20 / BALP-001"),
                new Modelo("MM-400/800"),
                new Modelo("TZB922A"),
                new Modelo("YZ-002"),
                new Modelo("RM-231")
        ));
    }
    //Modelos

    //Marcas
    public ArrayList<Marca> getMarcas() {
        return marcas;
    }

    public void generarMarcas() {
        marcas = new ArrayList<>(Arrays.asList(
                new Marca(
                        new ArrayList<Modelo>(modelos.subList(0, 3)),
                        "Shidmazu"),
                new Marca(
                        new ArrayList<Modelo>(modelos.subList(3, 6))
                        , "Nikon")
        ));
        for(Marca marca:marcas){
            for(Modelo modelo: marca.getModelos()){
                modelo.setMarca(marca);
            }
        }
    }
    //Marcas

    //Estados
    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void generarEstados() {
        estados = new ArrayList<>(Arrays.asList(
                new Estado("Activo", 0),//RT
                new Estado("Baja técnica", 0),//RT
                new Estado("Baja definitiva", 0),//RT
                new Estado("Disponible", 1),//turno
                new Estado("Reservado", 1)//turno

        ));
    }
    //Estados

    //Cambios de estado de Recursos Tecnologicos
    public ArrayList<CambioEstadoRT> getCambiosEstadoRT() {
        return cambiosEstadoRT;
    }

    public void generarCambiosEstadosRT() {
        cambiosEstadoRT = new ArrayList<>(Arrays.asList(
                new CambioEstadoRT("18/06/2022 11:00:00", estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:01:00", estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:02:00", estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:03:00", estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:04:00", estados.get(0)),
                new CambioEstadoRT("18/06/2022 11:05:00", estados.get(0))
        ));
    }
    //Cambios de estado de Recursos Tecnologicos

    //Cambios de estado de Turnos
    public ArrayList<CambioEstadoTurno> getCambiosEstadoTurnos() {
        return cambiosEstadoTurnos;
    }

    public void generarCambiosEstadosTurnos() {
        cambiosEstadoTurnos = new ArrayList<>(Arrays.asList(
                new CambioEstadoTurno("18/06/2022 11:00:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:00:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:00:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:00:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:01:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:01:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:01:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:01:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:02:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:02:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:02:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:02:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:03:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:03:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:03:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:03:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:04:00", estados.get(3)),
                new CambioEstadoTurno("18/06/2022 11:05:00", estados.get(3))
        ));
    }
    //Cambios de estado de Turnos

    //Turnos
    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void generarTurnos() {
        turnos = new ArrayList<>(Arrays.asList(
                new Turno("18/06/2022 11:00:00", "Martes", "21/06/2022 16:00:00", "21/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(0)))),//rt0
                new Turno("18/06/2022 11:01:00", "Martes", "21/06/2022 16:00:00", "21/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(1)))),//rt1
                new Turno("18/06/2022 11:02:00", "Martes", "21/06/2022 16:00:00", "21/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(2)))),//rt2
                new Turno("18/06/2022 11:03:00", "Martes", "21/06/2022 16:00:00", "21/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(3)))),//rt3
                new Turno("18/06/2022 11:00:00", "Martes", "21/06/2022 18:00:00", "21/06/2022 20:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(4)))),//rt0
                new Turno("18/06/2022 11:01:00", "Martes", "21/06/2022 18:00:00", "21/06/2022 20:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(5)))),//rt1
                new Turno("18/06/2022 11:02:00", "Martes", "21/06/2022 18:00:00", "21/06/2022 20:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(6)))),//rt2
                new Turno("18/06/2022 11:03:00", "Martes", "21/06/2022 18:00:00", "21/06/2022 20:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(7)))),//rt3
                new Turno("18/06/2022 11:00:00", "Miércoles", "22/06/2022 16:00:00", "22/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(8)))),//rt0
                new Turno("18/06/2022 11:01:00", "Miércoles", "22/06/2022 16:00:00", "22/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(9)))),//rt1
                new Turno("18/06/2022 11:02:00", "Miércoles", "22/06/2022 16:00:00", "22/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(10)))),//rt2
                new Turno("18/06/2022 11:03:00", "Miércoles", "22/06/2022 16:00:00", "22/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(11)))),//rt3
                new Turno("18/06/2022 11:00:00", "Miércoles", "22/06/2022 18:00:00", "22/06/2022 20:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(12)))),//rt0
                new Turno("18/06/2022 11:01:00", "Miércoles", "22/06/2022 18:00:00", "22/06/2022 20:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(13)))),//rt1
                new Turno("18/06/2022 11:02:00", "Miércoles", "22/06/2022 18:00:00", "22/06/2022 20:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(14)))),//rt2
                new Turno("18/06/2022 11:03:00", "Miércoles", "22/06/2022 18:00:00", "22/06/2022 20:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(15)))),//rt3
                new Turno("18/06/2022 11:04:00", "Martes", "21/06/2022 16:00:00", "21/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(16)))),//rt4
                new Turno("18/06/2022 11:05:00", "Martes", "21/06/2022 16:00:00", "21/06/2022 18:00:00", new ArrayList<CambioEstadoTurno>(Arrays.asList(cambiosEstadoTurnos.get(17))))//rt5
        ));
    }
    //Turnos

    //Recursos Tecnologicos
    public ArrayList<RecursoTecnologico> getRecursosTecnologicos() {
        return recursosTecnologicos;
    }

    public void generarRTs() {
        recursosTecnologicos = new ArrayList<>(Arrays.asList(
                new RecursoTecnologico(1, tiposRT.get(0), modelos.get(0), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(0))), new ArrayList<Turno>(Arrays.asList(turnos.get(0), turnos.get(4), turnos.get(8), turnos.get(12)))),
                new RecursoTecnologico(2, tiposRT.get(0), modelos.get(1), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(1))), new ArrayList<Turno>(Arrays.asList(turnos.get(1), turnos.get(5), turnos.get(9), turnos.get(13)))),
                new RecursoTecnologico(3, tiposRT.get(1), modelos.get(2), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(2))), new ArrayList<Turno>(Arrays.asList(turnos.get(2), turnos.get(6), turnos.get(10), turnos.get(14)))),
                new RecursoTecnologico(4, tiposRT.get(1), modelos.get(3), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(3))), new ArrayList<Turno>(Arrays.asList(turnos.get(3), turnos.get(7), turnos.get(11), turnos.get(15)))),
                new RecursoTecnologico(5, tiposRT.get(0), modelos.get(4), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(4))), new ArrayList<Turno>(Arrays.asList(turnos.get(16)))),
                new RecursoTecnologico(6, tiposRT.get(1), modelos.get(5), new ArrayList<CambioEstadoRT>(Arrays.asList(cambiosEstadoRT.get(4))), new ArrayList<Turno>(Arrays.asList(turnos.get(17))))
        ));
    }
    //Recursos Tecnologicos

    //Asignaciones de cientificos
    public ArrayList<AsignacionCientificoCI> getAsignacionesCientificos() {
        return asignacionesCientificos;
    }

    public void generarAsignacionesCientificos() {
        asignacionesCientificos = new ArrayList<>(Arrays.asList(
                new AsignacionCientificoCI(cientificos.get(0)),
                new AsignacionCientificoCI(cientificos.get(1)),
                new AsignacionCientificoCI(cientificos.get(2)),
                new AsignacionCientificoCI(cientificos.get(3))
        ));
    }
    //Asignaciones de cientificos

    //Centros de investigacion
    public ArrayList<CentroInvestigacion> getCentrosInvestigacion() {
        return centrosInvestigacion;
    }

    public void generarCentrosInvestigacion() {
        centrosInvestigacion = new ArrayList<>(Arrays.asList(
                new CentroInvestigacion("Centro de Estudios Avanzados UNC",new ArrayList<AsignacionCientificoCI>(asignacionesCientificos.subList(0,2)),new ArrayList<RecursoTecnologico>(recursosTecnologicos.subList(0, 4))),
                new CentroInvestigacion("Centro Láser de Ciencias Moleculares UNC",new ArrayList<AsignacionCientificoCI>(asignacionesCientificos.subList(2,4)),new ArrayList<RecursoTecnologico>(recursosTecnologicos.subList(4, 6)))
        ));
        for(CentroInvestigacion centro:centrosInvestigacion){
            for(RecursoTecnologico recurso: centro.getRecursosTecnologicos()){
                recurso.setCentroInvestigacion(centro);
            }
        }
    }

    //Centros de investigacion

    //Interfaz Email

    public InterfazEmail getInterfazEmail() {
        return interfazEmail;
    }

    public void generarIntefazEmail() {
        interfazEmail = new InterfazEmail();
    }

    private void mostrarDatosParaEjemplo() {
        System.out.println("\n-------------------------------------------------");
        System.out.println("Para este ejemplo se utilizaran los siguientes datos iniciales:");
        System.out.println("Cientifico en sesion sera: "+cientificos.get(0).getCorreoElectronicoPersonal());
        System.out.println("Pertenece al CI: "+centrosInvestigacion.get(0).getNombre());
        System.out.println("La fecha actual sera: Martes 21/06/2022 13:00:00" );
        System.out.println("El CI: "+centrosInvestigacion.get(0).getNombre()+", posee 4 Recursos activos, cada Recurso posee 4 Turnos disponibles y cada Turno posee 1 CambioEstadoTurno inicial");
        System.out.println("-------------------------------------------------");
    }

    //Interfaz Email
    public void generarTodosObjetos(){
        generarCientificos();
        generarUsuario();
        generarSesion();
        generarTiposRT();
        generarModelos();
        generarMarcas();
        generarEstados();
        generarCambiosEstadosRT();
        generarCambiosEstadosTurnos();
        generarTurnos();
        generarRTs();
        generarAsignacionesCientificos();
        generarCentrosInvestigacion();
        generarIntefazEmail();
        mostrarDatosParaEjemplo();
    }


}
