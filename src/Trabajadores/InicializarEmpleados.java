package Trabajadores;

import javax.print.Doc;

public class InicializarEmpleados {

    public static void empleados() {
        Enfermero enfermero1 = new Enfermero("Julian Perez", "Hombre", 12000, 9, 5, "Instrumentista",10);
        Enfermero enfermero2 = new Enfermero("Carlos Lopez", "Hombre", 9000, 7, 3, "Camillero",11);

        Auxiliar auxiliar1 = new Auxiliar("Puma Amigo", "Hombre", 1000, 6, 9, "Contabilidad",12);
        Auxiliar auxiliar2 = new Auxiliar("Miki Miguel", "Hombre", 8000, 9, 5, "Recursos Humanos",13);

        Conserje conserje1 = new Conserje("Juan Vera", "Hombre", 6000, 8, 4, "Este",14);
        Conserje conserje2 = new Conserje("Pablo Morales", "Hombre", 6000, 8, 4, "Este",15);

        Doctor doctor1 = new Doctor("Karla Pallas", "Mujer", 20000, 9, 5, "Psicologia",16);
        Doctor doctor2 = new Doctor("Edgar Tista", "Hombre", 20000, 10, 6, "Cardiologia",17);
    }

}
