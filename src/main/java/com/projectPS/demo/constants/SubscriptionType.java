package com.projectPS.demo.constants;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum SubscriptionType {
    Fitness,
    Zumba,
    Aerobic;

    private static final List<SubscriptionType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static SubscriptionType randomType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
