package jpa.mapping.MapJpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jpa_student")
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private String about;

    //Reference variable of Laptop entity
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Laptop laptop;

    //Student having multiple addresses
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();
}
