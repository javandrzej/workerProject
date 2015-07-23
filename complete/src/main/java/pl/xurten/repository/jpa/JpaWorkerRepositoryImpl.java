package pl.xurten.repository.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import pl.xurten.model.Worker;

import java.util.List;
public class JpaWorkerRepositoryImpl implements JpaWorker
{
    @Autowired private JpaWorkerRepository jpaWorkerRepository;


    @Override
    public Worker findWorkerById(int id)
    {
        final List<Worker> all = (List<Worker>) jpaWorkerRepository.findAll();
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

    public JpaWorkerRepository getJpaWorkerRepository()
    {
        return jpaWorkerRepository;
    }

    public void setJpaWorkerRepository(JpaWorkerRepository jpaWorkerRepository)
    {
        this.jpaWorkerRepository = jpaWorkerRepository;
    }
}
