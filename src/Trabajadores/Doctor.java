package Trabajadores;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import Clientes.Pacientes;


public class Doctor extends Trabajador {

    String especialidad;
    List<Pacientes> pacientesAtendidos = new ArrayList<>();

    int[][] horarioConsulta = new int[horasTrabajadas()][6];
    public static Hashtable<Integer,Doctor> doctores = new Hashtable<>();

    public int getId(){
        return this.id;
    }

    public int horasTrabajadas(){
        int horas = 0;
        horas = (12 - this.getHorario()[0]) + this.getHorario()[1];
        return horas;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public int[][] getHorarioConsulta(){
        return this.horarioConsulta;
    }

    public void setHorarioConsulta(int cambio){

    }


    private void inicializarHorarioConsulta() {
        for (int i = 0; i < horarioConsulta.length; i++) {
            for (int j = 0; j < horarioConsulta[i].length; j++) {
                horarioConsulta[i][j] = 1; // Asumiendo que 1 significa que la hora está disponible para consulta
            }
        }
    }

    public void imprimirHorarioConsulta() {
        System.out.println("Horario de Consulta del Doctor:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        System.out.printf("   %-15s%-15s%-15s%-15s%-15s%-15s%-15s%n", "Hora", "Lunes[0]", "Martes[1]", "Miércoles[2]", "Jueves[3]", "Viernes[4]", "Sábado[5]");
        for (int i = 0; i < horarioConsulta.length; i++) {
            LocalTime horaActual = LocalTime.of(horario[0] + i, 0);
            System.out.printf("[%d]%-15s", i,horaActual.format(formatter));

            for (int j = 0; j < horarioConsulta[i].length; j++) {
                System.out.printf("%-15s", (horarioConsulta[i][j] == 0 ? "Disponible" : horarioConsulta[i][j] == 1? "No disponible" : horarioConsulta[i][j]));
            }
            System.out.println();
        }
    }


    public Doctor(String nombre,String genero,int salario,int horarioEntrada,int horarioSalida,String especialidad,int id){
        super(nombre,genero,salario,horarioEntrada,horarioSalida,id);
        this.especialidad = especialidad;
        doctores.put(id,this);
    }

    public List<Pacientes> getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void listaPacientes(){
        for(Pacientes pacientes: this.getPacientesAtendidos()){
            System.out.println(pacientes.toString());
        }
    }

    public void anotarPaciente(Pacientes paciente){
        this.pacientesAtendidos.add(paciente);
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public void datosTrabajador(){
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Genero: " +this.getGenero());
        System.out.println("Id:" + this.getId());
        System.out.println("Cargo: " + this.getCargo());
        System.out.println("Especialidad: " + this.getEspecialidad());
        System.out.println("Salario: "+ this.getSalario());
        System.out.println("Horario: "+ this.getHorario()[0]+ "AM - " + this.getHorario()[1]+"PM");
        for(String tareas: this.getTareas())
            System.out.print(tareas);
        System.out.println();
    }




    public static void imprimir(List<Doctor> doctores) {
        System.out.println("Nombre          | Genero | ID      | Cargo     | Especialidad | Salario     | Horario");
        System.out.println("------------------------------------------------------------------------");
        for (Doctor trabajador : doctores) {
            System.out.printf("%-15s | %-6s | %-6s | %-9s | %-12s | %-7d | %sAM - %sPM\n",
                    trabajador.getNombre(),
                    trabajador.getGenero(),
                    trabajador.getId(),
                    trabajador.getCargo(),
                    trabajador.getEspecialidad(),
                    trabajador.getSalario(),
                    trabajador.getHorario()[0],
                    trabajador.getHorario()[1]);
        }
        System.out.println("------------------------------------------------------------------------");
    }




    public static Hashtable<Integer, Doctor> getDoctores() {
        return doctores;
    }
}
