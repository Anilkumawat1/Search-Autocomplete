package com.anilkumawat.searchautocomplete.controllers;

import com.anilkumawat.searchautocomplete.dto.SearchedData;
import com.anilkumawat.searchautocomplete.services.SearchAutoCompleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autocomplete")
@RequiredArgsConstructor
public class SearchAutoComplete {
    private final SearchAutoCompleteService searchAutoCompleteService;
    @GetMapping(path = "/search")
    public ResponseEntity<SearchedData> searchProductsByName(@RequestParam String word){
       return ResponseEntity.ok(searchAutoCompleteService.searchAutoComplete(word));
    }

}
