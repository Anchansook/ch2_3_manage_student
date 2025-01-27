package org.fastcampus.student_management.application.course;

import java.util.List;
import java.util.stream.Collectors;

import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  // 요일에 해당하는 수업 가져오기
  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // 리포지토리에서 Course 리스트를 가져옴
    List<Course> course = courseRepository.getCourseDayOfWeek(dayOfWeek);

    // 반환타입 변환
    return course.stream()
            .map(CourseInfoDto::new)
            .collect(Collectors.toList());
  }

  // 수강료 변경하기
  public void changeFee(String studentName, int fee) {
    // TODO: 과제 구현 부분
  }
}
