package zr;

public class RealHandler extends Handler{

	@Override
	public void handlerRequest() {
		if(getHandler() != null) {
			System.out.println("放过请求");
			getHandler().handlerRequest();
		}else {
			System.out.println("处理请求");
		}
	}

}
