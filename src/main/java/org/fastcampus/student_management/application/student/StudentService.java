package org.fastcampus.student_management.application.student;

import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.StudentRepository;

public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void saveStudent(StudentInfoDto studentInfoDto) {
    Student student = new Student(studentInfoDto.getName(), studentInfoDto.getAge(), studentInfoDto.getAddress());
    studentRepository.save(student);
  }

  public Student getStudent(String name) {
    return studentRepository.findByName(name)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));
  }

  // 활성화 학생
  public void activateStudent(String name) {
    // 학생이 있는 지 확인
    Student student = studentRepository.findByName(name)
      .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));

    // 이미 활성 상태인지 확인
    if (student.isActivate()) {
      System.out.println("이미 활성화된 학생입니다.: " + name);
      return;
    }

    // 수강생 활성 상태로 변경
    student.activate();

    // 변경된 학생 정보를 저장
    studentRepository.save(student);

    System.out.println("학생 활성화 완료: " + name);
  }

  // 비활성화 학생
  public void deactivateStudent(String name) {
    // 학생이 있는 지 확인
    Student student = studentRepository.findByName(name)
      .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));

    // 이미 비활성화 상태인지 확인
    if (!student.isActivate()) {
      System.out.println("이미 비활성화 학생입니다.: " + name);
      return;
    }

    // 수강생 비활성화 상태로 변경
    student.deactivate();

    // 변경된 학생 정보를 저장
    studentRepository.save(student);

    System.out.println("학생 비활성화 완료: " + name);
  }
}
