package live.execution.dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import live.execution.dashboard.repositories.ExecutionRepository;
import live.execution.dashboard.services.ExecutionService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import live.execution.dashboard.beans.Execution;

@SpringBootTest(classes= ServiceUnitTest.class)
@TestMethodOrder(OrderAnnotation.class)
public class ServiceUnitTest {

	@Mock
	ExecutionRepository executionRepository;
	
	@InjectMocks
	ExecutionService executionService;


	@Test 
	@Order(1)
	void getAllCountriesTest() {
		List<Execution> execution = new ArrayList<Execution>();
		execution.add(new Execution(1, "1000", "TC001","Pass", "2022-03-24"));
		execution.add(new Execution(2, "1001", "TC002","Fail", "2022-03-24"));
		execution.add(new Execution(3, "1002", "TC003","Pass", "2022-03-24"));
		when(executionRepository.findAll()).thenReturn(execution);
		int size = executionService.getAllExecution().size();
		System.out.println(size);
		assertEquals(3, size);
		System.out.println("getAllCountriesTest test completed");
	}
	
	@Test 
	@Order(2)
	void getCountryByIDTest() {

		List<Execution> execution = new ArrayList<Execution>();
		execution.add(new Execution(1, "1000", "TC001","Pass", "2022-03-24"));
		execution.add(new Execution(2, "1001", "TC002","Fail", "2022-03-24"));
		execution.add(new Execution(3, "1002", "TC003","Pass", "2022-03-24"));

		int executionByID = 1;
		when(executionRepository.findAll()).thenReturn(execution);
		int id = executionService.getExecutionByID(executionByID).getId();
		System.out.println(id);
		assertEquals(executionByID, id);
		System.out.println("getCountryByIDTest test completed");
	}

	@Test 
	@Order(3)
	void addCountryTest() {
		Execution execution = new Execution(4, "1004", "TC004","Pass", "2022-03-24");
		when(executionRepository.save(execution)).thenReturn(execution);
		System.out.println(executionService.addExecution(execution).getExecutionStatus());
		assertEquals(execution, executionService.addExecution(execution));
		System.out.println("addCountryTest test completed");
	}

}
