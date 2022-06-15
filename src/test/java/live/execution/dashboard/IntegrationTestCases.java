package live.execution.dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import live.execution.dashboard.beans.Execution;
import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class IntegrationTestCases {


	@Test @Order(1)
	void getAllExecutionsIntegrationTest() throws JSONException {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.getForEntity("http://54.173.4.42:8089/getExecution", String.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		String noOfExecutions = String.valueOf(response.getBody().length());
		JSONAssert.assertNotEquals("1", noOfExecutions, true);
		System.out.println("1 off 3 integration completed");
	}
	
	@Test @Order(2)
	void getExecutionByIdIntegrationTest() throws JSONException {
		
		String expectedValue = "{\n" +
				"    \"id\": 1,\n" +
				"    \"executionID\": \"1000\",\n" +
				"    \"testcaseName\": \"TC001\",\n" +
				"    \"executionStatus\": \"Pass\",\n" +
				"    \"executionDate\": \"2022-03-24\"\n" +
				"}";
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.getForEntity("http://54.173.4.42:8089/getExecution/1", String.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		JSONAssert.assertEquals(expectedValue, response.getBody(), false);
		System.out.println("2 off 3 integration completed");
	}

	@Test @Order(3)
	void addExecutionIntegrationTest() throws JSONException {
		
		Execution country = new Execution(4, "1004", "TC004","Pass", "2022-03-24");
		String expectedValue = "{\n" +
				"    \"executionID\": \"1004\",\n" +
				"    \"testcaseName\": \"TC004\",\n" +
				"    \"executionStatus\": \"Pass\",\n" +
				"    \"executionDate\": \"2022-03-24\"\n" +
				"}";
		
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Execution> request = new HttpEntity<Execution>(country, headers);
		ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:8089/addExecution", request, String.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println("3 off 3 integration completed");
		
//		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		System.out.println(response.getBody());
		JSONAssert.assertEquals(expectedValue, response.getBody(), false);
	}

}
