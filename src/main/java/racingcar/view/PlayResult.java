package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class PlayResult {

    public void getProcessPrint(Car car) {
        System.out.println(car.getName() + " : " + car.getProgress());
    }

    public void getResultPrint(List<Car> cars) {
        List<String> result = new ArrayList<>();
        for(Car car : cars) {
            result.add(car.getName());
        }
        System.out.println("최종 우승자: " + String.join(",", result));
    }




}
