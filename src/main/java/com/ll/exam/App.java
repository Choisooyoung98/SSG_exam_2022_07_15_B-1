package com.ll.exam;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);

    int wiseSayingLastId = 0;
    void run(){
        System.out.println("=== 명언 SSG ===");

        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    ++wiseSayingLastId;
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    System.out.println(wiseSayingLastId + "번 명언이 등록되었습니다.");
                    continue;
                case "종료":
                    break outer;
            }
        }

    }
}
