package com.anilkumawat.searchautocomplete.config;

import com.anilkumawat.searchautocomplete.TrieDB.Trie;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrieConfig {
    @Bean
    Trie trie(){
        return new Trie();
    }
}
