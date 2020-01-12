package hibernate.entities;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "novadi")
public class Novadi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "novadiId")
    private int novadiId;

    @Column(name = "nosaukums")
    private String nosaukums;

    public Novadi(int novadiId, String nosaukums) {
        this.novadiId = novadiId;
        this.nosaukums = nosaukums;
    }

    @Override
    public String toString() {
        return "Novadi{" +
                "novadiId=" + novadiId +
                ", nosaukums='" + nosaukums + '\'' +
                '}';
    }
}
