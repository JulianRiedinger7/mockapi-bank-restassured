package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UtilsMethods {
  public static boolean hasNoDuplicates(List<String> array) {
     Set<String> uniqueValues = new HashSet<>();
        
        for (String value : array) {
            if (uniqueValues.contains(value)) {
                return false;
            }
            uniqueValues.add(value);
        }
        
        return true;
  }
}
