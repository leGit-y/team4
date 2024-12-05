package app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpDTO {
    private String ename;
    private String job;
    private Integer mgr;
    private LocalDate hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
