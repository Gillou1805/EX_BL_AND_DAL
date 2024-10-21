package Main.BL.Section;


public class Status {
    private int id;         // ID du statut
    private String status;  // Description du statut

    // Constructeur
    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }

    // Getter pour l'ID
    public int getId() {
        return id;
    }

    // Setter pour l'ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour le statut
    public String getStatus() {
        return status;
    }

    // Setter pour le statut
    public void setStatus(String status) {
        this.status = status;
    }
}

