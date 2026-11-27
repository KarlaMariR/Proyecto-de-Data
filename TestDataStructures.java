public class TestDataStructures {
    public static void main(String[] args) {
        MedicalRecordSystem system = new MedicalRecordSystem();

        // Prueba de HashSet para evitar pacientes duplicados.
        system.registerNewPatient("P1", "Maria", Patient.PatientType.NORMAL);
        // Esto no va a funcionar si P1 esta en el HashSet.
        system.registerNewPatient("P1", "Maria Falsa", Patient.PatientType.EMERGENCY); 

        // Prueba de HashMap para ver que rapido es la busqueda.
        system.registerNewEmployee("D1", "Dr. Carlos", Employee.Role.DOCTOR, Employee.MedicalSpecialty.GENERAL);
        system.registerNewEmployee("N1", "Ana", Employee.Role.NURSE, Employee.MedicalSpecialty.NONE);
        
        // Esto inprime Carlos rapido.
        Employee foundDoc = system.findEmployeeById("D1");
        System.out.println("Búsqueda rápida encontró a: " + foundDoc.getName());

        // Prueba para eliminar el empleado.
        system.removeEmployee("N1");
        
        // Esto va dar null buscando el empleado que ya no esta.
        Employee missingNurse = system.findEmployeeById("N1");
        if (missingNurse == null) {
            System.out.println("Confirmado: Ana ya no está en el sistema.");
        }

        // Esto intenta de remover un empleado que no existe.
        system.removeEmployee("N99");
    }
}
