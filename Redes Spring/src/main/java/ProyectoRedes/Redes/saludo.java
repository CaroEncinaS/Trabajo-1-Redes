/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoRedes.Redes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;

/**
 *
 * @author Bruggerz
 */
@RestController
public class saludo {
    @GetMapping("/app/saludo")
    public saludar saludo(@RequestParam(value="nombres") String nombres, @RequestParam(value="apellidop") String apellido1, @RequestParam(value="apellidom") String apellido2, @RequestParam(value="sexo") String sexo){
        LocalTime hora=LocalTime.now();
        saludar result = new saludar("");
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

        String fullname= new String(charName)+" "+ new String(charLastName1)+" "+ new String(charLastName2);
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
        result.concatenate(dias);
        
        if(sexo.equals("M")){
            result.concatenate("Sr. ");
        }
        else if(sexo.equals("F")){
            result.concatenate("Sra. ");
        }
        result.concatenate(fullname);
        return result;
    }
}

