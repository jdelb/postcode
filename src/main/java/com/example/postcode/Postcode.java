package com.example.postcode;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PostcodeId.class)
public class Postcode implements Serializable {

    @Id
    @Min(value=0, message="Code should be within 0 and 9999")
    @Max(value=9999, message="Code should be within 0 and 9999")
    private int code;
    
    @Id
    @NotEmpty(message = "Name cannot be empty.")
    @Size(min=2, message="The name should have at least 2 characters")
    private String name;
}
