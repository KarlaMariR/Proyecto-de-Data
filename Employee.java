public class Employee {
    private String id;
    private String name;
    private Role role;
    private MedicalSpecialty specialty;

    public enum Role {
        DOCTOR,
        NURSE,
        SECRETARY
    }

    public enum MedicalSpecialty {
        GENERAL,
        PEDIATRIC,
        RETINOLOGIST,
        NONE
    }

    public Employee(String id, String name, Role role, MedicalSpecialty specialty) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.specialty = specialty;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Role getRole() { return role; }
    public MedicalSpecialty getSpecialty() { return specialty; }

    @Override 
    public String toString() {
        String info = "Id: " + id + " Nombre: " + name + " Rol: " + role;
        if (role == Role.DOCTOR) {
            info += " Especialidad: " + specialty;
        }
        return info;
    }   

}
