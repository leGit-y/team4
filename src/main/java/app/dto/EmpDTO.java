package app.dto;

import java.time.LocalDate;

import app.entity.Dept;
import app.entity.Emp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class EmpDTO {
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private LocalDate hiredate;
	private Double sal;
	private Double comm;
	private Integer deptno;
	
	public static EmpDTO of(Integer empno,
							 String ename,
							 String job,
							 Integer mgr,
							 LocalDate hiredate,
							 Double sal,
							 Double comm,
							 Integer deptno) {
    	return new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
    }
	
	public static EmpDTO from(Emp emp) {
    	
    	return new EmpDTO(
    			emp.getEmpno(),
				emp.getEname(),
				emp.getJob(),
				emp.getMgr(),
				emp.getHiredate(),
				emp.getSal(),
				emp.getComm(),
				emp.getDept().getDeptno()
    			);
    }
	
	public Emp toEntity(Dept dept) {
    	return Emp.builder()
    			.empno(empno)
    			.ename(ename)
    			.job(job)
    			.mgr(mgr)
    			.hiredate(hiredate)
    			.sal(sal)
    			.comm(comm)
    			.dept(dept)
    			.build();
    					
		
    }
	

}
