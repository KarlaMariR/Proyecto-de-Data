import java.time.LocalDateTime;

public class MedicalVisit {
    private Patient patient;
    private Employee doctor;
    private LocalDateTime dateTime;
    private String diagnosis;
    private String notes;

    public MedicalVisit(Patient patient, Employee doctor, String diagnosis, String notes ) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = LocalDateTime.now();
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public Patient getPatient() { return patient; }
    public Employee getDoctor() { return doctor; }
    public LocalDateTime getLocalTime() { return dateTime; }
    public String getDiagnosis() { return diagnosis; }
    public String getNotes() { return notes; }

    @Override
    public String toString() {
        return "Fecha: " + dateTime + " Medico: " + doctor.getName() + " Diagnostico: " + diagnosis + " Notas: " + notes;
    }

}

