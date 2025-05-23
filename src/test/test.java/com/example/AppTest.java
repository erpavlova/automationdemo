package com.example;

import com.microsoft.playwright.*;

public class AppTest {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://example.com");
        System.out.println("Page title: " + page.title());
        browser.close();
    }
}