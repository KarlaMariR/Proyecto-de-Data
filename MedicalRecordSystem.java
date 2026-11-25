import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;



public class MedicalRecordSystem {
    // Lista para archivar los pacientes y empleados registrados ahora.
    private List<Patient> registeredPatients;
    private List<Employee> registeredEmployees;
    private List<Appointment> appointments;


    public MedicalRecordSystem() {
        this.registeredPatients = new ArrayList<>();
        this.registeredEmployees = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    // Registrar un nuevo paciente.
    public void registerNewPatient(String id, String name, Patient.PatientType type) {
        
        if ( findPatientById(id) != null ) {
            System.out.println("Error");
            return;
        }
    
        // Añadir el paciente nuevo y añadirlos a la lista.
        Patient newPatient = new Patient(id, name, type);
        registeredPatients.add(newPatient);
        
        System.out.println("Registered");
        System.out.println("-> " + newPatient.toString() );
    }

    // Add the Employee thing here
    public void registerNewEmployee(String id, String name, Employee.Role role, Employee.MedicalSpecialty specialty) {
        
        if ( findPatientById(id) != null ) {
            System.out.println("Error");
            return;
        }

        Employee newEmployee = new Employee(id,name,role,specialty);
        registeredEmployees.add(newEmployee);
    
        System.out.println("Registered");
        System.out.println("-> " + newEmployee.toString() );
    }
    
    // Para buscar los pacientes por id.
    public Patient findPatientById(String id) {
        for ( Patient p : registeredPatients ) {
            if ( p.getId().equals(id) ) {
                return p;
            }
        }
        return null;
    }

    // Add the employee id search here
    public Employee findEmployeeById(String id) {
        for ( Employee e : registeredEmployees) {
            if ( e.getId().equals(id) ) {
                return e;
            }
        }
        return null;
    }

    // Para enseñar todos los pacientes. 
    public void showAllPatients() {
        System.out.println( "Lista de pacientes: " );
        if ( registeredPatients.isEmpty() ) {
            System.out.println("No hay pacientes");
        }
        else {
            for ( Patient p : registeredPatients ) {
                System.out.println( p.toString() );
            }
        }
        System.out.println("Final de lista");
    }

    // Hacer Cita
    public void scheduleAppointment(String id, String patientId, String doctorId, LocalDateTime dateTime) {
        Patient patient = findPatientById(patientId);
        Employee doctor = findEmployeeById(doctorId);

        if (patient == null) {
            System.out.println("Paciente no encontrado");
            return;
        }

        if (doctor == null || doctor.getRole() != Employee.Role.DOCTOR) {
            System.out.println("Medico no encontrado");
            return;
        }

        if (dateTime == null) {
            System.out.println("Fecha invalida");
            return;
        }

        for (Appointment a : appointments) {
            if (a.getId().equals(id)) {
                System.out.println("La cita ya existe");
                return;
            }

            if (a.getDateTime().equals(dateTime)) {
                if (a.getDoctor().getId().equals(doctorId) ||
                    a.getPatient().getId().equals(patientId)) {
                    System.out.println("Horario no disponible");
                    return; 
                }
            }
        }

        Appointment newAppointment = new Appointment(id, patient, doctor, dateTime);
        appointments.add(newAppointment);

        System.out.println("Cita registrada");
        System.out.println(newAppointment); 
    }

    // Cancelar Cita
    public void cancelAppointment(String id) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getId().equals(id)) {
                appointments.remove(i);
                System.out.println("Cita cancelada");
                return;
            }
        }
        System.out.println("Cita no encontrada");
    }


    // El metodo principal del file.
    public static void main(String[] args) {
        MedicalRecordSystem system = new MedicalRecordSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Systema de consultas medicas");
        System.out.println("Operacion: Registrar nuevo paciente");

        // Pregunta por tu id.
        System.out.println("Añada tu id: ");
        String id = scanner.nextLine();

        // Pregunta por tu nombre
        System.out.println("Añada tu nombre: ");
        String name = scanner.nextLine();

        // Pregunta por el tipo de situacion, con un Si o no.
        System.out.println("Es emergencia o no? [S/N]: ");
        String isEmergency = scanner.nextLine();

        Patient.PatientType type = isEmergency.equalsIgnoreCase("Si") 
            ? Patient.PatientType.EMERGENCY 
            : Patient.PatientType.NORMAL;

        // Hacer la operacion.
        system.registerNewPatient(id, name, type);

        System.out.println("Prueba de validacion, intendando registrar el mismo id.");
        system.registerNewPatient(id, "Otro Nombre", Patient.PatientType.NORMAL);

        // Enseña la lista de los pacientes.
        system.showAllPatients();

        scanner.close();

    }

}
