package com.example.exem.controller;

import com.example.exem.model.BenhAn;
import com.example.exem.service.BenhAnService;
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

@RestController
@CrossOrigin
@RequestMapping("/api/benhan")
public class BenhAnRestController {
    @Autowired
    private BenhAnService benhAnService;

    @GetMapping("/list")
    public ResponseEntity<Page<BenhAn>> findAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(benhAnService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BenhAn> create(@RequestBody @Validated BenhAn benhAn, BindingResult bindingResult) {
//        new BenhAnDto().validate(benhAnDto, bindingResult);
        if (!bindingResult.hasErrors()) {
            return new ResponseEntity<>(benhAnService.create(benhAn), HttpStatus.CREATED);
        } else {
            return null;
        }
    }

    @PutMapping("edit")
    public ResponseEntity<BenhAn> update(@RequestBody BenhAn benhAn) {
        return new ResponseEntity<>(benhAnService.update(benhAn), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BenhAn> delete(@PathVariable int id) {
        return new ResponseEntity<>(benhAnService.delete(id), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BenhAn> findById(@PathVariable int id) {
        return new ResponseEntity<>(benhAnService.finById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<BenhAn>> search(@RequestParam String search, @PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(benhAnService.search(search, pageable), HttpStatus.OK);
    }
}
