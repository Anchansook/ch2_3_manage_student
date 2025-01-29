package org.fastcampus.student_management.repo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.fastcampus.student_management.domain.Student;

public class StudentRepository {

  private final Map<String, Student> studentMap = new HashMap<>();

  // 학생 등록
  public void save(Student student) {
    studentMap.put(student.getName(), student);
  }

  // 학생 이름 찾기
  public Optional<Student> findByName(String name) {
    return Optional.ofNullable(studentMap.get(name));
  }
}
