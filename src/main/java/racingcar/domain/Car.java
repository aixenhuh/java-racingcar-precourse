package racingcar.domain;

public class Car {
    private String name;
    private String progress;

    public Car(String name) {
        this.name = name;
        this.progress = "";
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }

    public void plusProgress() {
        this.progress += "-";
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarStatus run(int num) {
        if(inputNumCheck(num)) return CarStatus.GO;
        return CarStatus.STOP;
    }

    public boolean inputNumCheck(int num) {
        if(num >= 4) {
            plusProgress();
            return true;
        }
        return false;
    }

    public boolean isMaxProcess(int maxNum) {
        if(maxNum <= this.progress.length()) return true;
        return false;
    }


}
