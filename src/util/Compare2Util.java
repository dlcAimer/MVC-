package util;

import entity.Artwork;

import java.util.Comparator;

/**
 * Created by 29252 on 2017/7/27.
 */
public class Compare2Util implements Comparator<Artwork>{

    @Override
    public int compare(Artwork o1, Artwork o2) {
        if (o1.getYearOfWork()<o2.getYearOfWork())
            return -1;
        else {
            if (o1.getYearOfWork()==o2.getYearOfWork())
                return 0;
            else return 1;
        }
    }
}
