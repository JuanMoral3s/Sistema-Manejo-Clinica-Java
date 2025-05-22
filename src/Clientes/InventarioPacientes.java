package Clientes;

import Clientes.Pacientes;

import java.util.Hashtable;
import java.util.Scanner;

public class InventarioPacientes {

    public static Hashtable<Integer, Pacientes> pacientes;

    public InventarioPacientes() {
        pacientes = new Hashtable<>();
        inicializarPacientes();
    }

    private void inicializarPacientes() {
        Pacientes paciente1 = new Pacientes(10, "Miguel", "Maik", "10/05/1980");
        paciente1.asignarHabitacion("101");
        paciente1.addHistorialMed("Consulta inicial: se puso ancioso por tomar pree");
        paciente1.addSegui("Seguimiento semanal: mejora en los síntomas");
        paciente1.addTratamientos("Amoxicilina 500 mg cada 8 horas");
        paciente1.addCitaMedica("Consulta de seguimiento para el próximo martes");
        paciente1.addAlergia("Aspirina");
        paciente1.addConsultaAnterior("Control de presión arterial");

        Pacientes paciente2 = new Pacientes(11, "Juan", "Topo", "15/09/1975");
        paciente2.asignarHabitacion("205");
        paciente2.addHistorialMed("Consulta inicial: un topo lo mordio");
        paciente2.addSegui("Seguimiento mensual: control del dolor");
        paciente2.addTratamientos("Ibuprofeno 400 mg cada 12 horas");
        paciente2.addCitaMedica("Consulta de control para el próximo viernes");
        paciente2.addAlergia("Penicilina");

        pacientes.put(paciente1.getId(), paciente1);
        pacientes.put(paciente2.getId(), paciente2);
    }

    public void agregarPaciente(Pacientes paciente) {
        pacientes.put(paciente.getId(), paciente);
    }

    public Hashtable<Integer, Pacientes> getPacientes() {
        return pacientes;
    }

    public static void mostrarMenuPacientes() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Inventario de Pacientes:");
            System.out.println("1.-Mostrar información de todos los pacientes");
            System.out.println("2.-Seleccionar un paciente");
            System.out.println("3.-Registrar un nuevo paciente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Información de todos los pacientes:");
                    for (Pacientes paciente : pacientes.values()) {  // Corregido para iterar sobre los valores del Hashtable
                        System.out.println(paciente);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el ID del paciente a seleccionar: ");
                    int idPaciente = scanner.nextInt();
                    Pacientes pacienteSeleccionado = pacientes.get(idPaciente);  // Obtener el paciente directamente del Hashtable
                    if (pacienteSeleccionado != null) {
                        pacienteSeleccionado.mostrarMenu();
                    } else {
                        System.out.println("Paciente con ID " + idPaciente + " no encontrado.");
                    }
                    break;
                case 3: Pacientes.nuevoPaciente();
                case 0:
                    System.out.println("Saliendo del menú de Inventario de Pacientes...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }




}

