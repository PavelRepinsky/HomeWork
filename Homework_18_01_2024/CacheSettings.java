package Homework_18_01_2024;

public class CacheSettings {

    private boolean inMemory = false;
    private boolean serializeResult = true;

    public boolean isInMemory() {
        return inMemory;
    }

    public boolean isSerializeResult() {
        return serializeResult;
    }

    public void setInMemory(boolean setting) {
        inMemory = setting;
    }

    public void setSerializeResult(boolean setting) {
        serializeResult = setting;
    }
}
