package com.witch.calculator.svc.controller;

import com.witch.calculator.dto.RequestDTO;
import com.witch.calculator.dto.ResponseDTO;
import com.witch.calculator.dto.ResultDTO;
import com.witch.calculator.svc.helper.CalculatorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorRESTController {

    @Autowired
    private CalculatorHelper helper;

    @RequestMapping(value = "/calculate.killcount.average",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<ResultDTO>> calculateAvgKillcount(@RequestBody RequestDTO dto) {
        ResponseDTO<ResultDTO> response = helper.calculate(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
