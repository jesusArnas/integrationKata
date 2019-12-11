package tracasa.contracts;

public interface IInstrument
{
    void execute(String task);
 
    void onFinished();
    void onError();
}