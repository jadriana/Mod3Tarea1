package controlAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.net.MalformedURLException;
import java.util.List;

public class Control {
    protected WebElement control;
    protected By locator;

    public Control (By locator){
        this.locator= locator;
    }

    protected void findControl() throws MalformedURLException {
        this.control= Session.getInstance().getDriver().findElement(this.locator);
    }



    public void click() throws MalformedURLException {
        this.findControl();
        this.control.click();
    }

    public String getText() throws MalformedURLException {
        this.findControl();
        return this.control.getText();
    }




    public WebElement getControl()throws MalformedURLException {
        this.findControl();
        return this.control;
    }


    public int size()throws MalformedURLException {
        List<WebElement> webElements = Session.getInstance().getDriver().findElements(this.locator);
        int last = webElements.size();
        return webElements.size();
    }

}
