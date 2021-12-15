package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // �� Ŭ������ Ŭ���̾�Ʈ ��û ó�� ��������� ǥ���Ѵ�
// �� ǥ��(�ֳ����̼�)�� �پ��־�߸� ������ ��Ʈ���� �ν��Ѵ�
public class ContactController {

  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")  
  public Object list() {
    String[] arr = new String[size]; // �迭�� ����� ���� ������ �� �迭�� �����.
    for (int i = 0; i < size; i++) {
      arr[i] = contacts[i]; // ��ü �迭���� ���� ����ִ� �׸� �����Ѵ�.
    }
    return arr; // ������ �׸���� ��� �ִ� �� �迭�� �����Ѵ�.
  }
  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) { // �̰� ����
    String contact = "\""+ name + "," + email + "," + tel + "," + company + "\"";
    contacts[size++] = contact;
    return size; // ��� �Է��ߴ��� Ȯ��

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
  public Object update(String name, String email, String tel, String company) { // �̰� ����
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
