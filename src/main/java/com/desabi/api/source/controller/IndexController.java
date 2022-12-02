package com.desabi.api.source.controller;

import com.desabi.api.source.model.response.IndexResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-source")
public class IndexController {

    @GetMapping("")
    public ResponseEntity<IndexResponse> index() {
        return new ResponseEntity<>(new IndexResponse("Api Source Funcionando"), HttpStatus.OK);
    }

}
