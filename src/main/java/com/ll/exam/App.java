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
                    ++wiseSayingLastId;
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    System.out.println(wiseSayingLastId + "번 명언이 등록되었습니다.");
                    WiseSaying wiseSaying = new WiseSaying(wiseSayingLastId, content, author);
                    wiseSayings.add(wiseSaying);
                    continue;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("--------------------");
                    for (int i = 0; i < wiseSayings.size(); i++){
                        WiseSaying wiseSaying_ = new WiseSaying();
                        wiseSaying_ = wiseSayings.get(i);
                        System.out.println(wiseSaying_.id + " / " + wiseSaying_.content + " / " + wiseSaying_.author);
                    }
                    continue;

                case "종료":
                    break outer;
            }
        }

    }
}
