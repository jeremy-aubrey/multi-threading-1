import java.util.List;
import java.util.concurrent.Callable;

public class AverageCallable implements Callable<Integer> {
	
	private List<Integer> data;
	
	public AverageCallable(List<Integer> data) {
		this.data = data;
	}
	
	@Override
	public Integer call() throws Exception {
		int avg = 0;
		if(!data.isEmpty()) {
			int sum = 0;
			for(Integer num : data) {
				sum += num.intValue();
				avg = sum / data.size();
			}
		}
		
		return new Integer(avg);
	}

}
