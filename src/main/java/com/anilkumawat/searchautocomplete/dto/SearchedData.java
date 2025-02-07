package com.anilkumawat.searchautocomplete.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SearchedData {
    private List<String> autoCompleteData;
}
