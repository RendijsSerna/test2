package lv.venta.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Cashier")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cashier {
    @Setter(value = AccessLevel.NONE)
    @Column(name = "idca")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long idca;

    @Column(name = "Name")
    @NotNull
    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
    @Size(min = 3, max = 30, message = "Jabūt vismaz 3 un ne vairāk kā 30 simboliem")
    private String Name;

    @Column(name = "Surname")
    @NotNull
    @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
    @Size(min = 3, max = 30, message = "Jabūt vismaz 3 un ne vairāk kā 30 simboliem")
    private String Surname;

    @OneToMany(mappedBy = "cashier")
    @ToString.Exclude
    private List<Ticket> tickets;

    public Cashier(String name, String surname) {
        super();
        this.Name = name;
        this.Surname = surname;
    }
    public long returnIdc () {
    	return idca;
    }
}
