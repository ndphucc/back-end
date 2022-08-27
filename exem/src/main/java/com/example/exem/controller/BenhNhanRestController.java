package com.example.exem.controller;

import com.example.exem.model.BenhAn;
import com.example.exem.model.BenhNhan;
import com.example.exem.service.BenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/benhnhan")
public class BenhNhanRestController {
    @Autowired
    private BenhNhanService benhNhanService;

    @GetMapping("/list")
    public ResponseEntity<List<BenhNhan>> findAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(benhNhanService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BenhNhan> findById(@PathVariable int id) {
        return new ResponseEntity<>(benhNhanService.findById(id), HttpStatus.OK);
    }
}
