package ru.test.creditapm.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode()
@ToString()
@Table(name = "credit_request")
public class CreditRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="desired_amount")
    private Integer desiredAmount;

    @Column(name="approved")
    private Boolean isApproved;

    @Column(name="request_date")
    private LocalDate requestDate;

}
