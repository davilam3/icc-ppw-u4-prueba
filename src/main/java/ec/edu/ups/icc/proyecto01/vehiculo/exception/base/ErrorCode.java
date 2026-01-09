package ec.edu.ups.icc.proyecto01.vehiculo.exception.base;


public class ErrorCode extends RuntimeException {

    private String code;

    public ErrorCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
}