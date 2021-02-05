package TireMall.Showroom;

import org.jetbrains.annotations.NotNull;
import java.util.UUID;

public class Tire {

    private final UUID id;
    private final String name;

    public Tire(@NotNull String name) {



        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String name() {
        return name;
    }
@Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tire tire = (Tire) o;

    if (!id.equals(tire.id)) return false;
    return name.equals(tire.name);
    }
@Override
    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }
}
