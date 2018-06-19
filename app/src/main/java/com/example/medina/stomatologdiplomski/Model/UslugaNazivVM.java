package com.example.medina.stomatologdiplomski.Model;

import java.io.Serializable;
import java.util.List;

public class UslugaNazivVM implements Serializable {
    public class UslugaInfo implements Serializable
    {
        public int Id;
        public String Naziv;
    }
    public List<UslugaInfo> usluge;
}
