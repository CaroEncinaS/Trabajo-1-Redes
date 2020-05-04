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
        String saludoFinal = result.saludo + result.nombre;
        char[] saludoFinalChar = saludoFinal.toCharArray();

        char[] finalresult= new char[saludoFinal.length()+15];
        finalresult[0]='[';
        finalresult[1]='{';
        finalresult[2]='"';
        finalresult[3]='s';
        finalresult[4]='a';
        finalresult[5]='l';
        finalresult[6]='u';
        finalresult[7]='d';
        finalresult[8]='o';
        finalresult[9]='"';
        finalresult[10]=':';
        finalresult[11] = '"';
        for(int i=12,j=0; j<saludoFinal.length();i++,j++){
            finalresult[i] = saludoFinalChar[j];
            if(j+1 == saludoFinal.length()){
                finalresult[i+1] = '"';
                finalresult[i+2] = '}';
                finalresult[i+3] = ']';
            }
        }
        String saludofinal=new String(finalresult);
        return Response.ok(saludofinal).build() ;
    }
}
