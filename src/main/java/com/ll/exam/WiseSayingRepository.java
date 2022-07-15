package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    int wiseSayingLastId;
    List<WiseSaying> wiseSayings;

    WiseSayingRepository() {
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }
    public WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings){
            if (wiseSaying.id == paramId)
                return wiseSaying;
        }
        return null;
    }
}
