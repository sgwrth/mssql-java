package de.asiegwarth.mssql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.asiegwarth.mssql.entity.Wert;
import de.asiegwarth.mssql.repository.WertRepository;

public interface WertService {

    @Service
    class WertServiceImpl implements WertService {

        @Autowired
        WertRepository wertRepo;

        @Override
        public ResponseEntity getAllWerte() {
            List<Wert> werte = wertRepo.findAll();
            return ResponseEntity.ok(werte);
        }

    }
    
    ResponseEntity getAllWerte();
}