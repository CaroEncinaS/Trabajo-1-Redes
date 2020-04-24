
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
 * @author carol
 */
@Path("verificarut")

public class verificarut {
    @GET
    public String verificar(@QueryParam("rut") String Rut) {
       int intRut;
       String newRut="";
       String newDv="";
       for(int i =0, check =0;i<Rut.length() ;i++){
           if(Rut.charAt(i)=='-'){
               check=1;
           }
           else if(check==0){
               newRut+=Rut.charAt(i);
           }
           else if(check==1){
               newDv+=Rut.charAt(i);
           }
       }
       intRut = Integer.parseInt(newRut);
       String nuevoRut = newRut; //Pasa el rut a un string
       int largoCadena = nuevoRut.length(); // devuelve el largo del rut
       /** Crear un arreglo */
       int[] arregloRut = new int[largoCadena];
       for (int i = 0; i < nuevoRut.length(); i++) { 
        arregloRut[i] = intRut%10;
        intRut = intRut/10;
    }
       for (int i = 0, j=2; i < nuevoRut.length(); i++, j++) {
           if(j==8){
               j=2;
           } //guardar en cada parte del arreglo el rut sin dígito multiplicándolo por j
        arregloRut[i] = arregloRut[i]*j;
       }
       int suma = 0;
       for (int i=0; i < largoCadena; i++) {
          suma =  arregloRut[i] + suma;
       }
       int divisionsuma = suma/11;
       divisionsuma = divisionsuma*11;
       int digitoverificador = 11 - (suma - divisionsuma);
       String dv;
       if(digitoverificador == 11) {
           dv = "0";
       }
       else if(digitoverificador == 10) {
           dv = "k";
       }
       else{
           dv = Integer.toString(digitoverificador);
       }
       newDv=newDv.toLowerCase();
       if(dv.equals(newDv)){
           return "true";
       }
       else{
           return "false";
       }
    }
}



