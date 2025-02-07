package com.anilkumawat.searchautocomplete.services.Impl;

import com.anilkumawat.searchautocomplete.TrieDB.Trie;
import com.anilkumawat.searchautocomplete.dto.SearchedData;
import com.anilkumawat.searchautocomplete.entities.DataGathering;
import com.anilkumawat.searchautocomplete.repositories.DataGatheringRepository;
import com.anilkumawat.searchautocomplete.services.SearchAutoCompleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchAutoCompleteServiceImpl implements SearchAutoCompleteService {
    private final Trie trie;
    private final DataGatheringRepository dataGatheringRepository;
    @Override
    public SearchedData searchAutoComplete(String word) {
        DataGathering dataGathering = DataGathering.builder()
                        .word(word)
                                .build();
        dataGatheringRepository.save(dataGathering);
        SearchedData searchedData = SearchedData.builder()
                .autoCompleteData(trie.search(word))
                .build();
        return searchedData;
    }
}
