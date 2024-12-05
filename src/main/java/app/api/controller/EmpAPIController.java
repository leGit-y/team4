package app.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Dept;
import app.entity.Emp;
import app.service.EmpService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmpAPIController {
	
	private final EmpService empService;
	
	@PostMapping("/emps/{empno}")
	public Emp deleteDeptByDeptno(@PathVariable Integer empno) {
		Emp emp = empService.deleteDeptByEmpno(empno);
		return emp;
	}
	
}
