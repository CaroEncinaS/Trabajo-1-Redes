/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoRedes.Redes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Bruggerz
 */
@Controller
public class app {
    @GetMapping("/app")
    public String app(){
        return "app";
    }
}
