package Menus;

import Trabajadores.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static Menus.menuPrincipal.getEleccionUsuario;

public class MenuTrabajadores {

    static void gestionTrabajadores() {
        System.out.println("Bienvenido al sistema de gestion de trabajadores, que operacion desea realizar.");
        boolean entradaCorrecta;
        int eleccionUsuario = 0;
        do {
            System.out.println("1.-Registrar un nuevo empleado.");
            System.out.println("2.-Ver registros de empleados actuales");
            System.out.println("3.-Dar de baja a un empleado");
            System.out.println("4.-Generar nomina quincenal");
            System.out.println("5.-Salir");
            eleccionUsuario = getEleccionUsuario(eleccionUsuario, 5);
            switch (eleccionUsuario) {
                case 1 -> registrarEmpleado();
                case 2 -> empleadosActuales();
                case 3 -> darDeBaja();
                case 4 -> generarNomina();
            }
        } while (eleccionUsuario != 5);
    }

    private static void registrarEmpleado() {
        System.out.println("¿Cual es el puesto del nuevo empleado?");
        System.out.println("1.-Auxiliar\n2.-Conserje\n3.-Enfermero\n4.-Doctor");
        int eleccionUsuario = 0;
        eleccionUsuario = getEleccionUsuario(eleccionUsuario,4);
        switch (eleccionUsuario){
            case 1->   nuevoEmpleado(1);
            case 2->   nuevoEmpleado(2);
            case 3->   nuevoEmpleado(3);
            case 4->   nuevoEmpleado(4);
        }
    }

    private static void darDeBaja() {
        System.out.println("¿Cual es el puesto del empleado?");
        System.out.println("1.-Auxiliar\n2.-Conserje\n3.-Enfermero\n4.-Doctor");
        int eleccionUsuario = 0;
        eleccionUsuario = getEleccionUsuario(eleccionUsuario,4);
        switch (eleccionUsuario){
            case 1->   eliminarEmpleado(1);
            case 2->   eliminarEmpleado(2);
            case 3->   eliminarEmpleado(3);
            case 4->   eliminarEmpleado(4);
        }
    }

    private static void eliminarEmpleado(int i){
        System.out.println("Ingrese la id del empleado");
        int idEmpleado = 0;
        idEmpleado = getEleccionUsuario(idEmpleado,9999);
        switch (i){
            case 1->   {
                if(Auxiliar.getAuxiliares().containsKey(idEmpleado)) {
                    Auxiliar.getAuxiliares().remove(idEmpleado);
                    System.out.println("El empleado ha sido borrado de la base de datos");
                }
                else
                    System.out.println("No existe un empleado con ese ID");
            }
            case 2->  {
                if (Conserje.getConserjes().containsKey(idEmpleado)) {
                    Conserje.getConserjes().remove(idEmpleado);
                    System.out.println("El empleado ha sido borrado de la base de datos");
                }
                else
                    System.out.println("No existe un empleado con ese ID");
            }
            case 3-> {
                if (Enfermero.getEnfermeros().containsKey(idEmpleado)) {
                    Enfermero.getEnfermeros().remove(idEmpleado);
                    System.out.println("El empleado ha sido borrado de la base de datos");
                }
                else
                    System.out.println("No existe un empleado con ese ID");
            }
            case 4-> {
                if(Doctor.getDoctores().containsKey(idEmpleado)) {
                    Doctor.getDoctores().remove(idEmpleado);
                    System.out.println("El empleado ha sido borrado de la base de datos");
                }
                else
                    System.out.println("No existe un empleado con ese ID");
            }
        }

    }




    static void nuevoEmpleado(int i) {
        Scanner nom = new Scanner(System.in);
        Scanner gen = new Scanner(System.in);
        Scanner sa = new Scanner(System.in);
        Scanner hor2 = new Scanner(System.in);
        Scanner hor1 = new Scanner(System.in);
        Scanner ID = new Scanner(System.in);
        Scanner atr = new Scanner(System.in);

        System.out.println("Ingrese el nombre del nuevo empleado:");
        String nombre = nom.nextLine();
        System.out.println("Ingrese el genero del nuevo empleado:");
        String genero = gen.nextLine();
        System.out.println("Ingrese el salario del nuevo empleado:");
        int salario = sa.nextInt();
        System.out.println("Ingrese la hora de entrada del nuevo empleado:");
        int horario1 = hor1.nextInt();
        System.out.println("Ingrese la hora de salida del nuevo empleado:");
        int horario2 = hor2.nextInt();
        System.out.println("Ingrese el ID del nuevo empleado:");
        int id = ID.nextInt();
        switch (i) {
            case 1 -> System.out.println("Ingrese el departamento del nuevo empleado: ");
            case 2 -> System.out.println("Ingrese la seccion del nuevo empleado: ");
            case 3 -> System.out.println("Ingrese el area del nuevo empleado: ");
            case 4 -> System.out.println("Ingrese la especialidad del nuevo empleado: ");
        }
        String atributo = atr.nextLine();
        switch (i) {
            case 1 -> {
                Auxiliar nuevoAuxiliar = new Auxiliar(nombre,genero,salario,horario1,horario2,atributo,id);
            }
            case 2 -> {
                Conserje nuevoConserje = new Conserje(nombre,genero,salario,horario1,horario2,atributo,id);
            }
            case 3 -> {
                Enfermero nuevoEnfermero = new Enfermero(nombre,genero,salario,horario1,horario2,atributo,id);
            }
            case 4 -> {
                Doctor nuevoDoctor = new Doctor(nombre,genero,salario,horario1,horario2,atributo,id);
            }
        }

    }

    static void generarNomina() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nomina_mensual.txt"))) {
            double totalNomina = 0;
            totalNomina += escribirNominaPorTipo(writer, Doctor.getDoctores(), "Doctores");
            totalNomina += escribirNominaPorTipo(writer, Conserje.getConserjes(), "Conserjes");
            totalNomina += escribirNominaPorTipo(writer, Auxiliar.getAuxiliares(), "Auxiliares");
            totalNomina += escribirNominaPorTipo(writer, Enfermero.getEnfermeros(), "Enfermeros");
            writer.write("Costo total quincenal: " + totalNomina);
            System.out.println("Nomina generada con exito.");
        } catch (IOException e) {
            System.err.println("Error al generar la nomina: " + e.getMessage());
        }
    }

    private static double escribirNominaPorTipo(BufferedWriter writer, Map<Integer, ? extends Trabajador> trabajadores, String tipo) throws IOException {
        writer.write(tipo + ":\n");
        double totalPorTipo = 0;
        for (Trabajador trabajador : trabajadores.values()) {
            double quincenal = trabajador.getSalario() / 2.0;
            totalPorTipo += quincenal;
            writer.write(trabajador.getNombre() + " - " + quincenal + "\n");
        }
        writer.write("Total para " + tipo + ": " + totalPorTipo + "\n\n");
        return totalPorTipo;
    }


    static void empleadosActuales(){
        Doctor.imprimir(Doctor.aLista(Doctor.getDoctores()));
        Conserje.imprimir(Conserje.aLista(Conserje.getConserjes()));
        Auxiliar.imprimir(Auxiliar.aLista(Auxiliar.getAuxiliares()));
        Enfermero.imprimir(Enfermero.aLista(Enfermero.getEnfermeros()));
    }

}
