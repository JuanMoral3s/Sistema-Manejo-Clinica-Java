package EnfermedadesYTratamientos;

import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Tratamiento{
    private String nombreDeltratamiento;
    private String viaDeAdministracion;
    private String cantidad;
    private LocalTime periorisidad;
    private LocalDate inicioDeTratamiento;
    private LocalDate finalDeTratamiento;

    public Tratamiento(String nombreDeltratamiento,String viaDeAdministracion){
        this.nombreDeltratamiento=nombreDeltratamiento;
        this.viaDeAdministracion=viaDeAdministracion;
    }
    //La cantidad y la periorisidad dependeran de cada paciente y se tendran que settear en la receta.


    public void setNombreDelTrataamiento(String nombreDelTratamiento){
       this.nombreDeltratamiento=nombreDelTratamiento;
    }
    public String getNombreDelTratamiento(){
        return nombreDeltratamiento;
    }

    public void setViaDeAdministracion(String viaDeAdministracion){
        this.viaDeAdministracion=viaDeAdministracion;
    }
    public String getViaDeAdministracio(){
        return viaDeAdministracion;
    }

    public void setCantidad(String cantidad){
        this.cantidad=cantidad;
    }
    public String getCantidad(){
        return cantidad;
    }

    public void setInicioDeTratamiento(int anio, int mes, int dia){
        this.inicioDeTratamiento=LocalDate.of(anio, mes, dia);
    }
    public LocalDate getInicioDeTratamiento(){
        return inicioDeTratamiento;
    }

    public void setFinalDeTratamiento(int anio, int mes, int dia){
        this.finalDeTratamiento=LocalDate.of(anio, mes, dia);
    }
    public LocalDate getFinalDeTratamiento(){
        return finalDeTratamiento;
    }

    public void setPeriorisidad(int hora){
        this.periorisidad=LocalTime.of(hora, 0);
    }
    public LocalTime getPeriorisidad(){
        return periorisidad;
    }

    public void calcularNumeroTotalDosis() {
        long diasDeTratamiento = ChronoUnit.DAYS.between(inicioDeTratamiento, finalDeTratamiento);
        System.out.println("Los dias de tratamiento totales son: "+diasDeTratamiento);
        long dosisDiarias = ChronoUnit.DAYS.between(LocalTime.MIN, periorisidad);
        System.out.println("Las dosis diarias en esos dias seran: "+dosisDiarias);
        long total=diasDeTratamiento/dosisDiarias;
        System.out.println("El numero total de dosis es :"+total);
    }


    
}