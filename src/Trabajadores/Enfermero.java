package Trabajadores;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Enfermero extends Trabajador {

    private String area;

    public int getId(){
        return this.id;
    }

    public static Hashtable<Integer,Enfermero> enfermeros = new Hashtable<>();

    public Enfermero(String nombre,String genero,int salario,int horarioEntrada,int horarioSalida,String area,int id){
        super(nombre,genero,salario,horarioEntrada,horarioSalida,id);
        this.area = area;
        enfermeros.put(id,this);
    }

    public static Hashtable<Integer,Enfermero> getEnfermeros(){
        return enfermeros;
    }

    public Enfermero(){};

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }



    public static void imprimir(List<Enfermero> enfermeros) {
        System.out.println("Nombre          | Genero | ID      | Cargo     | Seccion | Salario     | Horario");
        System.out.println("------------------------------------------------------------------------");
        for (Enfermero trabajador : enfermeros) {
            System.out.printf("%-15s | %-6s | %-6s | %-9s | %-12s | %-7d | %sAM - %sPM\n",
                    trabajador.getNombre(),
                    trabajador.getGenero(),
                    trabajador.getId(),
                    trabajador.getCargo(),
                    trabajador.getArea(),
                    trabajador.getSalario(),
                    trabajador.getHorario()[0],
                    trabajador.getHorario()[1]);
        }
        System.out.println("------------------------------------------------------------------------");
    }
}
