package com.ea.SpringBootAppiumUIFramework.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.time.Duration;

public class AppiumServerManager {

    private static AppiumDriverLocalService service;

    public static void startServer() {
        if (service == null || !service.isRunning()) {
            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withAppiumJS(new File("C:\\Users\\Vishvambruth_Javagal\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withArgument(() -> "--allow-insecure", "chromedriver_autodownload")
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .withTimeout(Duration.ofSeconds(60))
                    .withLogFile(new File("appium.log"));

            service = AppiumDriverLocalService.buildService(builder);
            service.start();
            System.out.println("Appium server started");
        }
    }

    public static void stopServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped");
        }
    }
}
