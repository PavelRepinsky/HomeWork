package Homework_18_01_2024;

import java.util.ArrayList;

public interface ReturnList {
    @Cached
    @LimitSize
    ArrayList<String> returnedList();
}
