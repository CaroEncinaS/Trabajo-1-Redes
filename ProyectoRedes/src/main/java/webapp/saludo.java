/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.PersonaDato;
import java.time.LocalTime;

/**
 *
 * @author Bruggerz
 */
@Path("saludo")
public class saludo {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saludo(@QueryParam("nombres") String nombres, @QueryParam("apellidop") String apellido1, @QueryParam("apellidom") String apellido2, @QueryParam("sexo") String sexo){
        PersonaDato result = new PersonaDato();
        LocalTime hora=LocalTime.now();

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

        result.nombre= new String(charName)+" "+ new String(charLastName1)+" "+ new String(charLastName2);

        if(sexo.equals("M")){
            result.saludo="Sr. ";
        }
        else if(sexo.equals("F")){
            result.saludo="Sra. ";
        }
        String dias;
        if(hora.getHour()-1>=12&&hora.getHour()-1<20){
            dias = "Buenas tardes ";
        }
        else if(hora.getHour()-1>=6&&hora.getHour()-1<12){
            dias = "Buenos días ";
        }
        else{
            dias = "Buenas noches ";
        }
        String saludoFinal = dias + result.saludo + result.nombre;
        char pyc='"';
        String finalresult = "[{"+Character.toString(pyc)+"saludo"+Character.toString(pyc)+":"+Character.toString(pyc)+saludoFinal+Character.toString(pyc)+"}]";
        return Response.ok(finalresult).build() ;
    }
}
