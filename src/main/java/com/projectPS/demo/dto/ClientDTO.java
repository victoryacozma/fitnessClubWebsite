package com.projectPS.demo.dto;
import com.projectPS.demo.model.Subscription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClientDTO {
    private Long id;
    private String name;
    private String address;
    private String password;
    //Subscription subscriptions;
}
