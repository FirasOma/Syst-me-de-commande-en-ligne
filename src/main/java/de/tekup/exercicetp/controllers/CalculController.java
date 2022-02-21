package de.tekup.exercicetp.controllers;

import de.tekup.exercicetp.services.CalculService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculController {

    private CalculService calculService;
    @GetMapping("/calcul/totalorder/{id}")
    public float CalculTotal(@PathVariable int id){
        return calculService.CalculTotal(id);
    }

    @GetMapping("/calcul/orderweight/{id}")
    public float CalculateWeight(@PathVariable int id){
        return calculService.CalculateWeight(id);
    }
}
