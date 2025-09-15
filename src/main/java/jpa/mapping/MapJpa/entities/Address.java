package jpa.mapping.MapJpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jpa_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private int addressId;
    private String city;
    private String country;
    private String street;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
