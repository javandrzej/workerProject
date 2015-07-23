package pl.xurten.repository.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import pl.xurten.model.Worker;

import java.util.List;
public class MongoWorkerRepositoryImpl implements MongoWorker
{
    @Autowired
    private MongoWorkerRepository mongoWorkerRepository;

    //TODO TO TEST
    @Override
    public Worker findWorkerById(int id)
    {
        final List<Worker> all = mongoWorkerRepository.findAll();
        Worker worker = new Worker();
        for(Worker element:all)
            if (element.getId() == id)
            {
                worker = element;
                break;
            }
        if(worker == null)
        {
            throw new IllegalArgumentException("Worker can not be null");
        }
        return worker;
    }

    public MongoWorkerRepository getMongoWorkerRepository()
    {
        return mongoWorkerRepository;
    }

    public void setMongoWorkerRepository(MongoWorkerRepository mongoWorkerRepository)
    {
        this.mongoWorkerRepository = mongoWorkerRepository;
    }
}
