package com.witch.calculator.svc.helper;

import com.witch.calculator.dto.RequestDTO;
import com.witch.calculator.dto.ResponseDTO;
import com.witch.calculator.dto.ResultDTO;
import com.witch.calculator.svc.validator.CalculatorValidator;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalculatorHelper {

    @Autowired
    private CalculatorValidator validator;

    @Autowired
    private PrimeNumberGenerator primeGenerator;

    @Value("${null.value.message}")
    private String nullValueMessage;

    @Value("${negative.value.message}")
    private String negativeValueMessage;

    @Value("${birth.year.message}")
    private String birthYearMessage;

    @Value("${success.message}")
    private String successMessage;

    @SneakyThrows
    public ResponseDTO<ResultDTO> calculate(RequestDTO dto) {

        if(validator.nullChecker(dto) == false) {
            return new ResponseDTO().errorResponse(nullValueMessage, new ResultDTO(null, null,  (double) -1));
        }
        else if(validator.negativeChecker(dto) == false) {
            return new ResponseDTO().errorResponse(negativeValueMessage, new ResultDTO(null, null,  (double) -1));
        } else {

            //Calculate Person A
            if(validator.birthYearChecker(dto.getAgeOfDeathA(), dto.getYearOfDeathA()) == false) {
                return new ResponseDTO().errorResponse(birthYearMessage, new ResultDTO(null, null, (double) -1));
            }
            Integer avgPersonA = dto.getYearOfDeathA() - dto.getAgeOfDeathA();

            //Calculate Person B
            if(validator.birthYearChecker(dto.getAgeOfDeathB(), dto.getYearOfDeathB()) == false) {
                return new ResponseDTO().errorResponse(birthYearMessage, new ResultDTO(null, null, (double) -1));
            }
            Integer avgPersonB = dto.getYearOfDeathB() - dto.getAgeOfDeathB();

            //Get prime number sum
            Integer witchVictimA = primeGenerator.primeNumbersCalculator(avgPersonA) + 1;
            Integer witchVictimB = primeGenerator.primeNumbersCalculator(avgPersonB) + 1;

            return new ResponseDTO().successResponse(new ResultDTO(witchVictimA, witchVictimB, avgCount(witchVictimA, witchVictimB)));
        }
    }

    private Double avgCount(Integer a, Integer b) {
        return (double) (a + b) / 2;
    }
}
