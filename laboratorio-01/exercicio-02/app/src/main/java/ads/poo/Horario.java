package ads.poo;

public class Horario {

    private int horas;
    private int minutos;
    private int segundos;

    public Horario(int horas, int minutos, int segundos){
        if(horasInvalidas(horas) || minutosInvalidos(minutos) || segundosInvalidos(segundos)) {
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
            return;
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Horario(int horas, int minutos){
        this(horas, minutos, 0);
    }

    public Horario(int horas){
        this(horas, 0, 0);
    }


    @Override
    public String toString() {
        String horas = Integer.toString(this.horas);
        String minutos = Integer.toString(this.minutos);
        String segundos = Integer.toString(this.segundos);
        if(this.horas < 10){
            horas = "0" + this.horas;
        }
        if(this.minutos < 10){
            minutos = "0" + this.minutos;
        }
        if(this.segundos < 10){
            segundos = "0" + this.segundos;
        }

        return horas + ":" + minutos + ":" + segundos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if(horasInvalidas(horas)) return;
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        if(minutosInvalidos(minutos)) return;
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        if(segundosInvalidos(segundos)) return;
        this.segundos = segundos;
    }

    public boolean horasInvalidas(int horas){
        if(horas < 0 || horas > 23) return true;
        return false;
    }

    public boolean minutosInvalidos(int minutos){
        if(minutos < 0 || minutos > 60) return true;
        return false;
    }

    public boolean segundosInvalidos(int segundos){
        if(segundos < 0 || segundos > 60) return true;
        return false;
    }

    public String numeroParaExtenso(int numero){
        switch (numero){
            case 1:
                return "um";
                break;
            case 2:
                return "dois";
                
        }
    }
}
