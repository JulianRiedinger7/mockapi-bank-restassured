package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UtilsMethods {

  /** 
   * This method checks if an array of String contains or not duplicates inside
   * 
   * @param array the array of string to check the duplicates
   * @return boolean true if it has no duplicates, false if it has
   */
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
