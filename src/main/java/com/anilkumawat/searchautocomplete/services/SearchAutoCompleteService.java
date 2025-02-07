package com.anilkumawat.searchautocomplete.services;

import com.anilkumawat.searchautocomplete.controllers.SearchAutoComplete;
import com.anilkumawat.searchautocomplete.dto.SearchedData;
import org.springframework.stereotype.Service;


public interface SearchAutoCompleteService {
    SearchedData searchAutoComplete(String word);
}
