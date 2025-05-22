package EnfermedadesYTratamientos;

import java.util.ArrayList;

public class Enfermedad{
    private String nombreDeLaEnfermedad;
    private ArrayList<String> listaSintomas;
    private ArrayList<Tratamiento> listaDeTratamientos;
    private float tasaDeMortalidad;

    public Enfermedad(){}

    public Enfermedad(String nombreDeLaEnfermedad, ArrayList<String> listaSintomas, ArrayList<Tratamiento> listaDeTratamientos, float tasaDeMortalidad){
      this.nombreDeLaEnfermedad=nombreDeLaEnfermedad;
      this.listaSintomas=listaSintomas;
      this.listaDeTratamientos=listaDeTratamientos;
      this.tasaDeMortalidad=tasaDeMortalidad;
    }

    public void setNombreDeLaEnfermedad(String nombreDeLaEnfermedad){
        this.nombreDeLaEnfermedad=nombreDeLaEnfermedad;
    }
    public String getNombreDeLaEnfermedad(){
        return nombreDeLaEnfermedad;
    }

    public void setListaSintomas(ArrayList<String> listaSintomas){
        this.listaSintomas=listaSintomas;
    }
    public ArrayList<String> getListaSintomas(){
        return listaSintomas;
    }

    public void setListaDeTratamientos(ArrayList<Tratamiento> listaDeTratamientos){
       this.listaDeTratamientos=listaDeTratamientos;
    }
    public ArrayList<Tratamiento> getListaDeTratamientos(){
        return listaDeTratamientos;
    }

    public void setTasaDeMortalidad(float tasaDeMortalidad){
       this.tasaDeMortalidad=tasaDeMortalidad;
    }
    public float getTasaDeMortalidad(){
        return tasaDeMortalidad;
    }
    
}