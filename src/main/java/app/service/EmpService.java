package app.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import app.entity.Dept;
import app.entity.Emp;
import app.repository.EmpRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmpService {

    private final EmpRepository empRepository;

    @Transactional
    public Emp updateEmp(int empno, String ename, String job, Integer mgr, LocalDate hiredate, Double sal, Double comm, Integer deptno) {
        Emp emp = empRepository.findById(empno)
                                .orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다."));
        
        Dept dept = new Dept();
        dept.setDeptno(deptno);

        emp.setEname(ename);
        emp.setJob(job);
        emp.setMgr(mgr);
        emp.setHiredate(hiredate);
        emp.setSal(sal);
        emp.setComm(comm);
        emp.setDept(dept);

        return empRepository.save(emp);
    }
}
