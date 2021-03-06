package com.usedcar.admin.web.dto.car;

import com.usedcar.admin.domain.car.Car;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CarSaveResponseDto {

    private Long id;

    public CarSaveResponseDto(Car car) {
        this.id = car.getId();
    }

}
