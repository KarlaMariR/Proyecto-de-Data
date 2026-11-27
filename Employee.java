public class Employee {
    private String id;
    private String name;
    private Role role;
    private MedicalSpecialty specialty;
    private boolean isAvailable;

    public enum Role {
        DOCTOR,
        NURSE,
        SECRETARY
    }

    public enum MedicalSpecialty {
        GENERAL,
        PEDIATRIC,
        RETINOLOGIST,
        NEURO_OPHTHALMOLOGIST,
        NONE
    }

    public Employee(String id, String name, Role role, MedicalSpecialty specialty) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.specialty = specialty;
        this.isAvailable = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Role getRole() { return role; }
    public MedicalSpecialty getSpecialty() { return specialty; }
    
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; } 

    @Override 
    public String toString() {
        String info = "Id: " + id + " Nombre: " + name + " Rol: " + role;
        if (role == Role.DOCTOR) {
            info += " Especialidad: " + specialty + " Disponible " + ( isAvailable ? "Si" : "No" );
        }
        return info;
    }   

}
