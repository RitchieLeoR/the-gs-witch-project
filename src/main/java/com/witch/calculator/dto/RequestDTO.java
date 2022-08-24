package com.witch.calculator.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestDTO {

    private Integer ageOfDeathA;
    private Integer yearOfDeathA;
    private Integer ageOfDeathB;
    private Integer yearOfDeathB;
}
