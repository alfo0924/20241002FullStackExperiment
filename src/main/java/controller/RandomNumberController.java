package controller;

import org.example._20241002fullstackexperiment.model.RandomNumber;
import org.example._20241002fullstackexperiment.repository.RandomNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RandomNumberController {

    @Autowired
    private RandomNumberRepository repository;

    @PostMapping("/save-random-number")
    public RandomNumber saveRandomNumber(@RequestBody RandomNumber randomNumber) {
        return repository.save(randomNumber);
    }

    @GetMapping("/get-random-numbers")
    public List<RandomNumber> getRandomNumbers() {
        return repository.findAll();
    }
}