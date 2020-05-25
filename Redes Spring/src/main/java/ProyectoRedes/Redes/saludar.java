/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoRedes.Redes;

/**
 *
 * @author Bruggerz
 */
public class saludar {
    private String saludo;

    public saludar(String saludo) {
        this.saludo = saludo;
    }

    public String getSaludo() {
        return saludo;
    }
    
    public void concatenate(String opstr){
        saludo = saludo+opstr;
    }
}
