package com.example;

import com.microsoft.playwright.*;

public class Test {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Example: Login to API or website
            page.navigate("https://example.com/login");

            page.fill("#username", "testuser");
            page.fill("#password", "testpass");
            page.click("button[type=submit]");

            // Wait for redirect / check something visible
            page.waitForURL("**/dashboard");
            System.out.println("Login successful! Current URL: " + page.url());

            // Or fetch token from API (REST call)
            // You can also use Java's HTTP client here
        }
    }
}