package TireMall.Showroom;

import java.util.UUID;

public class Tire {

    private UUID id;
    private String name;

    public Tire(UUID id, String name) {
        super();
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String name() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Tire tire = (Tire) o;
            return !this.id.equals(tire.id) ? false : this.name.equals(tire.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }
}
