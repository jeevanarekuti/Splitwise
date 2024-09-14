package com.example.Splitwise.controllers;

import com.example.Splitwise.dtos.SettleUserRequestDTO;
import com.example.Splitwise.models.Transaction;
import com.example.Splitwise.services.SettleUpService;

import java.util.List;

public class SettleUpController {

    private final SettleUpService settleUpService;
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public List<Transaction> SettleUser(SettleUserRequestDTO dto){
        return settleUpService.settleUser(dto.getUserId());
    }

    public List<Transaction> SettleGroup(){
        return null;
    }
}
