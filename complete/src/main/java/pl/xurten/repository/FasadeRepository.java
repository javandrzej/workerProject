package pl.xurten.repository;

import pl.xurten.repository.jpa.JpaRepository;
import pl.xurten.repository.mongo.MongoRepository;
public class FasadeRepository
{
    private JpaRepository jpaRepository;
    private MongoRepository mongoRepository;

    public FasadeRepository(JpaRepository jpaRepository, MongoRepository mongoRepository)
    {
        this.jpaRepository = jpaRepository;
        this.mongoRepository = mongoRepository;
    }

    public JpaRepository getJpaRepository()
    {
        return jpaRepository;
    }

    public MongoRepository getMongoRepository()
    {
        return mongoRepository;
    }
}
