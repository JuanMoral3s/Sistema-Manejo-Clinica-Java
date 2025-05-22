package Trabajadores;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Conserje extends Trabajador {

    private String seccion;

    public static Hashtable<Integer,Conserje> conserjes = new Hashtable<>();

    public Conserje(String nombre, String genero, int salario, int horarioEntrada, int horarioSalida, String seccion,int id) {
        super(nombre, genero, salario, horarioEntrada, horarioSalida,id);
        this.seccion = seccion;
        conserjes.put(id,this);
    }


    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String area) {
        this.seccion = seccion;
    }

    public int getId(){
        return this.id;
    }

    public void datosTrabajador() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Genero: " + this.getGenero());
        System.out.println("Id:" + this.getId());
        System.out.println("Cargo: " + this.getCargo() + " sección " + this.getSeccion());
        System.out.println("Salario: " + this.getSalario());
        System.out.println("Horario: " + this.getHorario()[0] + "AM - " + this.getHorario()[1] + "PM");
        for (String tareas : this.getTareas())
            System.out.print(tareas);
        System.out.println();
    }

    public static Hashtable<Integer,Conserje> getConserjes() {
        return conserjes;
    }



    public static void imprimir(List<Conserje> conserjes) {
        System.out.println("Nombre          | Genero | ID      | Cargo     | Seccion | Salario     | Horario");
        System.out.println("------------------------------------------------------------------------");
        for (Conserje trabajador : conserjes) {
            System.out.printf("%-15s | %-6s | %-6s | %-9s | %-12s | %-7d | %sAM - %sPM\n",
                    trabajador.getNombre(),
                    trabajador.getGenero(),
                    trabajador.getId(),
                    trabajador.getCargo(),
                    trabajador.getSeccion(),
                    trabajador.getSalario(),
                    trabajador.getHorario()[0],
                    trabajador.getHorario()[1]);
        }
        System.out.println("------------------------------------------------------------------------");
    }

}
