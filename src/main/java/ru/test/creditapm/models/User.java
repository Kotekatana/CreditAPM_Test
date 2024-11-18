package ru.test.creditapm.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
@EqualsAndHashCode(exclude = {"workList"})
@ToString(exclude = {"workList"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String patronymic;

    private String address;

    @Column(name="marital_status")
    private String maritalStatus;

    @Column(name="contact_phone_number", unique = true)
    private Integer contactPhoneNumber;

    @Column(unique = true)
    private Integer passport;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Work> workList ;

}
