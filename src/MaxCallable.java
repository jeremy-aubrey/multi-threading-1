import java.util.List;
import java.util.concurrent.Callable;

public class MaxCallable implements Callable<Integer>{
	
	private List<Integer> data;
	
	public MaxCallable(List<Integer> data) {
		this.data = data;
	}
	
	@Override
	public Integer call() throws Exception {
		int max = Integer.MIN_VALUE;
		if(!data.isEmpty()) {
			for(Integer num : data) {
				int currentInt = num.intValue();
				if(currentInt > max) {
					max = currentInt;
				}
			}
		}
		return new Integer(max);
	}

}
