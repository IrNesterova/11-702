package ru.itis;

public class StatisticsDisplay implements DisplayElement, Observer {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;
    public StatisticsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("blah-blah-blah");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
