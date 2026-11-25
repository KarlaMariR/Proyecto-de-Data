import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;



public class MedicalRecordSystem {
    // Lista para archivar los pacientes y empleados registrados ahora.
    private List<Patient> registeredPatients;
    private List<Employee> registeredEmployees;
    private List<Appointment> appointments;
    private Queue<Patient> waitingQueue;
    private List<MedicalVisit> medicalHistory;


    public MedicalRecordSystem() {
        this.registeredPatients = new ArrayList<>();
        this.registeredEmployees = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.waitingQueue = new LinkedList<>();
        this.medicalHistory = new ArrayList<>();
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
        
        if ( findEmployeeById(id) != null ) {
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

    // Agregar paciente a la cola de espera
    public void addToWaitingQueue(String patientId) {
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Paciente no encontrado");
            return;
        }

        if (waitingQueue.contains(patient)) {
            System.out.println("Paciente ya esta en espera");
            return;
        }

        if (patient.getType() == Patient.PatientType.EMERGENCY) {
            System.out.println("Paciente debe ir a urgencias");
            return;
        }

        waitingQueue.add(patient);
        System.out.println("Paciente agregado a la cola de espera: " + patient.getName());
    }

    //Atender al siguiente paciente en la cola de espera
    public Patient attendNextPatient() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No hay pacientes en espera");
            return null;
        }

        Patient nextPatient = waitingQueue.poll();
        System.out.println("Atendiendo al paciente: " + nextPatient.getName());

        return nextPatient;
    }

    // Mostrar pacientes en espera
    public void showWaitingPatients() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No hay pacientes en espera");
            return;
        }

        System.out.println("Pacientes en espera:");

        for (Patient p : waitingQueue) {
            System.out.println(p.toString());
        }
    }

    // Asignar al paciente a un medico disponible
    public void assignPatientToDoctor(String DoctorId) {
        Employee doctor = findEmployeeById(DoctorId);

        // Los 3 valiladores
        if ( doctor == null || doctor.getRole() != Employee.Role.DOCTOR ) {
            System.out.println("Error: El id ingresado no es medico.");
            return;
        }

        if ( !doctor.isAvailable() ) {
            System.out.println("Error: El Medico" + doctor.getName() + "no esta disponible en este momento.");
            return;
        }

        if ( waitingQueue.isEmpty() ) {
            System.out.println("No hay fila.");
            return;
        }

        // Selecionar el paciente del queue 
        Patient patient = waitingQueue.poll();
        
        // Cambiar el estatus del doctor a ocupado.
        doctor.setAvailable(false); 

        // Los strings que dice que pasa.
        System.out.println("El medico" + doctor.getName() + " (" + doctor.getSpecialty() + ") esta disponible." );
        System.out.println("El paciente" + patient.getName() + " (Id " + patient.getId() + ") fue selecionado." );
        System.out.println("Doctor haciendo cosas que hace un doctor.");
        System.out.println("El medico atiende al paciente");
        System.out.println("El medico" + doctor.getName() + "esta ocupado");

    }
    
    // Registrar la visita medica 
    public void registerMedicalVisit(String doctorId, String patientId, String diagnosis, String notes) {
        Employee doctor = findEmployeeById(doctorId);
        Patient patient = findPatientById(patientId);

        // Los 3 valiladores
        if ( doctor == null || doctor.getRole() != Employee.Role.DOCTOR ) {
            System.out.println("Error: Medico no valido.");
            return;
        }

        if ( patient == null ) {
            System.out.println("Error: No encontro el paciente.");
            return;
        }
        
        if ( doctor.isAvailable() ) {
            System.out.println("Error: El Medico" + doctor.getName() + "no tiene consulta activa.");
            return;
        }

        // Para crear un archivo nuevo.
        MedicalVisit newVisit = new MedicalVisit(patient, doctor, diagnosis, notes);
        medicalHistory.add(newVisit);

        // Para desocupar el doctor
        doctor.setAvailable(true);

        // Los strings que dice que pasa.
        System.out.println("Visita registrada!");
        System.out.println( newVisit.toString() );
        System.out.println("El medico " + doctor.getName() + " ahora esta disponible." );
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
