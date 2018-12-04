import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sets<T> {

	public static int countUnique(ArrayList<Integer> s) {

		return new HashSet<Integer>(s).size();		
	}
	
}
