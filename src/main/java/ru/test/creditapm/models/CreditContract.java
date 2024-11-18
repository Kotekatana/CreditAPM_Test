package ru.test.creditapm.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "credit_contract")
@EqualsAndHashCode(exclude = {"creditRequest"})
@ToString(exclude = {"creditRequest"})
public class CreditContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="approved_amount")
    private Integer approvedAmount;

    @Column(name="approved_days_period")
    private Integer approvedDaysPeriod;

    @Column(name="signed")
    private Boolean isSigned = false;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_request_id")
    private CreditRequest creditRequest;

}