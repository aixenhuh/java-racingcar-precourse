package racingcar.service;

import racingcar.domain.Cars;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarService {

    private static Cars cars;

    public void inputRacingCar(){
        String inputStr = readLine();
        cars = new Cars(inputStr);
    }

    public void play() {
        int tryNum = Integer.parseInt(readLine());
        for(int i = 0; i < tryNum; i++) cars.play();
        cars.getBestProcessResultCar();
    }
}
