/*
package com.example.demo;

import com.example.demo.entities.User;
import com.example.demo.payload.LoginRequest;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {


	@Test
	public void test_Login_Correct_Pass_Correct() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9090/api/test";
		URI uri = new URI(baseUrl);

		HttpHeaders head = new HttpHeaders();
		LoginRequest test = new LoginRequest("test","test");
		HttpEntity<LoginRequest> request = new HttpEntity<>(test,head);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		//Verify request succeed
		Assert.assertEquals("success", result.getBody());



	}
	@Test
	public void test_Login_Correct_Pass_Faux() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9090/api/test";
		URI uri = new URI(baseUrl);

		HttpHeaders head = new HttpHeaders();
		LoginRequest test = new LoginRequest("test","t");
		HttpEntity<LoginRequest> request = new HttpEntity<>(test,head);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		//Verify request succeed
		Assert.assertEquals("failed", result.getBody());



	}
	@Test
	public void test_Login_Faux_Pass_Correct() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9090/api/test";
		URI uri = new URI(baseUrl);

		HttpHeaders head = new HttpHeaders();
		LoginRequest test = new LoginRequest("t","test");
		HttpEntity<LoginRequest> request = new HttpEntity<>(test,head);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		//Verify request succeed
		Assert.assertEquals("failed", result.getBody());



	}
	@Test
	public void test_Login_Faux_Pass_Faux() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:9090/api/test";
		URI uri = new URI(baseUrl);

		HttpHeaders head = new HttpHeaders();
		LoginRequest test = new LoginRequest("t","t");
		HttpEntity<LoginRequest> request = new HttpEntity<>(test,head);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		//Verify request succeed
		Assert.assertEquals("failed", result.getBody());



	}

}
*/
