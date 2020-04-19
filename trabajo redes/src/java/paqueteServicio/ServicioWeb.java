/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteServicio;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author carol
 */
@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Invertir")
    public int[] Invertir(@WebParam(name = "rutOriginal") int rutOriginal) {
        int invertido[] = null, resto;
        for(int i=0;rutOriginal > 0;i++) {
            resto = rutOriginal % 10;
            invertido[i] = resto;
            rutOriginal /= 10;
        }
        //TODO write your implementation code here:
        return invertido;
    }
}
