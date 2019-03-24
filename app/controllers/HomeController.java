package controllers;

import play.mvc.*;
import java.util.Map;

public class HomeController extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }
    //
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


}
