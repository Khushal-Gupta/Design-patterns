import java.util.HashSet;
import java.util.Set;

interface WeatherDataSubscriber {
    void update(float temperatureInCelcuis);
}

class PhoneAppSubscriber implements WeatherDataSubscriber {

    @Override
    public void update(float temperatureInCelcuis) {
        System.out.println("Phone app received temperature update: "+ temperatureInCelcuis);
    }
}

class WebsiteSubscriber implements WeatherDataSubscriber {

    @Override
    public void update(float temperatureInCelcuis) {
        System.out.println("Television website received temperature update: "+ temperatureInCelcuis);
    }
}

class WeatherDataPublisher {
    
    private Set<WeatherDataSubscriber> weatherSubscribers;

    public WeatherDataPublisher() {
        weatherSubscribers = new HashSet<>();
    }

    public void register(WeatherDataSubscriber subscriber) {
        weatherSubscribers.add(subscriber);
    }

    public void remove(WeatherDataSubscriber subscriber) {
        weatherSubscribers.remove(subscriber);
    }

    public void notifyAll(float newTemperatureInCelcius) {
        weatherSubscribers.forEach(it -> {
            it.update(newTemperatureInCelcius);
        });
    }
}

public class Example1 {
    public static void main(String[] args) {
        WeatherDataPublisher weatherDataPublisher = new WeatherDataPublisher();
        WeatherDataSubscriber phoneAppSubscriber = new PhoneAppSubscriber();
        WeatherDataSubscriber websitWeatherDataSubscriber = new WebsiteSubscriber();

        weatherDataPublisher.register(websitWeatherDataSubscriber);
        weatherDataPublisher.register(phoneAppSubscriber);

        weatherDataPublisher.notifyAll(Float.parseFloat("45.345"));
    }
}