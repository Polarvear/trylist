package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다
// 이 표시(애노테이션)가 붙어있어야만 스프링 부트에서 인식한다
public class ContactController {

  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")  
  public Object list() {
    String[] arr = new String[size]; // 배열에 저장된 값만 복사할 새 배열을 만든다.
    for (int i = 0; i < size; i++) {
      arr[i] = contacts[i]; // 전체 배열에서 값이 들어있는 항목만 복사한다.
    }
    return arr; // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  }
  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) { // 이게 먼저
    String contact = "\""+ name + "," + email + "," + tel + "," + company + "\"";
    contacts[size++] = contact;
    return size; // 몇개를 입력했는지 확인

  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) {
        return contacts[i];
      }
    }
    return "";
  }
  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) { // 이게 먼저
    String contact = name + "," + email + "," + tel + "," + company;
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) {
        contacts[i] = contact;
        return 1;
      }
    }
    return 0;
  }

  @RequestMapping("/contact/delete")
  public Object delet(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) {
        for (int j = i + 1; j < size; j++) {
          contacts[j - 1] = contacts[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }
}
