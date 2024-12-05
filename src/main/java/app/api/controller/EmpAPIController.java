package app.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.dto.EmpDTO;
import app.dto.response.ApiFailResponse;
import app.entity.Dept;
import app.entity.Emp;
import app.repository.DeptRepository;
import app.repository.EmpRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EmpAPIController {

	private final EmpRepository empRepository;
	private final DeptRepository deptRepository;
	
	@GetMapping("/api/emps")
	@ResponseBody
	public ResponseEntity getAllEmps() {

		List<Emp> emps = empRepository.findAll();
		
		if(emps == null) {
			ApiFailResponse apiResponse = ApiFailResponse.builder()
									.msg("사원정보가 존재하지 않습니다")
									.build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
		}

		List<EmpDTO> employeeResponse = emps.stream()
								.map(EmpDTO::from)
								.toList();
		
			
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}
	
	
	@PostMapping("/api/emp")
	@ResponseBody
	public ResponseEntity<EmpDTO> registerEmp(@RequestBody EmpDTO EmpDTO) {
		Dept dept = deptRepository.getReferenceById(EmpDTO.getDeptno());
		
		Emp emp = EmpDTO.toEntity(dept);
		
		
		empRepository.save(emp);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(EmpDTO);
		
		
	}
	
	
}