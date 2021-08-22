package com.example.postcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostcodeResponseDTO {
    private Integer totalCharacters;
    private List<String> names;
}
