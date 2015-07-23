package pl.xurten.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.xurten.model.Department;
import pl.xurten.repository.mongo.MongoDepartmentRepository;
@RestController
public class DepartmentController
{
    @Autowired
    MongoDepartmentRepository mongoDepartmentRepository;

    @RequestMapping(value = "/departments",method = RequestMethod.GET)
    String getWorkers()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(Department department : mongoDepartmentRepository.findAll())
        {
            stringBuilder.append(department+"<br/>");
        }
        System.out.println(stringBuilder);
        return "We have "+String.valueOf(mongoDepartmentRepository.findAll().size()) +" entries. <br/>" +"\n"+stringBuilder.toString();
    }
}
