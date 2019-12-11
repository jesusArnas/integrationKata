package tracasa.contracts;

public interface ITaskDispatcher
{
    String getTask();
    void finishedTask(String task);
}