package homework.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private Integer id;
    private String city;
    private Integer home;
    private Integer appartment;

    public Address(String city, Integer home, Integer appartment) {
        this.city = city;
        this.home = home;
        this.appartment = appartment;
    }
}
