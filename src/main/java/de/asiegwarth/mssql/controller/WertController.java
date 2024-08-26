package de.asiegwarth.mssql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.asiegwarth.mssql.service.WertService;

@RestController
@CrossOrigin
public class WertController {
    
    @Autowired
    WertService wertServ;

    @GetMapping("/werte")
    private ResponseEntity getAllWerte() {
        return wertServ.getAllWerte();
    }

}