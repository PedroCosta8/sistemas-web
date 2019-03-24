package models.DAO;

import models.Usuario;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Banco {

    public static ArrayList<Usuario> usuario;

    public static void inicia(){
        usuario = new ArrayList<>();

        Usuario usuario1 = new Usuario(0, "admin", "0000");
        usuario.add(usuario1);
    }
}
