package com.usedcar.admin.web.dto.release;

import com.usedcar.admin.domain.car.Car;
import com.usedcar.admin.domain.release.Release;
import com.usedcar.admin.domain.release.ReleaseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@ToString
public class ReleaseSaveRequestDto {

    @NotEmpty
    private String staff;

    @NotEmpty
    private String salesStaff;

    @Min(0)
    private int price;

    @Min(0)
    private int deposit;

    @NotNull
    private Long carId;

    @NotNull
    private ReleaseStatus status;

    @Builder
    public ReleaseSaveRequestDto(String staff, String salesStaff, int price, int deposit, Long carId, ReleaseStatus status) {
        this.staff = staff;
        this.salesStaff = salesStaff;
        this.price = price;
        this.deposit = deposit;
        this.carId = carId;
        this.status = status;
    }

    public Release toEntity() {
        return Release.builder()
                .staff(staff)
                .salesStaff(salesStaff)
                .price(price)
                .deposit(deposit)
                .status(status)
                .build();
    }

}