public class TestEmergencyQueue {
    public static void main(String[] args) {
        MedicalRecordSystem system = new MedicalRecordSystem();

        // Registrar pacientes
        system.registerNewPatient("P1", "Maria", Patient.PatientType.EMERGENCY);
        system.registerNewPatient("P2", "Carlos", Patient.PatientType.EMERGENCY);
        system.registerNewPatient("P3", "Ana", Patient.PatientType.EMERGENCY);

        // Agregar pacientes con diferentes prioridades
        system.addEmergencyPatient("P1", 3);
        system.addEmergencyPatient("P2", 1);
        system.addEmergencyPatient("P3", 2);

        // Intentar agregar un paciente repetido
        system.addEmergencyPatient("P2", 1);

        // Mostrar los pacientes en urgencias
        system.showEmergencyPatients();

        // Atender pacientes por prioridad
        system.attendNextEmergencyPatient();
        system.attendNextEmergencyPatient();
        system.attendNextEmergencyPatient();

        // Probar la cola vacia
        system.attendNextEmergencyPatient();
        system.showEmergencyPatients();
    }
}