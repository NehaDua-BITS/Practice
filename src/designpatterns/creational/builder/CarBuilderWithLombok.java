package designpatterns.creational.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarBuilderWithLombok {
    private String brand;
    private String color;
    private int airbags;
    private int year;
    private float distance;
    private int seats;
}
