import java.time.LocalDateTime;

public class TestAppointments {
    public static void main(String[] args) {

        MedicalRecordSystem system = new MedicalRecordSystem();

        // Registrar paciente y medico
        system.registerNewPatient("P1", "Maria", Patient.PatientType.NORMAL);
        system.registerNewEmployee("D1", "Carlos", Employee.Role.DOCTOR,
                Employee.MedicalSpecialty.GENERAL);

        LocalDateTime date = LocalDateTime.of(2026, 12, 1, 10, 0);

        // Registrar una cita
        system.scheduleAppointment("C1", "P1", "D1", date);

        // Intentar registrar una cita duplicada
        system.scheduleAppointment("C1", "P1", "D1", date);

        // Intentar registrar otra cita a la misma hora
        system.scheduleAppointment("C2", "P1", "D1", date);

        // Cancelar la cita
        system.cancelAppointment("C1");

        // Intentar cancelar una cita que no existe
        system.cancelAppointment("C1");

        // Registrar otra cita en el horario liberado
        system.scheduleAppointment("C2", "P1", "D1", date);

        // Registrar una cita para otro dia
        system.scheduleAppointment("C3", "P1", "D1", date.plusDays(1));

        // Mostrar todas las citas
        system.showAllAppointments();

        // Cancelar las citas
        system.cancelAppointment("C2");
        system.cancelAppointment("C3");

        // Probar la lista vacia
        system.showAllAppointments();
    }
}