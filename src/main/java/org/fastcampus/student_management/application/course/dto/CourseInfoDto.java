package org.fastcampus.student_management.application.course.dto;

import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

public class CourseInfoDto {
  private final String courseName; // 수업명
  private final int fee; // 수강료
  private final DayOfWeek dayOfWeek; // 요일
  private final String studentName; // 학생 이름
  private final Long courseTime; // 수업 시간

  public CourseInfoDto(String courseName, int fee, String dayOfWeek, String studentName, Long courseTime) {
    this.courseName = courseName;
    this.fee = fee;
    this.dayOfWeek = DayOfWeek.valueOf(dayOfWeek);
    this.studentName = studentName;
    this.courseTime = courseTime;
  }

  public CourseInfoDto(Course course) {
    this.courseName = course.getCourseName();
    this.fee = course.getFee();
    this.dayOfWeek = course.getDayOfWeek();
    this.studentName = course.getStudentName();
    this.courseTime = course.getCourseTime();
  }

  public String getCourseName() {
    return courseName;
  }

  public int getFee() {
    return fee;
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public String getStudentName() {
    return studentName;
  }

  public Long getCourseTime() {
    return courseTime;
  }
}
