package app.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getEmpByEmpno(@PathVariable Integer empno) { Optional<Emp> emp = empService.getEmpByEmpno(empno); 
	if (emp.isPresent()) { 
		return ResponseEntity.ok(emp.get());
		} else { 
			return ResponseEntity.status(404).body("{\"msg\": \"사원정보가 존재하지 않습니다\"}"); 
		} 
	}
}
