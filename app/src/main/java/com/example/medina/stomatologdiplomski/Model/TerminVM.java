package com.example.medina.stomatologdiplomski.Model;

import java.io.Serializable;
import java.util.Date;

public class TerminVM implements Serializable {
    public static class TerminInfo implements Serializable
    {  public int Id ;
        public String Datum ;
        public String Vrijeme ;
        public boolean Odobren ;
        public int PacijentId;
        public String RazlogPosjete;
        public String Ime;
        public String Prezime;


        public TerminInfo(int id, String datum, String vrijeme,boolean odobren,int pacijentid,String razlog,String i,String p) {
            this.Id=id;
            this.Datum=datum;
            this.Vrijeme=vrijeme;
            this.Odobren=odobren;
            this.PacijentId=pacijentid;
            this.RazlogPosjete=razlog;

            this.Ime=i;
            this.Prezime=p;
        }
}}
