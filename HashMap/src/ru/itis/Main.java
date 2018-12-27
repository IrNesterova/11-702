package ru.itis;

public class Main {

    public static void main(String[] args) {
		CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();
		customHashMap.put(4, "Михаил");
		customHashMap.put(4, "Михаило");
		customHashMap.put(6, "Михаил");
		customHashMap.put(7, "Маша");
		System.out.println(customHashMap.get(4));
    }
}
