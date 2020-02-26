package io.himoura.interview.testdome;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class MergeNames {
    
    public static String[] uniqueNamesv1(String[] names1, String[] names2) {
    	Set<String> set = new TreeSet<>();
    	
    	for(String name1 : names1) {
    		set.add(name1);
    	}
    	for(String name2 : names2) {
    		set.add(name2);
    	}
    	
    	return set.toArray(new String[set.size()]);
    }
    public static String[] uniqueNamesv2(String[] names1, String[] names2) {
    	return Stream.concat(Stream.of(names2), Stream.of(names1)).distinct().sorted().toArray(String[]::new);
    }
}
