package com.example.medina.stomatologdiplomski.Model;

import java.io.Serializable;
import java.util.List;

public class LijekVM implements Serializable {
    public class LijekInfo implements Serializable
    {
        public int Id;
        public String Naziv;
    }
    public List<LijekInfo> lijekovi;
}
