public class TestAssignments {
    public static void main(String[] args) {
        MedicalRecordSystem system = new MedicalRecordSystem();

        // Registrar el doctor y el paciente
        system.registerNewEmployee("D1", "Dr. Carlos", Employee.Role.DOCTOR, Employee.MedicalSpecialty.GENERAL);
        system.registerNewPatient("P1", "Maria", Patient.PatientType.NORMAL);
        system.registerNewPatient("P2", "Carlos", Patient.PatientType.NORMAL);

        // Para añadir el paciente al queue
        system.addToWaitingQueue("P1");
        system.addToWaitingQueue("P2");

        System.out.println("\n Intentando asignar paciente al Dr. Carlos ");
        system.assignPatientToDoctor("D1");

        System.out.println("\n Intentando asignar otro paciente al mismo médico ");
        system.assignPatientToDoctor("D1"); 

        System.out.println("\n Intentando asignar a un empleado que NO es médico ");
        system.registerNewEmployee("S1", "Ana", Employee.Role.SECRETARY, Employee.MedicalSpecialty.NONE);
        system.assignPatientToDoctor("S1"); 
    }
}