package org.fastcampus.student_management.domain;

public class Course {
  private final Student student;
  private final String courseName;
  private CourseFee fee; // VO로 정의한 CourseFee 타입으로 변경
  private final DayOfWeek dayOfWeek;
  private final Long courseTime;

  public Course(Student student, String courseName, int fee, DayOfWeek dayOfWeek, Long courseTime) {
    if (student == null) {
      throw new IllegalArgumentException("학생은 필수 입력값입니다.");
    }

    this.student = student;
    this.courseName = courseName;
    this.fee = new CourseFee(fee);
    this.dayOfWeek = dayOfWeek;
    this.courseTime = courseTime;
  }

  public String getCourseName() {
    return courseName;
  }

  // 같은 요일인지 확인하는 메서드
  public boolean isSameDay(DayOfWeek dayOfWeek) {
    return this.dayOfWeek.equals(dayOfWeek);
  }

  // 학생의 활성화 여부를 확인하는 메서드
  public boolean isActivateUser() {
    return student.isActivate();
  }

  public String getStudentName() {
    return student.getName();
  }

  public int getFee() {
    return this.fee.getFee();
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public Long getCourseTime() {
    return courseTime;
  }

  //% 강사님 ver
  // 수강료 변경 메서드
  public void changeFee(int fee) {
  //   if (fee < 0) {
  //     throw new IllegalArgumentException();
  //   }

  //   this.fee = fee; // final이라서 오류나서 필드 final 지웠음.
  // -> CourseFee VO를 정의해줬기 때문에 필요 없어짐.

  this.fee.changeFee(fee);
  }
}
