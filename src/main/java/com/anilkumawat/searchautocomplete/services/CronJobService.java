package com.anilkumawat.searchautocomplete.services;

import com.anilkumawat.searchautocomplete.TrieDB.Trie;
import com.anilkumawat.searchautocomplete.repositories.DataGatheringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CronJobService {
    private final Trie trie;
    private final DataGatheringRepository dataGatheringRepository;
    @Scheduled(cron = "0 0/2 * * * ?")
    public void executeTask() {
        List<Object[]> frequencies = dataGatheringRepository.findWordFrequencies();
        frequencies.forEach(record -> {
            String word = (String) record[0];
            Long frequency = (Long) record[1];
            trie.insert(word,frequency);
            System.out.println(word+" "+frequency);
        });
        dataGatheringRepository.deleteAll();
        System.out.println("Cron Job executed at: " + LocalDateTime.now());
    }
}
