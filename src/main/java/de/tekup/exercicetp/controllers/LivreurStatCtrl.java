package de.tekup.exercicetp.controllers;

import de.tekup.exercicetp.services.LivreurStats;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LivreurStatCtrl {

    private LivreurStats livreurStats;

    @GetMapping("/livreur/rapide")
    public String LivreurRapide(){
        return livreurStats.LivreurRapide();
    }

    @GetMapping("/livreur/lent")
    public String LivreurLent(){
       return livreurStats.LivreurLent();
    }
}
