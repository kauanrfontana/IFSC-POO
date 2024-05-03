/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ads.poo;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public Agenda agenda;

    public static void main(String[] args) {
        ArrayList<Telefone> telefones = new ArrayList<Telefone>();
        ArrayList<Email> emails = new ArrayList<Email>();
        telefones.add(new Telefone("Pessoal", "+5549999856038"));
        emails.add(new Email("Pessoal", "kauanrfontana@gmail.com"));
        emails.add(new Email("Profissional", "kfontana@paytech.com.br"));
        Contato contato = new Contato("Kauan", "Ramos Fontana", LocalDate.of(2005, 6, 22), telefones, emails);

        ArrayList<Telefone> telefonesP = new ArrayList<Telefone>();
        ArrayList<Email> emailsP = new ArrayList<Email>();
        telefonesP.add(new Telefone("Pessoal", "+5548992344028"));
        emailsP.add(new Email("Pessoal", "pessoa@a.com"));
        emailsP.add(new Email("Profissional", "pessoa@job.com.br"));
        Contato contatoP = new Contato("Pessoa", "Surname", LocalDate.of(1999, 1, 1), telefonesP, emailsP);

        ArrayList<Contato> contatos = new ArrayList<Contato>();
        contatos.add(contato);
        contatos.add(contatoP);
        App app = new App();
        app.agenda = new Agenda(contatos);
        app.menu();


    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        int op;
        while(true){
            System.out.println("1. Listar Contatos.");
            System.out.println("2. Listar Dados de Um Contato.");
            System.out.println("3. Adicionar Contato.");
            System.out.println("4. Remover Contato.");
            System.out.println("5. Opções para Dados de Um Contato.");
            System.out.print("\nSelecione uma opção: ");
            op = sc.nextInt();
            switch (op){
                case 1:
                    System.out.println(this.agenda);
                    break;
                case 2:
                    System.out.print("\nQual é o identificador do contato desejado? ");
                    op = sc.nextInt();
                    try {
                        System.out.println(this.agenda.getContato(op));
                        break;
                    } catch (Exception e){
                        System.out.println("\nNão foi encontrado nenhum contato com esse identificador!");
                        break;
                    }
                case 3:
                    System.out.print("\nInforme os nome, sobrenome, e data de nascimento do contato(22-06-2005): ");
                    sc.nextLine();
                    String dadosPrimarios = sc.nextLine().replaceAll(" ", "");
                    if(dadosPrimarios.split(",").length != 3){
                        throw new InvalidParameterException();
                    }
                    String nome  = dadosPrimarios.split(",")[0];
                    String sobrenome = dadosPrimarios.split(",")[1];
                    LocalDate dataNasc = formataData(dadosPrimarios.split(",")[2]);

                    System.out.print("\nAgora informe os telefones do contato(pessoal:+554899999999, profissional:+5549...): ");
                    String dadosTelefonicos = sc.nextLine().replaceAll(" ", "");
                    if(dadosTelefonicos.split(":").length < 2){
                        throw new InvalidParameterException();
                    }
                    ArrayList<Telefone> telefones = new ArrayList<Telefone>();
                    for(String telefone : dadosTelefonicos.split(",")){
                        telefones.add(new Telefone(telefone.split(":")[0], telefone.split(":")[1]));
                    }

                    System.out.print("\nPor fim informe os emails do contato(pessoal:a@a.com, profissional:b@b.com...): ");
                    String dadosEmail = sc.nextLine().replaceAll(" ", "");
                    if(dadosEmail.split(":").length < 2){
                        throw new InvalidParameterException();
                    }

                    ArrayList<Email> emails = new ArrayList<Email>();
                    for(String email : dadosEmail.split(",")){
                        emails.add(new Email(email.split(":")[0], email.split(":")[1]));
                    }

                    if(this.agenda.addContato(new Contato(nome, sobrenome, dataNasc, telefones, emails))){
                        System.out.println("\nContato adicionado com sucesso!");
                    }
                    break;
                case 4:
                    System.out.print("\nInforme o identificador do contato que deseja remover: ");
                    int id = sc.nextInt();
                    if(this.agenda.removeContato(id)){
                        System.out.println("\nContato removido com sucesso!");
                    }else{
                        System.out.println("\nNão foi encontrado nenhum contato com este identificador!");
                    }
                    break;
                case 5:
                    opcoesContato(sc);
                    break;
                default:
                    System.out.println("\nNão foi encontrada nenhuma opção para o valor digitado!");

            }

            System.out.print("\nPara executar outra ação digite 1, ou outro número para finalizar o programa: ");
            op = sc.nextInt();
            if(op != 1){
                return;
            }

        }
    }

    private void opcoesContato(Scanner sc){
        System.out.print("\nQual é o identificador do contato desejado? ");
        int id = sc.nextInt();
        try {
            if(this.agenda.getContato(id) != null){
                System.out.println("1. Atualizar Contato.");
                System.out.println("2. Adicionar Telefone ao Contato.");
                System.out.println("3. Adicionar Email ao Contato.");
                System.out.println("4. Remover Telefone do Contato.");
                System.out.println("5. Remover Email do Contato.");

                int op = sc.nextInt();

                switch (op){
                    case 1:
                        System.out.print("\nInforme os nome, sobrenome, e data de nascimento do contato(22-06-2005): ");
                        sc.nextLine();
                        String dadosPrimarios = sc.nextLine().replaceAll(" ", "");
                        if(dadosPrimarios.split(",").length != 3){
                            throw new InvalidParameterException();
                        }
                        String nome  = dadosPrimarios.split(",")[0];
                        String sobrenome = dadosPrimarios.split(",")[1];
                        LocalDate dataNasc = formataData(dadosPrimarios.split(",")[2]);

                        System.out.print("\nAgora informe os telefones do contato(pessoal:+554899999999, profissional:+5549...): ");
                        String dadosTelefonicos = sc.nextLine().replaceAll(" ", "");
                        if(dadosTelefonicos.split(":").length < 2){
                            throw new InvalidParameterException();
                        }
                        ArrayList<Telefone> telefones = new ArrayList<Telefone>();
                        for(String telefone : dadosTelefonicos.split(",")){
                            telefones.add(new Telefone(telefone.split(":")[0], telefone.split(":")[1]));
                        }

                        System.out.print("\nPor fim informe os emails do contato(pessoal:a@a.com, profissional:b@b.com...): ");
                        String dadosEmail = sc.nextLine().replaceAll(" ", "");
                        if(dadosEmail.split(":").length < 2){
                            throw new InvalidParameterException();
                        }

                        ArrayList<Email> emails = new ArrayList<Email>();
                        for(String email : dadosEmail.split(",")){
                            emails.add(new Email(email.split(":")[0], email.split(":")[1]));
                        }

                        if(this.agenda.updateContato(id, new Contato(nome, sobrenome, dataNasc, telefones, emails))){
                            System.out.println("\nContato atualizado com sucesso!");
                        }
                        break;
                    case 2:
                        System.out.print("\nInforme o telefones para adicionar ao contato(pessoal:+554899999999): ");
                        sc.nextLine();
                        String telefone = sc.nextLine().replaceAll(" ", "");
                        if(telefone.split(":").length < 2){
                            throw new InvalidParameterException();
                        }
                        if(this.agenda.addTelefone(id, new Telefone(telefone.split(":")[0], telefone.split(":")[1]))){
                            System.out.println("\nTelefone adicionado com sucesso!");
                        }
                        break;
                    case 3:
                        System.out.print("\nInforme o email para adicionar ao contato(pessoal:a@a.com): ");
                        sc.nextLine();
                        String email = sc.nextLine().replaceAll(" ", "");
                        if(email.split(":").length < 2){
                            throw new InvalidParameterException();
                        }
                        if(this.agenda.addEmail(id, new Email(email.split(":")[0], email.split(":")[1]))){
                            System.out.println("\nEmail adicionado com sucesso!");
                        }
                        break;
                    case 4:
                        System.out.print("\nInforme o identificador do telefone que deseja remover: ");
                        int telId = sc.nextInt();
                        if(this.agenda.removeTelefone(id, telId)){
                            System.out.println("\nTelefone removido com sucesso!");
                        }else{
                            System.out.println("\nNão foi encontrado nenhum telefone com este identificador!");
                        }
                        break;
                    case 5:
                        System.out.print("\nInforme o identificador do email que deseja remover: ");
                        int emailId = sc.nextInt();
                        if(this.agenda.removeEmail(id, emailId)){
                            System.out.println("\nEmail removido com sucesso!");
                        }else{
                            System.out.println("\nNão foi encontrado nenhum email com este identificador!");
                        }
                        break;
                    default:
                        System.out.println("\nNão foi encontrada nenhuma opção para o valor digitado!");

                }
            }
        }catch (Exception e){
            switch (e) {
                case IndexOutOfBoundsException indexOutOfBoundsException -> {
                    System.out.println("\nNão foi encontrado nenhum contato com esse identificador!");
                }
                case InvalidParameterException invalidParameterException -> {
                    System.out.println("\nParâmetros informados de forma inválida!");
                }
                case IllegalArgumentException illegalArgumentException -> {
                    System.out.println("\nEmail em formato inválido!");
                }
                default -> {
                    System.out.println("\nErro ao atualizar contato!");
                }
            }

        }
    }

    private LocalDate formataData(String data){
        int[] partesData = new int[3];
        partesData[0] = Integer.parseInt(data.split("-")[0]);
        partesData[1] = Integer.parseInt(data.split("-")[1]);
        partesData[2] = Integer.parseInt(data.split("-")[2]);
        return LocalDate.of(partesData[2], partesData[1], partesData[0]);
    }

}
