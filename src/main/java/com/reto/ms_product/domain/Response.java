package com.reto.ms_product.domain;

public class Response {
    private Object respuesta;
  private String error;
  public Object getRespuesta() {
    return respuesta;
}
public void setRespuesta(Object respuesta) {
    this.respuesta = respuesta;
}
public String getError() {
    return error;
}
public void setError(String error) {
    this.error = error;
}
public String getCodigoError() {
    return codigoError;
}
public void setCodigoError(String codigoError) {
    this.codigoError = codigoError;
}
private String codigoError; 

}