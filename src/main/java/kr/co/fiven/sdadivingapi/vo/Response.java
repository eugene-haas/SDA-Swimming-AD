package kr.co.fiven.sdadivingapi.vo;


import lombok.Data;

@Data
public class Response<T> {
    private int rstCode = 500;
    private String rstMessage = "";
    private T result;
}
