package com.example.justin.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Justin on 2016-12-25.
 */

public interface PartWatcher {
    public void setPart(Part part);

    public void setPartList(ArrayList<HashMap<String,String>> part);
}
