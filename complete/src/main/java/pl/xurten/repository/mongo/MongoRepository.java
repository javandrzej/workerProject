package pl.xurten.repository.mongo;

public class MongoRepository
{
    private MongoDepartmentRepository mongoDepartmentRepository;
    private MongoWorkerRepository mongoWorkerRepository;

    public MongoRepository()
    {

    }

    public MongoRepository(MongoDepartmentRepository mongoDepartmentRepository, MongoWorkerRepository mongoWorkerRepository)
    {
        this.mongoDepartmentRepository = mongoDepartmentRepository;
        this.mongoWorkerRepository = mongoWorkerRepository;
    }

    public MongoDepartmentRepository getMongoDepartmentRepository()
    {
        return mongoDepartmentRepository;
    }

    public void setMongoDepartmentRepository(MongoDepartmentRepository mongoDepartmentRepository)
    {
        this.mongoDepartmentRepository = mongoDepartmentRepository;
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
