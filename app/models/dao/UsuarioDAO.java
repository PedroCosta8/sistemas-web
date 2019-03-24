package models.dao;

import models.Usuario;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class UsuarioDAO {

    public void inserir(Usuario usuario){
        Banco.usuario.add(usuario);
    }

    public boolean atualizar(Usuario usuario){ //vai sobrescrever o usuario antigo e retornar true

        for (int i = 0; i < Banco.usuario.size(); i++) {
            if(idSaoIguais(Banco.usuario.get(i),usuario)){
                Banco.usuario.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> retornaTodos(){
        return Banco.usuario;
    }

    public boolean deletar(Usuario usuario){
        for (Usuario usuarioLista : Banco.usuario) {
            if(idSaoIguais(usuarioLista,usuario)){
                Banco.usuario.remove(usuarioLista);
                return true;
            }
        }
        return false;
    }

    public Usuario selectPorLoginESenha(Usuario usuario){
        for (Usuario usuarioLista : Banco.usuario) {
            if(loginESenhaSaoIguais(usuarioLista,usuario)){
                return usuarioLista;
            }
        }
        return null;
    }

    private boolean loginESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
        return usuario.getLogin().equals(usuarioAPesquisar.getLogin()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
    }

    private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
        return usuario.getId() ==  usuarioAComparar.getId();
    }
}
