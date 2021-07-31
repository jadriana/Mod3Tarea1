package session;

import controlAppium.Label;
import factoryDevices.FactoryDevice;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.time.Duration;

public class Session {
    // tener un attributo del mismo tipo
    private static Session instance=null;
    private AppiumDriver driver;

    // tener un construtor privado
    private Session() throws MalformedURLException {
        driver= FactoryDevice.make(FactoryDevice.DeviceType.ANDROID).create();
    }

    // tener un metodo statico publico que retorne la instancia unica
    // synchronized ---> no usar para evitar problemas de ejecucion paralela
    public static Session getInstance() throws MalformedURLException {
        if (instance == null)
            instance= new Session();
        return instance;
    }

    public void closeSession(){
        driver.quit();
        instance=null;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

}