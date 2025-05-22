package EnfermedadesYTratamientos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class AlmacenDeTratamientos {

    private static HashMap<String, Enfermedad> enfermadesConocidas = new HashMap<>();

    public HashMap<String, Enfermedad> getEnfermedadesConocidas() {
        return enfermadesConocidas;
    }

    public static void anadirEnfermedad(Enfermedad nuevaEnfermedad) {
        enfermadesConocidas.put(nuevaEnfermedad.getNombreDeLaEnfermedad(), nuevaEnfermedad);
    }

    private static HashMap<String, Tratamiento> tratamientosConocidos = new HashMap<>();

    public HashMap<String, Tratamiento> getTratamientosConocidos() {
        return tratamientosConocidos;
    }

    public static void anadirTratamiento(Tratamiento nuevoTratamiento) {
        tratamientosConocidos.put(nuevoTratamiento.getNombreDelTratamiento(), nuevoTratamiento);
    }

    public static void nuevoTratamiento() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del tratamiento:");
        String nombreDelTratamiento = scanner.nextLine();

        System.out.println("Ingrese la vía de administración del tratamiento:");
        String viaDeAdministracion = scanner.nextLine();

        Tratamiento nuevoTratamiento = new Tratamiento(nombreDelTratamiento, viaDeAdministracion);

        System.out.println("Ingrese la cantidad:");
        String cantidad = scanner.nextLine();
        nuevoTratamiento.setCantidad(cantidad);

        System.out.println("Ingrese el año de inicio del tratamiento:");
        int anioInicio = scanner.nextInt();
        System.out.println("Ingrese el mes de inicio del tratamiento:");
        int mesInicio = scanner.nextInt();
        System.out.println("Ingrese el día de inicio del tratamiento:");
        int diaInicio = scanner.nextInt();
        nuevoTratamiento.setInicioDeTratamiento(anioInicio, mesInicio, diaInicio);

        System.out.println("Ingrese el año de finalización del tratamiento:");
        int anioFinal = scanner.nextInt();
        System.out.println("Ingrese el mes de finalización del tratamiento:");
        int mesFinal = scanner.nextInt();
        System.out.println("Ingrese el día de finalización del tratamiento:");
        int diaFinal = scanner.nextInt();
        nuevoTratamiento.setFinalDeTratamiento(anioFinal, mesFinal, diaFinal);

        System.out.println("Ingrese la periodicidad del tratamiento en horas:");
        int horaPeriodicidad = scanner.nextInt();
        nuevoTratamiento.setPeriorisidad(horaPeriodicidad);


        anadirTratamiento(nuevoTratamiento);


        System.out.println("Tratamiento creado:");
        System.out.println("Nombre del tratamiento: " + nuevoTratamiento.getNombreDelTratamiento());
        System.out.println("Vía de administración: " + nuevoTratamiento.getViaDeAdministracio());
        System.out.println("Cantidad: " + nuevoTratamiento.getCantidad());
        System.out.println("Inicio del tratamiento: " + nuevoTratamiento.getInicioDeTratamiento());
        System.out.println("Final del tratamiento: " + nuevoTratamiento.getFinalDeTratamiento());
        System.out.println("Periodicidad: " + nuevoTratamiento.getPeriorisidad());
    }

    public static void InicializarTratamientos_Y_Enfermedades() {
        Tratamiento quimioterapia = new Tratamiento("QuimioTerapia", "Intravenosa");
        anadirTratamiento(quimioterapia);
        Tratamiento radioTerapia = new Tratamiento("RadioTerapia", "Por contacto");
        anadirTratamiento(radioTerapia);
        Tratamiento ampicilina = new Tratamiento("Ampicilina", "Inyectado");
        anadirTratamiento(ampicilina);
        Tratamiento amoxicilina = new Tratamiento("Amoxicilina", "Oral");
        anadirTratamiento(amoxicilina);
        Tratamiento terramicina = new Tratamiento("Terramicina", "Topica (Pomada)");
        anadirTratamiento(terramicina);
        Tratamiento paracetamol = new Tratamiento("Paracetamol", "Oral");
        anadirTratamiento(paracetamol);
        Tratamiento ibuprofeno = new Tratamiento("Ibuprofeno", "Oral");
        anadirTratamiento(ibuprofeno);
        Tratamiento vitaminaC = new Tratamiento("VitaminaC", "Oral");
        anadirTratamiento(vitaminaC);
        Tratamiento complejoB = new Tratamiento("ComplejoB", "Inyectado");
        anadirTratamiento(complejoB);
        Tratamiento cloranfenicol = new Tratamiento("Cloranfenicol", "Oftalmico");
        anadirTratamiento(cloranfenicol);
        Tratamiento nasalub = new Tratamiento("Nasalub", "Nasal");
        anadirTratamiento(nasalub);
        Tratamiento fenazona = new Tratamiento("Fenazona", "Otico");
        anadirTratamiento(fenazona);
        Tratamiento clotrimazol = new Tratamiento("Clotrimazol", "Topica (pomada)");
        anadirTratamiento(clotrimazol);
        Tratamiento insulina = new Tratamiento("Insulina", "Inyectable");
        anadirTratamiento(insulina);

        ArrayList<Tratamiento> tratamientosCancerDePiel = new ArrayList<>();
        tratamientosCancerDePiel.add(radioTerapia);
        tratamientosCancerDePiel.add(paracetamol);
        tratamientosCancerDePiel.add(complejoB);
        ArrayList<String> sintomasCancerDePiel = new ArrayList<>();
        sintomasCancerDePiel.add("Vomito");
        sintomasCancerDePiel.add("Ardor");
        sintomasCancerDePiel.add("Sangrado");
        Enfermedad cancerDePiel = new Enfermedad("Cancer de Piel", sintomasCancerDePiel, tratamientosCancerDePiel, 0.94f);
        anadirEnfermedad(cancerDePiel);

        ArrayList<Tratamiento> tratamientoRaspadura = new ArrayList<>();
        tratamientoRaspadura.add(terramicina);
        tratamientoRaspadura.add(ibuprofeno);
        ArrayList<String> sintomasRaspadura = new ArrayList<>();
        sintomasRaspadura.add("Sangrado");
        sintomasRaspadura.add("Inflamacion");
        sintomasRaspadura.add("Posible infeccion bacteriana");
        Enfermedad raspadura = new Enfermedad("Raspadura", sintomasRaspadura, tratamientosCancerDePiel, 0);
        anadirEnfermedad(raspadura);

        ArrayList<Tratamiento> tratamientoDiabetes = new ArrayList<>();
        tratamientoDiabetes.add(insulina);
        ArrayList<String> sintomasDiabetes = new ArrayList<>();
        sintomasDiabetes.add("Sed");
        sintomasDiabetes.add("Coma diabetico");
        sintomasDiabetes.add("Gangrena");
        Enfermedad diabetes = new Enfermedad("Diabetes", sintomasDiabetes, tratamientosCancerDePiel, 0.1f);
        anadirEnfermedad(diabetes);

        ArrayList<Tratamiento> tratamientoCancerDeMama = new ArrayList<>();
        tratamientoCancerDeMama.add(quimioterapia);
        tratamientoCancerDeMama.add(paracetamol);
        ArrayList<String> sintomasCancerDeMama = new ArrayList<>();
        sintomasCancerDeMama.add("Sangrado");
        sintomasCancerDeMama.add("Nauseas");
        sintomasCancerDeMama.add("Dolor intenso");
        Enfermedad cancerDeMama = new Enfermedad("Cancer de Mama", sintomasCancerDeMama, tratamientosCancerDePiel, 0.17f);
        anadirEnfermedad(cancerDeMama);

        ArrayList<Tratamiento> tratamientoInfeccionDeGarganta = new ArrayList<>();
        tratamientoInfeccionDeGarganta.add(amoxicilina);
        tratamientoInfeccionDeGarganta.add(ampicilina);
        ArrayList<String> sintomasInfeccionDeGarganta = new ArrayList<>();
        sintomasInfeccionDeGarganta.add("Dolor de garganta");
        sintomasInfeccionDeGarganta.add("Anginas inflamadas");
        sintomasInfeccionDeGarganta.add("Tos con flema");
        Enfermedad infeccionDeGarganta = new Enfermedad("Infeccion de garganta", sintomasInfeccionDeGarganta, tratamientosCancerDePiel, 0.09f);
        anadirEnfermedad(infeccionDeGarganta);

        ArrayList<Tratamiento> tratamientosInfeccionPorHongos = new ArrayList<>();
        tratamientosInfeccionPorHongos.add(clotrimazol);
        ArrayList<String> sintomasInfeccionPorHongos = new ArrayList<>();
        sintomasInfeccionPorHongos.add("Comezon");
        sintomasInfeccionPorHongos.add("Ardor");
        Enfermedad candidiasis = new Enfermedad("Candidiasis", sintomasInfeccionPorHongos, tratamientosInfeccionPorHongos, 0);
        anadirEnfermedad(candidiasis);

        ArrayList<Tratamiento> tratamientoInfeccionDeOjos = new ArrayList<>();
        tratamientoInfeccionDeOjos.add(cloranfenicol);
        tratamientoInfeccionDeOjos.add(ibuprofeno);
        ArrayList<String> sintomasInfeccionDeOjos = new ArrayList<>();
        sintomasInfeccionDeOjos.add("Ardor");
        sintomasInfeccionDeOjos.add("Enrojecimiento");
        sintomasInfeccionDeOjos.add("Lagrimeo");
        Enfermedad infeccionDeOjos = new Enfermedad("Infeccion de Ojos", sintomasInfeccionDeOjos, tratamientosInfeccionPorHongos, 0.2f);
        anadirEnfermedad(infeccionDeOjos);
    }

    public static void ImprimirTratamientosConocidos() {
        for (HashMap.Entry<String, Tratamiento> tratamiento : tratamientosConocidos.entrySet()) {
            Tratamiento esteTratamiento = tratamiento.getValue();
            System.out.println("Nombre del tratamiento: " + esteTratamiento.getNombreDelTratamiento());
            System.out.println("Via de administracion: " + esteTratamiento.getViaDeAdministracio());
        }
    }

    public static void ImprimirEnfermedadesConocidas() {
        for (HashMap.Entry<String, Enfermedad> enfermedad : enfermadesConocidas.entrySet()) {
            Enfermedad estaEnfermedad = enfermedad.getValue();
            System.out.println("Nombre de la enferedad");
            System.out.println("Lista de sintomas");
            for (int i = 0; i < estaEnfermedad.getListaSintomas().size(); i++) {
                System.out.println(estaEnfermedad.getListaSintomas().get(i));
            }
            System.out.println("Lista de tratamientos");
            for (int i = 0; i < estaEnfermedad.getListaDeTratamientos().size(); i++) {
                System.out.println(estaEnfermedad.getListaDeTratamientos().get(i).getNombreDelTratamiento());
            }
            System.out.println("Tasa de mortalidad: " + estaEnfermedad.getTasaDeMortalidad());
        }
    }

    public static void nuevaEnfermedad() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la nueva enfermedad:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese los sintomas de la enfermedad (separados por comas):");
        String sintomasInput = scanner.nextLine();
        ArrayList<String> listaSintomas = new ArrayList<>();
        for (String sintoma : sintomasInput.split(",")) {
            listaSintomas.add(sintoma.trim());
        }

        System.out.println("Tratamientos disponibles:");
        ArrayList<Tratamiento> listaDeTratamientos = new ArrayList<>();
        for (String tratamientoNombre : tratamientosConocidos.keySet()) {
            System.out.println(tratamientoNombre);
        }

        System.out.println("Ingrese los tratamientos para la enfermedad (separados por comas):");
        String tratamientosInput = scanner.nextLine();
        for (String tratamientoNombre : tratamientosInput.split(",")) {
            Tratamiento tratamiento = tratamientosConocidos.get(tratamientoNombre.trim());
            if (tratamiento != null) {
                listaDeTratamientos.add(tratamiento);
            } else {
                System.out.println("Tratamiento no encontrado: " + tratamientoNombre.trim());
            }
        }

        System.out.println("Ingrese la tasa de mortalidad de la enfermedad:");
        float tasaDeMortalidad = scanner.nextFloat();

        Enfermedad nuevaEnfermedad = new Enfermedad(nombre, listaSintomas, listaDeTratamientos, tasaDeMortalidad);
        anadirEnfermedad(nuevaEnfermedad);

        System.out.println("Enfermedad registrada con exito.");
    }
}

