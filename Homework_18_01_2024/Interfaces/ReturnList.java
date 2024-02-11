package Homework_18_01_2024.Interfaces;

import Homework_18_01_2024.Annotations.Cached;
import Homework_18_01_2024.Annotations.LimitSize;

import java.util.ArrayList;

public interface ReturnList {
    @Cached
    @LimitSize
    ArrayList<String> returnedList();
}
