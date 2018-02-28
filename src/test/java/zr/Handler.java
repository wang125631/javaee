package zr;

public abstract class Handler {

	protected Handler handler;
	
	public abstract void handlerRequest();

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	
	
	
}
