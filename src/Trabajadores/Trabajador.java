package Trabajadores;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public abstract class Trabajador {

    private String nombre;
    private String genero;
    private String cargo = this.getClass().getSimpleName();
    private int salario;
    int[] horario = new int[2];
    private List<String> tareas = new ArrayList<String>();
    protected int id;

    public Trabajador() {
    }

    ;

    public Trabajador(String nombre, String genero, int salario, int horarioEntrada, int horarioSalida, int id) {
        this.nombre = nombre;
        this.genero = genero;
        this.salario = salario;
        this.horario[0] = horarioEntrada;
        this.horario[1] = horarioSalida;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int[] getHorario() {
        return horario;
    }

    public void setHorario(int[] horario) {
        this.horario = horario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<String> getTareas() {
        return tareas;
    }

    public void setTareas(List<String> tareas) {
        this.tareas = tareas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public static <T extends Trabajador> List<T> aLista(Hashtable<Integer, T> trabajador) {
        return new ArrayList<>(trabajador.values());
    }


    public void datosTrabajador(){
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Genero: " +this.getGenero());
        System.out.println("Id:" + this.id);
        System.out.println("Cargo: " + this.getCargo());
        System.out.println("Salario: "+ this.getSalario());
        System.out.println("Horario: "+ this.getHorario()[0]+ "AM - " + this.getHorario()[1]+"PM");
        for(String tareas: this.getTareas())
            System.out.print(tareas);
        System.out.println();
    }

    protected int getId(){
         return this.id;
    }


}