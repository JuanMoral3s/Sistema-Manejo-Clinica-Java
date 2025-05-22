package Menus;

import Clientes.InventarioPacientes;
import Clientes.Pacientes;
import EnfermedadesYTratamientos.AlmacenDeTratamientos;
import Trabajadores.*;

import java.util.InputMismatchException;
import java.util.Scanner;


import static Clientes.InventarioPacientes.mostrarMenuPacientes;
import static Clientes.InventarioPacientes.pacientes;
import static Menus.MenuTrabajadores.*;
import static Menus.menuDoctores.gestionDoctores;
import static Menus.menuPrincipal.getEleccionUsuario;
import static Menus.menuTratamientosYEnferemdades.gestionTratamientoYEnfermedaes;

public class menuPrincipal {

    public static void iniciarAplicacion(){
        InicializarEmpleados.empleados();
        InventarioPacientes inventarioPacientes = new InventarioPacientes();
        AlmacenDeTratamientos.InicializarTratamientos_Y_Enfermedades();

        System.out.println("Bienvenido al sistema de administracion del hospital Miguel Maik");
        int eleccionUsuario = 0;
        do {
            System.out.println("¿Que operación desea realizar?: ");
            System.out.println("1.-Sistema de registro y gestión de trabajadores.");
            System.out.println("2.-Sistema de gestion del personal medico");
            System.out.println("3.-Sistema de gestion de pacientes");
            System.out.println("4.-Sistema de registro y gestion de enfermedades y tratamientos");
            System.out.println("5.-Salir");

            eleccionUsuario = getEleccionUsuario(eleccionUsuario,5);

            switch (eleccionUsuario){
                case 1 -> gestionTrabajadores();
                case 2 -> gestionDoctores();
                case 3 -> mostrarMenuPacientes();
                case 4 -> gestionTratamientoYEnfermedaes();
                case 5 -> System.out.println("Hasta luego!");
            }
        }while (eleccionUsuario != 5);

    }


    static int getEleccionUsuario(int eleccionUsuario, int rango) {
        boolean entradaCorrecta;
        do{
            try {
                Scanner scanner = new Scanner(System.in);
                eleccionUsuario = scanner.nextInt();
                entradaCorrecta = true;
            }catch (InputMismatchException e){
                System.out.println("Error, ingrese unicamente entradas numericas");
                entradaCorrecta = false;
            }
            if(eleccionUsuario <= 0 && eleccionUsuario > rango){
                System.out.println("Error, opcion invalida.");
            }
        }while (!entradaCorrecta);
        return eleccionUsuario;
    }

    public static Doctor doctorPorId(){
        System.out.println("Ingrese el ID del doctor");
        int doctor = 0;
        doctor = getEleccionUsuario(doctor,1000);
        if(Doctor.getDoctores().containsKey(doctor))
            return Doctor.getDoctores().get(doctor);
        else {
            System.out.println("El ID no se encuentra registrado en el sistema.");
            return null;
        }
    }

    public static Pacientes pacientePorId(){
        System.out.println("Ingrese el ID del paciente");
        int paciente = 0;
        paciente = getEleccionUsuario(paciente,1000);
        if(pacientes.containsKey(paciente))
            return pacientes.get(paciente);
        System.out.println("El ID no se encuentra registrado en el sistema.");
        return null;
    }



}
