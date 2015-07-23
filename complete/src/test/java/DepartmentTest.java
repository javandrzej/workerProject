import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.xurten.Application;
import pl.xurten.model.Department;
import pl.xurten.repository.mongo.MongoDepartmentRepository;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class DepartmentTest
{
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MongoDepartmentRepository mongoDepartmentRepository;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testDepartment() throws Exception
    {
        mongoDepartmentRepository.save(new Department(10,"Programmer"));
        mongoDepartmentRepository.save(new Department(12,"Designer"));
        mongoDepartmentRepository.findAll().forEach(System.out::println);
        assertEquals(4, mongoDepartmentRepository.findAll().size());
    }
}
