package entity;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Drink {
    private String name;
    private double price;
    private String toast;
}
