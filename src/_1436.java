import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1436 {
	public static void main(String[] args) {


	}
	static public String destCity(List<List<String>> paths) {
		Set<String> citys = new HashSet<>();
		for (int i = 0; i < paths.size(); i++) {
				citys.add(paths.get(i).get(0));
		}
		for (int i = 0; i < paths.size(); i++) {
			if (!citys.contains(paths.get(i).get(1)))   return paths.get(i).get(1);
		}
		return "FALSE";
	}
}
