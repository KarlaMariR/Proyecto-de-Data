import java.time.LocalDateTime;

public class Appointment {
    private String id;
    private Patient patient;
    private Employee doctor;
    private LocalDateTime dateTime;

    
    public Appointment(String id, Patient patient, Employee doctor, LocalDateTime dateTime) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    
    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Employee getDoctor() { return doctor; }
    public LocalDateTime getDateTime() { return dateTime; }

    @Override
    public String toString() {
        return "Id: " + id + " Paciente: " + patient.getName()
            + " Medico: " + doctor.getName() + " Fecha: " + dateTime;
    }
}