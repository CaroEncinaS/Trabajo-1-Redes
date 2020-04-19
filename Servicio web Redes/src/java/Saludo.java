
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
@Path("saludo")
public class Saludo {
    @GET
    public String saludo(@QueryParam("genero") boolean genero, @QueryParam("paterno") String nombre1,@QueryParam("materno") String nombre2,@QueryParam("pila") String nombre3){
        String mensaje = "hola";
        if (genero==true){
            mensaje="Sr. "+nombre3+" "+nombre1+" "+nombre2;
        }
        if (genero==false){
            mensaje="Sra. "+nombre3+" "+nombre1+" "+nombre2;
        }

        return mensaje;
    }
}
