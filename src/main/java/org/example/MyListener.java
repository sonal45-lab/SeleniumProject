package org.example;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener
        implements ITestListener {

    @Override
    public void onTestStart
            (ITestResult result) {
        System.out.println(
                "🚀 Test Shuru: "
                        + result.getName());
    }

    @Override
    public void onTestSuccess
            (ITestResult result) {
        System.out.println(
                "✅ Test Pass: "
                        + result.getName());
    }

    @Override
    public void onTestFailure
            (ITestResult result) {
        System.out.println(
                "❌ Test Fail: "
                        + result.getName());
    }

    @Override
    public void onTestSkipped
            (ITestResult result) {
        System.out.println(
                "⏭️ Test Skip: "
                        + result.getName());
    }
}