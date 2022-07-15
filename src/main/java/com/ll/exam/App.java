package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    int wiseSayingLastId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    void run(){
        System.out.println("=== 명언 SSG ===");

        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()) {
                case "등록":
                    write(rq);
                    continue;
                case "목록":
                    list(rq);
                    continue;
                case "수정":
                    modify(rq);
                    continue;
                case "삭제":
                    remove(rq);
                    continue;
                case "종료":
                    break outer;
            }
        }
    }
    private WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings){
            if (wiseSaying.id == paramId)
                return wiseSaying;
        }
        return null;
    }
    private void write(Rq rq) {
        ++wiseSayingLastId;
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        System.out.println(wiseSayingLastId + "번 명언이 등록되었습니다.");
        WiseSaying wiseSaying = new WiseSaying(wiseSayingLastId, content, author);
        wiseSayings.add(wiseSaying);
    }
    private void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying_ = new WiseSaying();
            wiseSaying_ = wiseSayings.get(i);
            System.out.println(wiseSaying_.id + " / " + wiseSaying_.content + " / " + wiseSaying_.author);
        }
    }
    private void modify(Rq rq) {
        int paramId = rq.getIntParam("id", 0);
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }
        WiseSaying foundWiseSaying = findById(paramId);
        if (foundWiseSaying == null) {
            System.out.println(paramId + "번째 명언은 존재하지 안습니다.");
            return;
        }
        System.out.println("명언(기존) : " + foundWiseSaying.content);
        foundWiseSaying.content = sc.nextLine().trim();
        System.out.println("작가(기존) : " + foundWiseSaying.author);
        foundWiseSaying.author = sc.nextLine().trim();
        System.out.println(paramId + "번째 명언이 수정되었습니다.");
    }
    private void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }
        WiseSaying foundWiseSaying = findById(paramId);
        if (foundWiseSaying == null) {
            System.out.println(paramId + "번째 명언은 존재하지 안습니다.");
            return;
        }
        wiseSayings.remove(foundWiseSaying);
        System.out.println(paramId + "번째 명언이 삭제되었습니다.");
    }
}
