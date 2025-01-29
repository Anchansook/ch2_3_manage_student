package org.fastcampus.student_management.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

public class CourseRepository {

  private final Map<String, Course> courseMap = new HashMap<>();

  public void save(Course course) {
    courseMap.put(course.getCourseName(), course);
  }

  // 요일에 해당하는 수업 가져오기
  public List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    List<Course> courses = new ArrayList<>();
    for (Course course : courseMap.values()) {
      if (course.isSameDay(dayOfWeek) && course.isActivateUser()) {
        courses.add(course);
      }
    }
    return courses;
  }

  // 학생 수업 리스트 가져오기
  public List<Course> getCourseListByStudent(String studentName) {
    List<Course> courses = new ArrayList<>();
    for (Course course : courseMap.values()) {
      if (course.getStudentName().equals(studentName)) {
        courses.add(course);
      }
    }
    return courses;
  }

  // 수업 등록
  public void saveCourses(List<Course> courses) {
    for (Course course : courses) {
      courseMap.put(course.getCourseName(), course);
    }
  }
}
