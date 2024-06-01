package com.redventures.ramengo.orders.util;

import com.redventures.ramengo.orders.domain.Broth;
import com.redventures.ramengo.orders.domain.dto.BrothView;

public class BrothConverter {

    public static BrothView toView(Broth broth){
        return new BrothView(broth.getId(), broth.getImageInactive(), broth.getImageActive(),
                broth.getName(), broth.getDescription(), broth.getPrice());
    }

    public static Broth toEntity(BrothView broth){
        return new Broth(broth.getId(), broth.getImageInactive(), broth.getImageActive(),
                broth.getName(), broth.getDescription(), broth.getPrice());
    }
}
