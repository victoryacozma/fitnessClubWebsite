package com.projectPS.demo.controller;

import com.projectPS.demo.dto.ClientDTO;
import com.projectPS.demo.service.ClientService;
import com.projectPS.demo.service.SubscriptionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    //injectam serviceul
    private final ClientService clientService;

    public ClientController(ClientService clientService) {this.clientService = clientService; }

    @ApiOperation(value = "Return a list of all clients")
    @GetMapping()
    public ResponseEntity findAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity findClientById(@ApiParam(value = "Requires an id") @PathVariable Long id) throws com.ps.aplicatie.exceptions.ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findClientByCNP(id));
    }

    @GetMapping("/idAndSubscr/{id}")
    public ResponseEntity findClientByIdAndSubscr(@ApiParam(value = "Requires an id") @PathVariable Long id) throws com.ps.aplicatie.exceptions.ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findClientByCNP(id).getSubscriptions());
    }

    @PutMapping()
    public ResponseEntity updateClientInfo(@RequestBody ClientDTO dto)throws com.ps.aplicatie.exceptions.ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(dto));
    }



    /*@GetMapping("/{name}")
    public ResponseEntity findClientByName(@ApiParam(value = "Requires a name") @PathVariable String name) throws com.ps.aplicatie.exceptions.ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findClientByName(name));
    }*/
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
