package revisaoJava;
import java.util.Scanner; 

public class Media {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Entre com sua nota do primeiro projeto prático: ");
        Float firstProject = keyboard.nextFloat();

        System.out.print("Entre com sua nota do segundo projeto prático: ");
        Float secondProject = keyboard.nextFloat();

        System.out.print("Entre com sua nota de participação: ");
        Float participation = keyboard.nextFloat();

        Float average = (firstProject + secondProject + participation) / 3;

        String state = "";
        if(average >= 6) {
            state = " Aprovado";
        }else {
            state = " Reprovado";
        }
        


        System.out.println("Seu conceito final é: " + Math.round(average) + state);


        
        keyboard.close();
    }
}
