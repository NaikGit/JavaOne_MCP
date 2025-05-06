package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PresentationTools {
    private List<Presentation> presentations = new ArrayList<>();

    public PresentationTools(){
        var keyNoteOne =  new Presentation("Java 24 launch" ,"https://www.youtube.com/watch?v=6k2Kb3X4dZw" , 2024);
        var ketNoteTwo = new Presentation("Java turns 30" ,"https://www.youtube.com/watch?v=6k2Kb3X4dZw" , 2024);
        var concertto = new Presentation("Concerto for Java and AI" ,"https://www.youtube.com/watch?v=6k2Kb3X4dZw" , 2024);
        var gatherers = new Presentation("Stream Gatherers" ,"https://www.youtube.com/watch?v=6k2Kb3X4dZw" , 2024);
        var ai202 = new Presentation("AI 202 - Next level AI mastery for Java developers" ,"https://www.youtube.com/watch?v=6k2Kb3X4dZw" , 2024);

        this.presentations.addAll(List.of(keyNoteOne,ketNoteTwo,concertto,gatherers,ai202));
    }

    public List<Presentation> getPresentations() { return this.presentations; }



    public List<Presentation> getPresentationsByYear(int year) {
        return presentations.stream().filter(p -> p.year() == year).toList();
    }

    public List<Map<String, Object>> getPresentationsAsMapList() {
        return presentations.stream()
                .map(p -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("title", p.title());
                    map.put("url", p.url());
                    map.put("year", p.year());
                    return map;
                })
                .collect(Collectors.toList());
    }

}
