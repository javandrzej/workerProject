package pl.xurten.repository.jpa;

import pl.xurten.model.Worker;
public interface JpaWorker
{
    Worker findWorkerById(int id);
}
