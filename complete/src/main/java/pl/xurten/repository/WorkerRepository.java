package pl.xurten.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.xurten.model.Worker;

import java.util.List;
public interface WorkerRepository extends MongoRepository<Worker,String>
{
    public List<Worker> findByName(String name);

}
