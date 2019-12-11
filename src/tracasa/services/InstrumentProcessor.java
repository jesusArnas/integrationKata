package tracasa.services;

import tracasa.contracts.IInstrument;
import tracasa.contracts.IInstrumentProcessor;
import tracasa.contracts.ITaskDispatcher;

public class InstrumentProcessor implements IInstrumentProcessor {

	private ITaskDispatcher dispatcher;
	private IInstrument instrument;
	
	public InstrumentProcessor(ITaskDispatcher dispatcher, IInstrument instrument)
	{
		this.dispatcher = dispatcher;
		this.instrument = instrument;
	}
	
	public void process()
	{
		String task = dispatcher.getTask();
		instrument.execute(task);
	}
}
