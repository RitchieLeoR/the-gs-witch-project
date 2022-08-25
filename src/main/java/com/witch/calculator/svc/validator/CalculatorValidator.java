package com.witch.calculator.svc.validator;

import com.witch.calculator.dto.RequestDTO;
import org.springframework.stereotype.Component;

@Component
public class CalculatorValidator {

    public boolean negativeChecker(RequestDTO dto) {

        if(dto.getAgeOfDeathA() <= 0 || dto.getYearOfDeathA() <= 0 || dto.getAgeOfDeathB() <= 0 || dto.getYearOfDeathB() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean nullChecker(RequestDTO dto) {

        if(dto.getAgeOfDeathA() == null || dto.getYearOfDeathA() == null || dto.getAgeOfDeathB() == null || dto.getYearOfDeathB() == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean birthYearChecker(Integer a, Integer b) {

        if((b-a) <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
