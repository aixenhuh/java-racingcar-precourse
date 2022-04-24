package racingcar.domain;

import racingcar.view.PlayResult;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {

    private List<Car> cars;
    private int processMax;
    private List<Car> winnerCars;

    public Cars(String input) {
        cars = mappingCars(input);
        winnerCars = new ArrayList<>();
        processMax = 0;
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }

    public int getProcessMax() {
        return processMax;
    }
    public void setProcessMax(int processMax) {
        this.processMax = processMax;
    }

    public List<Car> mappingCars(String inputCars) {
        cars = new ArrayList<>();
        String[] split = inputCars.split(",");
        for(int i = 0; i < split.length; i++) cars.add(new Car(isNameCheck(split[i])));
        if(!checkCarNameComma(inputCars)) throw new IllegalArgumentException();
        return cars;
    }

    public CarStatus play() {
        PlayResult result = new PlayResult();
        for(int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.run(getRandomNum());
            result.getProcessPrint(car);
        }
        System.out.println("");
        return CarStatus.RUN_END;
    }

    public int getRandomNum() {
        return pickNumberInRange(0, 9);
    }

    public boolean checkCarNameComma(String nameStr) {
        return nameStr.contains(",");
    }

    public String isNameCheck(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        return name;
    }

    public int settingMaxProcess() {
        for(Car car : cars) setProcessMax(Math.max(getProcessMax(), car.getProgress().length()));
        return getProcessMax();
    }

    public void getBestProcessResultCar() {
        PlayResult playResult = new PlayResult();
        for(Car car : cars) compareBestCar(car);
        playResult.getResultPrint(getWinnerCars());
    }

    public void compareBestCar(Car car) {
        settingMaxProcess();
        if(car.isMaxProcess(getProcessMax())) winnerCars.add(car);
    }
}
