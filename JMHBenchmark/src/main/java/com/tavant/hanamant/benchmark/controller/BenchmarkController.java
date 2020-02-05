package com.tavant.hanamant.benchmark.controller;

import com.tavant.hanamant.benchmark.model.SearchModel;
import com.tavant.hanamant.benchmark.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/algorithms")
public class BenchmarkController {

    @Autowired
    AlgorithmService service;

    @PostMapping(value = "/linearsearch")
    public ResponseEntity linearSearch(@RequestBody SearchModel model) {
        if(model.getSearchList() == null || model.getSearchList().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } else {
            Integer searchResult = service.linearSearch(model);
            return ResponseEntity.ok(searchResult);
        }
    }


    @PostMapping(value = "/binarysearch")
    public ResponseEntity binarySearch(@RequestBody SearchModel model) {
        if(model.getSearchList() == null || model.getSearchList().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } else {
            Integer searchResult = service.binarySearch(model);
            return ResponseEntity.ok(searchResult);
        }
    }

}
