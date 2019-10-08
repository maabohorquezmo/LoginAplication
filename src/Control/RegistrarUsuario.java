/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal_1;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class RegistrarUsuario {

    public RegistrarUsuario() {
    }
    ArrayList<Usuario> usu= new ArrayList<Usuario>();
    private Sistema sistema;
    
    public void RegistrarNuevoUsuario(Usuario usuario){
        this.sistema= FramePrincipal_1.sistema;
        sistema.AddUsuario(usuario);
        FramePrincipal_1.sistema= this.sistema;
    }
    public boolean verificarLongitudNombre(String nombre){
        return (nombre.length()>1 && nombre.length()<=6);
    }
    public boolean verificarLongitudPassword(String password){
        return (password.length()>=3 && password.length()<6);
    }
}
