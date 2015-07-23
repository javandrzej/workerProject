package pl.xurten.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.xurten.model.Department;
import pl.xurten.model.Worker;
import pl.xurten.repository.mongo.MongoDepartmentRepository;
import pl.xurten.repository.mongo.MongoWorkerRepositoryImpl;

import java.util.List;
@Service
public class PrintWorkersServiceImpl implements PrintWorkersService
{

    @Autowired
    private MongoWorkerRepositoryImpl repository;

    @Autowired
    private MongoDepartmentRepository mongoDepartmentRepository;

    public PrintWorkersServiceImpl()
    {

    }

    //TODO test it
    @Override
    public String printAllWorkersInDepartments()
    {
        StringBuilder stringBuilder = new StringBuilder();
        final List<Worker> allWorkers = repository.getMongoWorkerRepository().findAll();
        final List<Department> allDepartments = mongoDepartmentRepository.findAll();

        for (Worker worker : allWorkers)
        {
                    stringBuilder.append(( worker).getId()+" ");
                    stringBuilder.append(( worker).getName()+" ");
                    stringBuilder.append(( worker).getLastname()+" ");
            for (Department department : allDepartments)
            {
                if(department.getId() ==  worker.getDepartmentId())
                {
                    System.out.println("NAME OF DEPARTMENT "+department.getName());
                    stringBuilder.append(department.getName()+" ");
                    break;
                }
            }
            stringBuilder.append("<BR>");
        }
        return stringBuilder.toString();
    }
}
