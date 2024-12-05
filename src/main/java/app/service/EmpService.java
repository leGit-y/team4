package app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import app.entity.Emp;
import app.repository.EmpRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmpService {
	
	private final EmpRepository empRepository;

	public Optional<Emp> getEmpByEmpno(Integer empno) { 
		return empRepository.findById(empno);
	}

}
