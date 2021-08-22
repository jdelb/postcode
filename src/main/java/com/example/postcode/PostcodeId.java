package com.example.postcode;

import java.io.Serializable;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostcodeId implements Serializable {
    private int code;
    private String name;
}
