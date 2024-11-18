package ru.test.creditapm.DTO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@Data
@ToString
public class FormData {
    private String firstName;

    private String lastName;

    private String patronymic;

    private String address;

    private String maritalStatus;

    private Integer contactPhoneNumber;

    private Integer passport;

    private String companyName;

    private String position;

    private LocalDate dateWorkFrom;

    private LocalDate dateWorkTo;

    private LocalDate requestDate;

    private Integer desiredAmount;

}
