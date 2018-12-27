package ru.itis;

public class Main {

    public static void main(String[] args) {
	WeatherData wd = new WeatherData();
	CurrentConditionsDisplay cd = new CurrentConditionsDisplay(wd);
	StatisticsDisplay sd = new StatisticsDisplay(wd);

    }
}
