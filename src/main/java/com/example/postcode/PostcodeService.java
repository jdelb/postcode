package com.example.postcode;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.*;

@Service
public class PostcodeService {

    @Autowired
    private PostcodeRepository postcodeRepository;

    public void savePostcodes(List<Postcode> postcodes) {
        postcodeRepository.saveAll(postcodes);
    }

    PostcodeResponseDTO getPostcodeNamesWithinCodeRange(Integer start, Integer end) {
        List<Postcode> postcodes = postcodeRepository.findByCodeBetweenOrderByNameAsc(start, end);
        List<String> names = postcodes.stream().map(p -> p.getName()).collect(toList());
        int totalCharacters = postcodes.stream().mapToInt(n -> n.getName().length()).sum();
        return new PostcodeResponseDTO(totalCharacters, names);
    }
}
