package pl.xurten;

public class Worker
{
    private int id;
    private String name;
    private String lastname;
    private int departmentId;

    public Worker()
    {

    }

    public Worker(int id, String name, String lastname, int departmentId)
    {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.departmentId = departmentId;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public int getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(int departmentId)
    {
        this.departmentId = departmentId;
    }

    @Override
    public String toString()
    {
        return "Class = app.Worker \n" +
                "id = " + id +
                "\nname = '" + name + '\'' +
                "\nlastname = '" + lastname + '\'' +
                "\ndepartmentId = " + departmentId +
                "\n";
    }
}
