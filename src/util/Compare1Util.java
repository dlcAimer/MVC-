package util;

import entity.Artwork;

import java.util.Comparator;

/**
 * Created by 29252 on 2017/7/27.
 */
public class Compare1Util implements Comparator<Artwork>{
    @Override
    public int compare(Artwork o1, Artwork o2) {
        if(o1.getCost().compareTo(o2.getCost())<0)
            return -1;
        else{
            if(o1.getCost().compareTo(o2.getCost())==0)
                return 0;
            else
                return 1;
        }
    }
}
