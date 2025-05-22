package Clientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pacientes{

    private int id;
    private String nombre;
    private String apellido;
    private String fechaNaci;
    private String habitacion;
    private List<String> historialMed;
    private List<String> seguimientos;
    private List<String> tratamientos;
    private List<String> citasMed;
    private List<String> alergias;
    private List<String> pruebasMed;
    private List<String> consultasAnteriores;

    public Pacientes( int id, String nombre, String apellido, String fechaNaci ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNaci = fechaNaci;
        this.habitacion = "";
        this.historialMed = new ArrayList<>();
        this.seguimientos = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
        this.citasMed = new ArrayList<>();
        this.alergias = new ArrayList<>();
        this.pruebasMed = new ArrayList<>();
        this.consultasAnteriores = new ArrayList<>();
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getFechaNaci(){
        return fechaNaci;
    }

    public String getApellido(){
        return apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNaci;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public List<String> getHistorialMedico() {
        return historialMed;
    }

    public List<String> getSeguimientos() {
        return seguimientos;
    }

    public List<String> getTratamientos() {
        return tratamientos;
    }

    //SETTERS
    public void setId( int id ) {
        this.id = id;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public void setApellido( String apellido ) {
        this.apellido = apellido;
    }

    public void setFechaNaci( String fechaNaci ) {
        this.fechaNaci = fechaNaci;
    }

    public void setHabitacion( String habitacion ) {
        this.habitacion = habitacion;
    }

    public void setHistorialMed( List<String> historialMed ) {
        this.historialMed = historialMed;
    }

    public void setSeguimientos( List<String> seguimientos ) {
        this.seguimientos = seguimientos;
    }

    public void setTratamientos( List<String> tratamientos ) {
        this.tratamientos = tratamientos;
    }

    //MÉTODOS EXTRA
    public void asignarHabitacion( String habitacion ){
        this.habitacion = habitacion;
    }

    public void addHistorialMed( String registro ){
        this.historialMed.add( registro );
    }

    public void addSegui( String seguimiento ){
        this.seguimientos.add( seguimiento );
    }

    public void addTratamientos( String tratamiendo ){
        this.tratamientos.add( tratamiendo );
    }

    public void addCitaMedica( String cita ){
        this.citasMed.add( cita );
    }

    public void addAlergia( String alergia ){
        this.alergias.add( alergia );
    }

    public void addConsultaAnterior( String consulta ){
        this.consultasAnteriores.add( consulta );
    }

    public void eliminarHistorialMed( String registro ) {
        this.historialMed.remove( registro );
    }

    public void eliminarSeguimiento( String seguimiento ) {
        this.seguimientos.remove( seguimiento );
    }

    public void eliminarTratamiento( String tratamiento ) {
        this.tratamientos.remove( tratamiento );
    }

    public void eliminarCitaMedica( String cita ) {
        this.citasMed.remove( cita );
    }

    public void eliminarAlergia( String alergia ) {
        this.alergias.remove( alergia );
    }

    public void eliminarPruebaMedica( String prueba ) {
        this.pruebasMed.remove( prueba );
    }

    public void eliminarConsultaAnterior( String consulta ) {
        this.consultasAnteriores.remove( consulta );
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente ").append(id).append(":").append(System.lineSeparator());
        sb.append("Nombre: ").append(nombre).append(" ").append(apellido).append(System.lineSeparator());
        sb.append("Fecha de nacimiento: ").append(fechaNaci).append(System.lineSeparator());
        sb.append("Habitación: ").append(habitacion).append(System.lineSeparator());
        sb.append("Historial médico: ").append(System.lineSeparator());
        for (String historial : historialMed) {
            sb.append("- ").append(historial).append(System.lineSeparator());
        }
        sb.append("Seguimientos: ").append(System.lineSeparator());
        for (String seguimiento : seguimientos) {
            sb.append("- ").append(seguimiento).append(System.lineSeparator());
        }
        sb.append("Tratamientos: ").append(System.lineSeparator());
        for (String tratamiento : tratamientos) {
            sb.append("- ").append(tratamiento).append(System.lineSeparator());
        }
        sb.append("Citas médicas: ").append(System.lineSeparator());
        for (String cita : citasMed) {
            sb.append("- ").append(cita).append(System.lineSeparator());
        }
        sb.append("Alergias: ").append(alergias).append(System.lineSeparator());
        sb.append("Consultas anteriores: ").append(System.lineSeparator());
        for (String consulta : consultasAnteriores) {
            sb.append("- ").append(consulta).append(System.lineSeparator());
        }
        return sb.toString();
    }



    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Registro y Gestión de Pacientes:");
            System.out.println("1. Mostrar información del paciente");
            System.out.println("2. Asignar habitación");
            System.out.println("3. Agregar historial médico");
            System.out.println("4. Agregar seguimiento");
            System.out.println("5. Agregar tratamiento");
            System.out.println("6. Agregar cita médica");
            System.out.println("7. Agregar alergia");
            System.out.println("8. Agregar consulta anterior");
            System.out.println("9. Eliminar seguimiento");
            System.out.println("10. Eliminar historial médico");
            System.out.println("11. Eliminar cita médica");
            System.out.println("12. Eliminar alergia");
            System.out.println("13. Eliminar consulta anterior");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Información del paciente:");
                    System.out.println(this);
                    break;
                case 2:
                    System.out.print("Ingrese el número de habitación: ");
                    String habitacion = scanner.next();
                    asignarHabitacion(habitacion);
                    break;
                case 3:
                    System.out.print("Ingrese el historial médico: ");
                    String historialMedico = scanner.nextLine();
                    addHistorialMed(historialMedico);
                    break;
                case 4:
                    System.out.print("Ingrese el seguimiento: ");
                    String seguimiento = scanner.nextLine();
                    addSegui(seguimiento);
                    break;
                case 5:
                    System.out.print("Ingrese el tratamiento: ");
                    String tratamiento = scanner.nextLine();
                    addTratamientos(tratamiento);
                    break;
                case 6:
                    System.out.print("Ingrese la cita médica: ");
                    String citaMedica = scanner.nextLine();
                    addCitaMedica(citaMedica);
                    break;
                case 7:
                    System.out.print("Ingrese la alergia: ");
                    String alergia = scanner.nextLine();
                    addAlergia(alergia);
                    break;
                case 8:
                    System.out.print("Ingrese la consulta anterior: ");
                    String consultaAnterior = scanner.nextLine();
                    addConsultaAnterior(consultaAnterior);
                    break;
                case 9:
                    System.out.print("Ingrese el seguimiento a eliminar: ");
                    String seguimientoAEliminar = scanner.nextLine();
                    eliminarSeguimiento(seguimientoAEliminar);
                    break;
                case 10:
                    System.out.print("Ingrese el historial médico a eliminar: ");
                    String historialAEliminar = scanner.nextLine();
                    eliminarHistorialMed(historialAEliminar);
                    break;
                case 11:
                    System.out.print("Ingrese la cita médica a eliminar: ");
                    String citaAEliminar = scanner.nextLine();
                    eliminarCitaMedica(citaAEliminar);
                    break;
                case 12:
                    System.out.print("Ingrese la alergia a eliminar: ");
                    String alergiaAEliminar = scanner.nextLine();
                    eliminarAlergia(alergiaAEliminar);
                    break;
                case 13:
                    System.out.print("Ingrese la consulta anterior a eliminar: ");
                    String consultaAnteriorAEliminar = scanner.nextLine();
                    eliminarConsultaAnterior(consultaAnteriorAEliminar);
                    break;
                case 0:
                    System.out.println("Saliendo del menú de Registro y Gestión de Clientes.Pacientes...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    static void nuevoPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del nuevo paciente:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del nuevo paciente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del nuevo paciente:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento del nuevo paciente (dd/MM/yyyy):");
        String fechaNaci = scanner.nextLine();

        Pacientes nuevoPaciente = new Pacientes(id, nombre, apellido, fechaNaci);


        System.out.println("Nuevo paciente creado con éxito:");
        System.out.println("ID: " + nuevoPaciente.getId());
        System.out.println("Nombre: " + nuevoPaciente.getNombre());
        System.out.println("Apellido: " + nuevoPaciente.getApellido());
        System.out.println("Fecha de Nacimiento: " + nuevoPaciente.getFechaNaci());

        InventarioPacientes.pacientes.put(nuevoPaciente.getId(),nuevoPaciente);
    }




}