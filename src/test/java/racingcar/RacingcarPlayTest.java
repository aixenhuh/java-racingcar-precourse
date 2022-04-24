package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarPlayTest {

    @Test
    void 랜덤_이동_테스트() {
        Car car = new Car("poby");
        assertThat(car.run(4).equals(CarStatus.GO)).isTrue();
        assertThat(car.run(3).equals(CarStatus.STOP)).isTrue();
    }
}
