package homework.annotations.task1.model;

import homework.annotations.task1.annotations.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MyAnnotation
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productName;
    private Integer price;
}


