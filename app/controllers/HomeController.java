package controllers;

import play.mvc.*;
import java.util.Map;

public class HomeController extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result olaMundo(){
      return ok("Ola Mundo!");
    }

    public Result somaPost() {
      return ok(views.html.formSomaPost.render());
    }

    public Result formSomaPost() {
      Map<String, String[]> r =
          request().body().asFormUrlEncoded();
      int a  = Integer.parseInt(r.get("a")[0]);
      int b  = Integer.parseInt(r.get("b")[0]);

      return ok(views.html.respostaSoma.render(a, b, a+b));
    }

    public Result maior2Post(){
      return ok(views.html.formMaior2.render());
    }

    public Result maior2(){
      Map<String, String[]> r =
          request().body().asFormUrlEncoded();
      int a  = Integer.parseInt(r.get("a")[0]);
      int b  = Integer.parseInt(r.get("b")[0]);
      if(a > b)
        return ok(views.html.respostaMaior2.render(a, b, "é maior que"));
      else{
        return ok(views.html.respostaMaior2.render(a, b, "não é maior que"));
      }
    }

    public Result maior5Post(){
      return ok(views.html.formMaior5.render());
    }

    public Result maior5(){
      int maior, i;
      int [] listaNum = new int[5];
      Map<String, String[]> r =
          request().body().asFormUrlEncoded();
      int a  = Integer.parseInt(r.get("a")[0]);
      listaNum[0] = a;
      int b  = Integer.parseInt(r.get("b")[0]);
      listaNum[1] = b;
      int c  = Integer.parseInt(r.get("c")[0]);
      listaNum[2] = c;
      int d  = Integer.parseInt(r.get("d")[0]);
      listaNum[3] = d;
      int e  = Integer.parseInt(r.get("e")[0]);
      listaNum[4] = e;
      maior = listaNum[0];
      for(i = 1; i < 5 ;i++){
        if(listaNum[i] > maior)
            maior = listaNum[i];
      }
      return ok(views.html.respostaMaior5.render("O maior dos números é: ", maior));
    }

    public Result vogaisPost(){
      return ok(views.html.formVogais.render());
    }

    public Result vogais(){
      Map<String, String[]> r =
          request().body().asFormUrlEncoded();
      String palavra = String.valueOf(r.get("vogais")[0]);
      palavra.split(" ");
      int qtd = 0;
      palavra.toLowerCase();
      for(int i = 0; i < palavra.length(); i++){
        if(palavra.charAt(i) == 'a' || palavra.charAt(i) == 'e' ||
        palavra.charAt(i) == 'i' || palavra.charAt(i) == 'o' ||
        palavra.charAt(i) == 'u'){
          qtd++;
        }
      }
      return ok(views.html.respostaVogais.render("A quantidade de vogais da palavra é: ", qtd));
    }

    public Result imparPost(){
      return ok(views.html.formImpar.render());
    }

    public Result impar(){
      Map<String, String[]> r = request().body().asFormUrlEncoded();
      int a = Integer.parseInt(r.get("valor")[0]);
      if(a%2 == 0){
        return ok(views.html.respostaImpar.render(a, "não é ímpar"));
      }
      else{
        return ok(views.html.respostaImpar.render(a, "é ímpar"));
      }
    }

    //falta fazer
    public Result intervaloAeB(int a, int b){
      String s = new String();
      for(int i = a; i <= b; i++){
        s += i + " ";
      }
      return ok(s);
    }

    public Result fatorial(int a){
      int fat = a;
      for(int i = 1; i < a; i++){
        fat *= i;
      }
      return ok(Integer.toString(fat));
    }

    public Result divisores(int a){
      String lista = new String();
      for(int i = 1; i <= (a/2); i++){
        if(a%i == 0){
          lista += i + " ";
        }
      }
      return ok(lista + a);
    }

    public Result mdc(int a, int b){
      while (a != 0) {
        int temp = a;
        a = b % a;
        b = temp;
      }
      return ok("O mdc dos dois números é: " + b);
    }

    public Result transcreveNumero(String n)
      {
          int i;
          String result = "";
          for(i = 0; i < n.length(); i++)
          {
              char x = n.charAt(i);

              switch (x) {
                  case '0':
                      result += "Zero ";
                  break;
                  case '1':
                      result += "Um ";
                  break;
                  case '2':
                      result += "Dois ";
                  break;
                  case '3':
                      result += "Três ";
                  break;
                  case '4':
                      result += "Quatro ";
                  break;
                  case '5':
                      result += "Cinco ";
                  break;
                  case '6':
                      result += "Seis ";
                  break;
                  case '7':
                      result += "Sete ";
                  break;
                  case '8':
                      result += "Oito ";
                  break;
                  case '9':
                      result += "Nove ";
                  break;
                  default:

                  break;
              }
          }
          return ok(result);
      }
}
