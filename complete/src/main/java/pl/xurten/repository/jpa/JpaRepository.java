package pl.xurten.repository.jpa;

public class JpaRepository
{
    private JpaDepartmentRepository jpaDepartmentRepository;
    private JpaWorkerRepository jpaWorkerRepository;

    public JpaRepository(JpaDepartmentRepository jpaDepartmentRepository, JpaWorkerRepository jpaWorkerRepository)
    {
        this.jpaDepartmentRepository = jpaDepartmentRepository;
        this.jpaWorkerRepository = jpaWorkerRepository;
    }

    public JpaDepartmentRepository getJpaDepartmentRepository()
    {
        return jpaDepartmentRepository;
    }

    public void setJpaDepartmentRepository(JpaDepartmentRepository jpaDepartmentRepository)
    {
        this.jpaDepartmentRepository = jpaDepartmentRepository;
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
