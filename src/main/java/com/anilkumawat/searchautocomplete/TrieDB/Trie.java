package com.anilkumawat.searchautocomplete.TrieDB;

import lombok.ToString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word, Long freq) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.next(c);
            node.addWord(word, freq);
        }
        node.isWord = true;
    }

    public List<String> search(String prefix) {
        Node node = root;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.containsKey(c)) {
                return result;
            }
            node = node.next(c);
        }

        node.words.entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(entry -> result.add(entry.getKey()));

        return result;
    }
}

@ToString
class Node {
    private final Map<Character, Node> children;
    final Map<String, Long> words;
    boolean isWord;

    public Node() {
        this.children = new HashMap<>();
        this.words = new HashMap<>();
        this.isWord = false;
    }

    public boolean containsKey(char c) {
        return children.containsKey(c);
    }

    public void put(char c, Node node) {
        children.put(c, node);
    }

    public Node next(char c) {
        return children.get(c);
    }

    public void addWord(String word, Long freq) {
        words.put(word, words.getOrDefault(word, 0L) + freq);
    }
}
