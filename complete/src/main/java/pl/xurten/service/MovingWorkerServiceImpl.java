package pl.xurten.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.xurten.model.Worker;
import pl.xurten.repository.mongo.MongoWorkerRepositoryImpl;

@Service
public class MovingWorkerServiceImpl implements MovingWorkerService
{

    public MovingWorkerServiceImpl()
    {

    }

    @Autowired
    private MongoWorkerRepositoryImpl mongoWorkerRepositoryImpl;


    //TODO test it
    @Override
    public void moveWorkerToDepartment(int workerId,int departmentId)
    {
            Worker myWorker = null;
            for (Worker worker :  mongoWorkerRepositoryImpl.getMongoWorkerRepository().findAll())
            {
                    myWorker = (Worker) worker;
                    break;
            }
            myWorker.setDepartmentId(departmentId);
            mongoWorkerRepositoryImpl.getMongoWorkerRepository().save(myWorker);
    }

}
