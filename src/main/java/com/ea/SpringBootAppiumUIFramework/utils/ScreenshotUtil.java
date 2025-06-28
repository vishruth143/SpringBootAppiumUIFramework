package com.ea.SpringBootAppiumUIFramework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "screenshots/";

    public static String takeScreenshot(WebDriver driver, String scenarioName) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
        String filePath = SCREENSHOT_DIR + fileName;

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destPath = Paths.get(filePath);

        try {
            Files.createDirectories(destPath.getParent());
            Files.copy(srcFile.toPath(), destPath);
        } catch (IOException e) {
            System.err.println("Screenshot saving failed: " + e.getMessage());
        }

        return filePath;
    }
}
