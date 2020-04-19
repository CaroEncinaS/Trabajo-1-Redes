
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */

@Path("validacion")
public class Validacion {
    @GET
    public boolean validar (@QueryParam("rutoriginal")int rutoriginal){
        boolean valida = false;
        int[] invertido = new int[9];
        int resultado, resto, multiplicador=2, sumaTotal=0, division=0, multiplicacion=0, restaMultDiv=0;
        for(int i=0;rutoriginal>0;i++){
            resto = rutoriginal % 10;
            invertido[i]=resto;
            rutoriginal /= 10;
        }
        
        for (int j=1;j<invertido.length;j++){
            if(multiplicador<=7){
                resultado=invertido[j]*multiplicador;
                sumaTotal+=resultado;
                multiplicador++;
            }
            if(multiplicador>7){
                multiplicador=2;
                
            }
        }
        
        division= sumaTotal/11;
        multiplicacion=division*11;
        
        restaMultDiv= sumaTotal-multiplicacion;
        
        int codigoVer=11-restaMultDiv;
        if(codigoVer==11){
            codigoVer=0;
        }
        
        if(codigoVer==invertido[0]){
            valida = true;
        }
        
        if(codigoVer!=invertido[0]){
            valida= false;
        }
        return valida;
    }
}
