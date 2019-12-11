package tracasa;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tracasa.contracts.IInstrumentListener;
import tracasa.contracts.ITaskDispatcher;
import tracasa.services.Instrument;
import tracasa.services.InstrumentProcessor;
import tracasa.services.TaskDispatcher;

public class InstrumentShould {

	private TaskDispatcher taskDispatchMock;
	private Instrument instrumentMock;
	
	@BeforeEach
	public void initMocks()
	{
		this.taskDispatchMock = mock(TaskDispatcher.class);
		this.instrumentMock = mock(Instrument.class);
	}
	
	@Test
	public void whenProcessorworks_retrieveTaskFromDispatcher()
	{
		// Arrange
		InstrumentProcessor processor = new InstrumentProcessor(taskDispatchMock, instrumentMock);
		
		processor.process();

		// ¿Assert?
		verify(taskDispatchMock, times(1))
			.getTask();
	}
	
	@Test
	public void whenProcessworks_delegateWorkIntoInstrument()
	{
		String task = "ANY_TASK";
		
		when(taskDispatchMock.getTask())
			.thenReturn(task);
		
		InstrumentProcessor processor = new InstrumentProcessor(taskDispatchMock, instrumentMock);
		
		processor.process();
		
		verify(instrumentMock, times(1))
			.execute(task);
	}
	
	@Test
	public void xxx()
	{
		IInstrumentListener listener = spy(IInstrumentListener.class);
		Instrument instrument = new Instrument(listener);
		
		InstrumentProcessor processor = new InstrumentProcessor(taskDispatchMock, instrument);
		processor.process();

		verify(listener).onFinished();
	}
}
