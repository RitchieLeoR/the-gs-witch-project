package com.witch.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {

    private String message;
    private T data;

    public ResponseDTO<T> successResponse(){
        ResponseDTO<T> data = new ResponseDTO<T>();
        data.setMessage("Process Successed");
        return data;
    }

    public ResponseDTO<T> successResponse(T t){
        ResponseDTO<T> data = new ResponseDTO<T>();
        data.setData(t);
        data.setMessage("Process Success");
        return data;
    }

    public ResponseDTO<T> errorResponse(String message, T t){
        ResponseDTO<T> data = new ResponseDTO<T>();
        data.setData(t);
        data.setMessage(message);
        return data;
    }
}
