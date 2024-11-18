package ru.test.creditapm.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = {"user"})
@ToString(exclude = {"user"})
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_work_from")
    private LocalDate dateWorkFrom;

    @Column(name="date_work_to")
    private LocalDate dateWorkTo;

    @Column(name="company_name")
    private String companyName;

    private String position;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
}
