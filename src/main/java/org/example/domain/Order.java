package org.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {

    private double total;
    private double discount;

    public Order(double total) {
        super();
        this.total = total;
    }

}