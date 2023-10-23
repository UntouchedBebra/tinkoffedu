package edu.hw2.task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        StackTraceElement[] methodCalls = new Throwable().getStackTrace();
        return new CallingInfo(methodCalls[1].getClassName(), methodCalls[1].getMethodName());
    }

}
