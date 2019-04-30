package com.sunshine.server;

import com.sunshine.entity.Item;
import com.sunshine.entity.ItemIntroduce;

public interface ItemServer {

    ItemIntroduce getItemById(Integer Id);
}
