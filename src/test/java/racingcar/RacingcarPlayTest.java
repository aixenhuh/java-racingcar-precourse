package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarStatus;
import racingcar.domain.Cars;
import racingcar.view.PlayResult;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarPlayTest extends NsTest {

    @Test
    void 랜덤_이동_테스트() {
        Car car = new Car("poby");
        assertThat(car.run(4).equals(CarStatus.GO)).isTrue();
        assertThat(car.run(3).equals(CarStatus.STOP)).isTrue();
    }

    @Test
    void 랜덤_숫자_범위_체크() {
        Cars cars = new Cars(Arrays.asList(new Car("poby")));
        assertThat(cars.getRandomNum()).isBetween(0, 9);
    }

    @Test
    void 자동차_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars(Arrays.asList(new Car("poby")));
                    CarStatus play = cars.play();
                    assertThat(play.equals(CarStatus.GO));
                },
                4, 3
        );
    }

    @Test
    void 자동차_진행_출력() {
        assertSimpleTest(
                () -> {
                    Car car = new Car("poby");
                    PlayResult.getProcessPrint(car);
                    assertThat(output()).contains(car.getName() + " :");
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
