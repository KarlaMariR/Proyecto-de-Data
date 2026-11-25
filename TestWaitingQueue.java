public class TestWaitingQueue {
    public static void main(String[] args) {
        MedicalRecordSystem system = new MedicalRecordSystem();

        // Registrar pacientes
        system.registerNewPatient("P1", "Maria", Patient.PatientType.NORMAL);
        system.registerNewPatient("P2", "Carlos", Patient.PatientType.NORMAL);
        system.registerNewPatient("P3", "Ana", Patient.PatientType.NORMAL);

        // Agregar pacientes a la cola
        system.addToWaitingQueue("P1");
        system.addToWaitingQueue("P2");
        system.addToWaitingQueue("P3");

        // Intentar agregar un paciente repetido
        system.addToWaitingQueue("P1");

        // Mostrar la cola
        system.showWaitingPatients();

        // Atender al primer paciente
        system.attendNextPatient();

        // Mostrar los pacientes restantes
        system.showWaitingPatients();

        system.attendNextPatient();
        system.attendNextPatient();

        // Probar la cola vacia
        system.attendNextPatient();
        system.showWaitingPatients();
    }
}