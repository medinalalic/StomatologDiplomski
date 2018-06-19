package com.example.medina.stomatologdiplomski.Model;

import java.io.Serializable;
import java.util.List;

public class DijagnozaDropVM implements Serializable{
    public class DijagnozaInfo implements Serializable
    {
        public int Id ;
        public String Naziv;
    }
    public List<DijagnozaInfo> dijagnoze;
}
