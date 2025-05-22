package Menus;

import Clientes.Pacientes;
import Trabajadores.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Menus.menuPrincipal.*;

public class menuDoctores {

    static void gestionDoctores() {
        System.out.println("Bienvenido al sistema de gestion de Doctores");
        int eleccionUsuario = 0;
        do {
            System.out.println("1.-Imprimir doctores actuales");
            System.out.println("2.-Buscar doctores por especialidad");
            System.out.println("3.-Cambiar especialidad");
            System.out.println("4.-Imprimir horario de consulta de un doctor");
            System.out.println("5.-Asignar cita a un paciente");
            System.out.println("6.-Asignar doctor al paciente");
            System.out.println("7.-Salir");
            eleccionUsuario = getEleccionUsuario(eleccionUsuario,4);
            switch (eleccionUsuario){
                case 1 ->  Doctor.imprimir(Doctor.aLista(Doctor.getDoctores()));
                case 2 ->  buscarEspecialidad();
                case 3 ->  cambiarEspecialidad();
                case 4 ->  horarioDeConsulta();
                case 5 ->  asignarConsulta();
                case 6 -> asignarPaciente();
            }

        }while (eleccionUsuario != 7);


    }

    private static void asignarConsulta() {
        Scanner dia = new Scanner(System.in);
        Scanner hora = new Scanner(System.in);
        Doctor consulta = doctorPorId();
        if(consulta == null)
            return;
        Pacientes paciente = pacientePorId();
        if(paciente == null)
            return;
        consulta.imprimirHorarioConsulta();
        System.out.println("Ingrese el indice del dia que desea su consulta");
        int diaC = dia.nextInt();
        System.out.println("Ingrese el indice de la hora en la que desea su consulta");
        int horaC = hora.nextInt();
        try{
            if(consulta.getHorarioConsulta()[horaC][diaC] == 0) {
                consulta.getHorarioConsulta()[horaC][diaC] = paciente.getId();
                consulta.getPacientesAtendidos().add(paciente);
            }
            else
                System.out.println("El horario de consulta ya esta ocupado");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ha ingresado indices invalidos para su cita");
            return;
        }
        System.out.println("Su cita se ha agendado con exito");

    }

    public static void asignarPaciente(){
        Doctor doctor = doctorPorId();
        if(doctor == null)
            return;
        Pacientes paciente = pacientePorId();
        if(paciente == null)
            return;
        doctor.getPacientesAtendidos().add(paciente);
        System.out.println("El paciente se ha añadido con exito a los registros del doctor");
    }




    private static void horarioDeConsulta() {
        Doctor consultas = doctorPorId();
        if(consultas == null){
            return;
        }
        consultas.imprimirHorarioConsulta();
    }



    private static void cambiarEspecialidad() {
        Doctor modificar = doctorPorId();
        if(modificar == null){
            return;
        }
        Scanner escaner = new Scanner(System.in);
        System.out.println("Cual es la especialidad de este doctor");
        String especialidadNueva = escaner.nextLine();
        modificar.setCargo(especialidadNueva);
        System.out.println("La especialidad del doctor " + modificar.getNombre() + " ha sido cambiada a " +especialidadNueva);
    }

    private static void buscarEspecialidad() {
        Scanner escaner = new Scanner(System.in);
        String especialidadBuscada = escaner.nextLine();
        List<Doctor> especialidad = new ArrayList<>();
        for(Doctor doctor: Doctor.aLista(Doctor.getDoctores())){
            if(doctor.getEspecialidad().equals(especialidadBuscada)){
                especialidad.add(doctor);
            }
        }
        Doctor.imprimir(especialidad);

    }


}
