/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ads.poo;

import ads.poo.produtos.Celular;
import ads.poo.produtos.Dimensao;
import ads.poo.produtos.SemFio;
import ads.poo.produtos.Telefone;

public class App {

    public static void main(String[] args) {
//        Telefone telefone = new Telefone(1, "123", "samsung", 300, new Dimensao(10,10,10));
//        Telefone telefoneSemFio = new SemFio(1, "123", "samsung", 200, new Dimensao(30,5,10), 2.4, 200, 1000);
//        SemFio a = (SemFio) telefoneSemFio;
//        System.out.println(telefone.imprimirDados());
//        System.out.println(telefoneSemFio.imprimirDados());
        Telefone[] t = new Telefone[4];
        SemFio s;
        Celular c;
        Celular d;

       t[0] = new Telefone(1, "12312", "Modelo", 500, new Dimensao(1,1,1));
        t[1] = new SemFio(1, "12312", "Modelo", 500, new Dimensao(1,1,1), 1,1,1);
        t[2] = new Celular(1, "12312", "Modelo", 500, new Dimensao(1,1,1), 1,1,1, "android");
        t[3] = new Celular(1, "12312", "Modelo", 500, new Dimensao(1,1,1), 1,1,1, "android");

        for(Telefone tel : t){
            System.out.println(tel.imprimirDados());

            if(tel instanceof Celular){
                System.out.println(((Celular) tel).getSO());
            }
        }
    }
}
