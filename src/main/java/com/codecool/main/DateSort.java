package com.codecool.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class DateSort implements Comparator<Consumable> {

    @Override
    public int compare(Consumable o1, Consumable o2) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        Date o1Date = null;
        Date o2Date = null;
        try {
            o1Date = sdf.parse(o1.getBestBefore());
            o2Date = sdf.parse(o2.getBestBefore());
        } catch (ParseException pe) {
            pe.printStackTrace();
            System.out.println(pe + "\nClosing application...");
            System.exit(-1);
        }

        if (o1Date.getTime() - o2Date.getTime() == 0) {
            return o1.getName().compareTo(o2.getName());
        } else if (o1Date.getTime() - o2Date.getTime() > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
