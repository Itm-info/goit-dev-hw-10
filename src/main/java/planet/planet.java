package planet;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Table(name = "planet")
@Entity
@Data
public class planet {
    @Id
    private String id;

    @Column
    private String name;
}
