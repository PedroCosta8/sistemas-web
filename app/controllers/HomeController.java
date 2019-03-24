package controllers;

import play.mvc.*;
import java.util.Map;
import models.Usuario;
import models.dao.*;

public class HomeController extends Controller {

    public Result index() {
        Banco.inicia();
        return ok(views.html.index.render());
    }

    public Result mostrar(){
      Map<String, String[]> r =
          request().body().asFormUrlEncoded();
      String login = String.valueOf(r.get("login")[0]);
      String senha = String.valueOf(r.get("senha")[0]);

      Usuario usuario = new Usuario(0,login,senha);
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      Usuario usuarioAutenticado = usuarioDAO.selectPorLoginESenha(usuario);
      if(usuarioAutenticado != null){
        return ok(views.html.mainPage.render(login, senha));
      }
      else{
        return ok(views.html.index.render());
      }
    }

    // public Result olaMundo(){
    //   return ok("Ola Mundo!");
    // }
    //
    // public Result somaPost() {
    //   return ok(views.html.formSomaPost.render());
    // }
    //
    // public Result formSomaPost() {
    //   Map<String, String[]> r =
    //       request().body().asFormUrlEncoded();
    //   int a  = Integer.parseInt(r.get("a")[0]);
    //   int b  = Integer.parseInt(r.get("b")[0]);
    //
    //   return ok(views.html.respostaSoma.render(a, b, a+b));
    // }
    //
    // public Result maior2Post(){
    //   return ok(views.html.formMaior2.render());
    // }
}
