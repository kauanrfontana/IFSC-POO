/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ads.poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Telefone> telefones = new ArrayList<Telefone>();
        ArrayList<Email> emails = new ArrayList<Email>();
        telefones.add(new Telefone("Pessoal", "+5549999856038"));
        emails.add(new Email("Pessoal", "kauanrfontana@gmail.com"));
        emails.add(new Email("Profissional", "kfontana@paytech.com.br"));
        Contato contato = new Contato("Kauan", "Ramos Fontana", LocalDate.of(2005, 6, 22), telefones, emails);


        System.out.println(contato);

    }
}