package com.example.postcode;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class PostcodeController {

    @Autowired
    private PostcodeService postcodeService;

    @PostMapping("/postcode")
    void savePostcodes(@RequestBody @NotEmpty(message = "Postcodes cannot be empty.") List<@Valid Postcode> postcodes) {
        postcodeService.savePostcodes(postcodes);
    }
    
    @GetMapping("/postcode-range")
    PostcodeResponseDTO getPostcodeNamesWithinCodeRange(
        @RequestParam 
        @Min(value=0, message="Code should be within 0 and 9999") Integer start, 
        @RequestParam @Max(value=9999, message="Code should be within 0 and 9999") Integer end) {
            return postcodeService.getPostcodeNamesWithinCodeRange(start, end);
    }
}
