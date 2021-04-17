package com.projectPS.demo.controller;

import com.projectPS.demo.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fitness")
public class FitnessController {

    //injectam serviceul
    private final SubscriptionService subscriptionService;

    public FitnessController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping()
    public String findAll(){
        return "Hello, pitch";
    }

    /*@GetMapping()
    public FitnessAbonament findAll(){
        return abonamentService.findAbonamentByDurata(28);
    }*/

    /*@GetMapping("/{nr}")
    public ResponseEntity findByDurata(int nr){
        return ResponseEntity.status(HttpStatus.OK).body(abonamentService.findAbonamentByDurata(nr));
    }*/

    //e mai indicat cu ResponseEntity
    @GetMapping("/{nr}")
    public ResponseEntity findByDurata(@PathVariable int nr){
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionService.findAbonamentByDurata(nr));
    }



}
