package Menus;

import EnfermedadesYTratamientos.AlmacenDeTratamientos;

import static Menus.menuPrincipal.getEleccionUsuario;

public class menuTratamientosYEnferemdades {

    public static void gestionTratamientoYEnfermedaes() {
        System.out.println("Bienvenido al sistema de gestion de Tratamientos y Enfermedades");
        int eleccionUsuario = 0;
        do {
            System.out.println("1.-Imprimir enfermedades");
            System.out.println("2.-Imprimir tratamientos");
            System.out.println("3.-Registrar nueva enfermedad");
            System.out.println("4.-Registrar nuevo tratamiento");
            System.out.println("5.-Salir");

            eleccionUsuario = getEleccionUsuario(eleccionUsuario, 7);
            switch (eleccionUsuario) {
                case 1 -> AlmacenDeTratamientos.ImprimirEnfermedadesConocidas();
                case 2 -> AlmacenDeTratamientos.ImprimirTratamientosConocidos();
                case 3 -> AlmacenDeTratamientos.nuevaEnfermedad();
                case 4 -> AlmacenDeTratamientos.nuevoTratamiento();
            }
        } while (eleccionUsuario != 5);
    }
}