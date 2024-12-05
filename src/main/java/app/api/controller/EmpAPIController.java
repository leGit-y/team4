package app.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.EmpDTO;
import app.entity.Emp;
import app.service.EmpService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmpAPIController {
	
	private final EmpService empService;

    @PutMapping("/emp/{empno}")
    public Emp updateEmp(@RequestBody EmpDTO updateEmp, @PathVariable int empno) {
        return empService.updateEmp(
            empno,
            updateEmp.getEname(),
            updateEmp.getJob(),
            updateEmp.getMgr(),
            updateEmp.getHiredate(),
            updateEmp.getSal(),
            updateEmp.getComm(),
            updateEmp.getDeptno()
        );
    }
    
}
