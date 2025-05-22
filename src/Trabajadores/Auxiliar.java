package Trabajadores;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Auxiliar extends Trabajador {

    private String departamento;

    public int getId() {
        return this.id;
    }

    public static Hashtable<Integer, Auxiliar> auxiliares = new Hashtable<>();

    public Auxiliar(String nombre, String genero, int salario, int horarioEntrada, int horarioSalida, String departamento, int id) {
        super(nombre, genero, salario, horarioEntrada, horarioSalida, id);
        this.departamento = departamento;
        auxiliares.put(id, this);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setArea(String area) {
        this.departamento = departamento;
    }

    public static Hashtable<Integer,Auxiliar> getAuxiliares(){
        return auxiliares;
    }



    public void datosTrabajador() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Genero: " + this.getGenero());
        System.out.println("Id:" + this.getId());
        System.out.println("Cargo: " + this.getCargo() + " " + this.getDepartamento());
        System.out.println("Salario: " + this.getSalario());
        System.out.println("Horario: " + this.getHorario()[0] + "AM - " + this.getHorario()[1] + "PM");
        for (String tareas : this.getTareas())
            System.out.print(tareas);
        System.out.println();
    }


    public static void imprimir(List<Auxiliar> auxiliar) {
        System.out.println("Nombre          | Genero | ID      | Cargo     | Departamento | Salario     | Horario");
        System.out.println("------------------------------------------------------------------------");
        for (Auxiliar trabajador : auxiliar) {
            System.out.printf("%-15s | %-6s | %-6s | %-9s | %-12s | %-7d | %sAM - %sPM\n",
                    trabajador.getNombre(),
                    trabajador.getGenero(),
                    trabajador.getId(),
                    trabajador.getCargo(),
                    trabajador.getDepartamento(),
                    trabajador.getSalario(),
                    trabajador.getHorario()[0],
                    trabajador.getHorario()[1]);
        }
        System.out.println("------------------------------------------------------------------------");
    }
}