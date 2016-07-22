package pas.au.pivotal.service.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRest
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/version")
    public String version()
    {
        return "1.0";
    }

    @RequestMapping("/allemps")
    public List<Employee> appemps()
    {
        return employeeRepository.findAll();
    }

}
