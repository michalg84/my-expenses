package pl.sda.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by Michał Gałka on 2017-05-22.
 */
public class CategoryDto {
    private Integer id;
    @NotNull(message = "Please insert name")
    @Range(min = 3, max = 40, message = "Name length range is 3-40 signs")
    private String name;

    public CategoryDto() {
    }    ;

    public CategoryDto(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
