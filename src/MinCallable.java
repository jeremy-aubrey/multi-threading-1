import java.util.List;
import java.util.concurrent.Callable;

public class MinCallable implements Callable<Integer> {
	
	private List<Integer> data;
	
	public MinCallable(List<Integer> data) {
		this.data = data;
	}

	@Override
	public Integer call() throws Exception {
		int min = Integer.MAX_VALUE;
		if(!data.isEmpty()) {
			for(Integer num : data) {
				int currentInt = num.intValue();
				if(currentInt < min) {
					min = currentInt;
				}
			}
		}
		
		return new Integer(min);
	}

}
