package tracasa.services;

import tracasa.contracts.IInstrument;
import tracasa.contracts.IInstrumentListener;

public class Instrument implements IInstrument {

	private IInstrumentListener listener;
	
	public Instrument(IInstrumentListener listener)
	{
		this.listener = listener;
	}
	
	@Override
	public void execute(String task) {
		this.onFinished();
	}

	@Override
	public void onFinished() {
		this.listener.onFinished();
	}

	@Override
	public void onError() {
		this.listener.onError();
	}

}
