package com.projectPS.demo.controller;

import com.projectPS.demo.service.ClientService;
import com.projectPS.demo.service.SubscriptionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin
public class SubscriptionController {

    //injectam serviceul
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {this.subscriptionService = subscriptionService; }

    @ApiOperation(value = "Return a list of all subscriptions")
    @GetMapping()
    public ResponseEntity findAllSubscriptions(){
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionService.findAll());
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
  /*  @GetMapping("/{nr}")
    public ResponseEntity findByDurata(@PathVariable int nr){
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionService.findAbonamentByDurata(nr));
    }
*/
}
