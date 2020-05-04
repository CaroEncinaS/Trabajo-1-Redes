package webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import modelo.PersonaDato;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carol
 */
@Path("rest")

public class verificarut {
    @Path("verificarut")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verificar(@QueryParam("rut") String Rut) {
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
        //RespuestaServicio respuesta = new RespuestaServicio();
        //String val = "false";
       if(dv.equals(newDv)){
           //val="true";
           char[] cadena = {'[','{','"','v','a','l','i','d','o','"',':','"','t','r','u','e','"','}',']'};
           String result = new String(cadena);
           return Response.ok(result).build();
       }
       else{
           //val="false";
           char[] cadena = {'[','{','"','v','a','l','i','d','o','"',':','"','f','a','l','s','e','"','}',']'};
           String result = new String(cadena);
           return Response.ok(result).build();
       } 
    }
    @Path("saludo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saludo(@QueryParam("nombres") String nombres, @QueryParam("apellidop") String apellido1, @QueryParam("apellidom") String apellido2, @QueryParam("sexo") String sexo){
        PersonaDato result = new PersonaDato();

        nombres = nombres.toLowerCase();
        apellido1 = apellido1.toLowerCase();
        apellido2 = apellido2.toLowerCase();

        apellido1 = apellido1.replace(" ","");
        apellido2 = apellido2.replace(" ","");

        char[] charName = nombres.toCharArray();
        char[] charLastName1 = apellido1.toCharArray();
        char[] charLastName2 = apellido2.toCharArray();

        charLastName1[0] = Character.toUpperCase(charLastName1[0]);
        charLastName2[0] = Character.toUpperCase(charLastName2[0]);

        if(charName[0]!=' '){
            charName[0] = Character.toUpperCase(charName[0]);
        }

        for(int i = 1; i < nombres.length() -1 ; i++){
            if(charName[i-1]== ' ' && charName[i] != ' '){
                charName[i] = Character.toUpperCase(charName[i]);
            }
        }

        result.nombre = new String(charName)+" "+ new String(charLastName1)+" "+ new String(charLastName2);

        if(sexo == "M"){
            result.saludo = "Sr. ";
        }
        else if(sexo == "F"){
            result.saludo = "Sra. ";
        }

        return Response.ok(result).build();
    }
}
