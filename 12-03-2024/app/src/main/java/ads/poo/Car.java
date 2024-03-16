package ads.poo;
public class Car {
    private int currentSpeed;
    private int underLimit = 0;
    private int aboveLimit = 200;

    public int getUnderLimit() {
        return underLimit;
    }

    public void setUnderLimit(int underLimit) {
        this.underLimit = underLimit;
    }

    public int getAboveLimit() {
        return aboveLimit;
    }

    public void setAboveLimit(int aboveLimit) {
        this.aboveLimit = aboveLimit;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Car(int currentSpeed) {
        if(this.isAboveLimit(currentSpeed) || this.isUnderLimit(currentSpeed)){
            this.currentSpeed = 0;
            return;
        }
        this.currentSpeed = currentSpeed;
    }
    public Car() {
        this(0);
    }

    public void speedUp(int plusSpeed){
        if(plusSpeed < 0) return;
        if(this.isAboveLimit(this.currentSpeed + plusSpeed)){
            this.currentSpeed = 200;
            return;
        }
        this.currentSpeed += plusSpeed;
    }

    public void speedDown(int menusSpeed){
        if(menusSpeed < 0) return;
        if(this.isUnderLimit(this.currentSpeed - menusSpeed)){
            this.currentSpeed = 0;
            return;
        }
        this.currentSpeed -= menusSpeed;
    }

    public boolean isAboveLimit(int number){
        return number > this.aboveLimit;
    }

    public boolean isUnderLimit(int number){
        return number < this.underLimit;
    }

}
