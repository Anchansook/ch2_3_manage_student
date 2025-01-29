package org.fastcampus.student_management.domain;

public class Student {

  private final String name;
  private final int age;
  private final String address;
  // 수강생 상태 여부
  private boolean activated;

  public Student(String name, int age, String address) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("이름은 필수 입력값입니다.");
    }

    this.name = name;
    this.age = age;
    this.address = address;
    this.activated = true;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  // 수강생 상태 여부
  public boolean isActivate() {
    return activated;
  }

  // 수강생을 활성화하는 메서드 추가
  // public void activate() {
  //   this.activated = true;
  // }

  // 수강생을 비활성화하는 메서드 추가
  // public void deactivate() {
  //   this.activated = false;
  // }

  //% 강사님 ver : 사용 비권장 삭제!
  // public void setActivated(boolean activated) {
  //   if (activated && this.activated) {
  //     throw new IllegalArgumentException();
  //   }

  //   if (!activated && !this.activated) {
  //     throw new IllegalArgumentException();
  //   }

  //   this.activated = activated;
  // }

  //% 다시 강사님 ver
  public void activate() {
    if (this.activated) throw new IllegalArgumentException();

    this.activated = true;
  }

  //% 강사님 ver
  public void deactivate() {
    if (!this.activated) throw new IllegalArgumentException();

    this.activated = false;
  }
}
