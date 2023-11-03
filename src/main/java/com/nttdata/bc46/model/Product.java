package com.nttdata.bc46.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class Product {
    private int id;
    private String name;
    private String type;
    
}
