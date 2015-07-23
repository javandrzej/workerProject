package pl.xurten.repository.mongo;


import pl.xurten.model.Worker;
public interface MongoWorker
{
    Worker findWorkerById(int id);
}
