package Homework_18_01_2024;

import Homework_18_01_2024.Annotations.LimitSize;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class ListTrimer implements LimitSize.SizeLimited {

    int amount = 0;

    public void trimList(ArrayList<String> list) {

        if (amount < 0) {
            throw new TrimListException("Size cannot be negative");
        }
        else {
            for (int i = 0; i < getAmount() - 1; i++) {
                list.remove(list.size() - 1);
            }
        }
    }

    @Override
    public int amount() {
        return amount;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public int getAmount() {
        return amount();
    }

    public void setAmount(int newAmount) {
        amount = newAmount;
    }
}
