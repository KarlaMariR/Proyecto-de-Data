public class Patient {
    private String id;
    private String name;
    private PatientType type;
    private int priority;


    // Enum tipos
    public enum PatientType {
        NORMAL, 
        EMERGENCY
    }

    // Contructor
    public Patient(String id, String name, PatientType type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.priority = 3;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public PatientType getType() { return type; }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override 
    public String toString() {
        return "Id: " + id + " Nombre: " + name + " Tipo: " + type;
    }
}
