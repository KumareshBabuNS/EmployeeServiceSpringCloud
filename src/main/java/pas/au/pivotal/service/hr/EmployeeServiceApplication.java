package pas.au.pivotal.service.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeServiceApplication
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@PostConstruct
	public void init()
	{
		employeeRepository.save(new Employee("pas"));
		employeeRepository.save(new Employee("lucia"));
		employeeRepository.save(new Employee("siena"));
		employeeRepository.save(new Employee("lucas"));
	}
}
