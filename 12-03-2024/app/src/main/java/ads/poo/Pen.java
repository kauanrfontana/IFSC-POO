/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ads.poo;


public class Pen {
    private String color = "Preta";
    private int capacity = 100;

    public String drawing(){
        if(capacity == 0){
            return "Impossível desenhar, caneta está sem tinta.";
        }
        capacity--;
        return "Desenhando com a cor " + color + "...";
    }

    public void setColor(String color){
        this.color = color;
    }

    public int getCapacity(){
        return capacity;
    }

}
