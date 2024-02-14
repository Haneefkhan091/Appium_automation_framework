package RunFirstScript;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;

public class scrollingmethods {
    private static final Logger logger = LogManager.getLogger(scrollingmethods.class);

    private final AppiumDriver driver;
    // public static String platform;

    public scrollingmethods(AppiumDriver driver) {
        this.driver = driver;
        // this.platform = platform;
    }

    public void swipeUp(By element) {
        logger.info("Swiping up...");
        swipe(driver.findElement(element), Direction.UP);
    }


    public void swipeUp(WebElement element) {
        logger.info("Swiping up...");
        swipe(element, Direction.UP);
    }

    public void swipeDown(By element) {
        logger.info("Swiping down...");
        swipe(driver.findElement(element), Direction.DOWN);
    }

    public void swipeLeft(WebElement element) {
        logger.info("Swiping left...");
        swipe(element, Direction.LEFT);
    }

    public void swipeRight(WebElement element) {
        logger.info("Swiping right...");
        swipe(element, Direction.RIGHT);
    }

    private void swipe(WebElement element, Direction direction) {
        Rectangle rect = element.getRect();
        int startX;
        int startY;
        int endX;
        int endY;

        switch (direction) {
        case UP:
            startX = rect.getX() + rect.getWidth() / 2;
            startY = rect.getY() + rect.getHeight() - 300;
            endX = startX;
            endY = rect.getY() + 300;
            break;
        case DOWN:
            startX = rect.getX() + rect.getWidth() / 2;
            startY = rect.getY() + 10;
            endX = startX;
            endY = rect.getY() + rect.getHeight() - 10;
            break;
        case LEFT:
            startX = rect.getX() + rect.getWidth() - 180;
            startY = rect.getY() + rect.getHeight() / 2;
            endX = rect.getX() + 180;
            endY = startY;
            break;
        case RIGHT:
            startX = rect.getX() + 10;
            startY = rect.getY() + rect.getHeight() / 2;
            endX = rect.getX() + rect.getWidth() - 10;
            endY = startY;
            break;
        default:
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(
                finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(finger, Duration.ofMillis(350)));
        sequence.addAction(
                finger.createPointerMove(Duration.ofMillis(350), PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

}