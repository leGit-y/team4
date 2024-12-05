package app.api.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Emp;
import app.service.EmpService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmpAPIController {
	
	private final EmpService empService;

	@GetMapping("/emp/{empno}")
	public Optional<Emp> getEmpByEmpno(@PathVariable Integer empno) {
		return empService.getEmpByEmpno(empno);
	}
}