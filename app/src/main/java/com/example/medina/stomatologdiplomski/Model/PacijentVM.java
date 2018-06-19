package com.example.medina.stomatologdiplomski.Model;

import java.io.Serializable;
import java.util.Date;

public class PacijentVM implements Serializable {


    public static class PacijentInfo implements Serializable
    {  public int Id ;
        public String JMBG ;
        public String AddedOn ;
        public String Slika ;
        public String Ime;
        public String Prezime;
        public String Email;
        public String Mobitel;

        public PacijentInfo(int id, String JMBG, String AddedOn,String slika,String i,String p,String email,String mob) {
            this.Id=id;
            this.JMBG=JMBG;
            this.AddedOn=AddedOn;
            this.Slika=slika;
            this.Ime=i;
            this.Prezime=p;
            this.Email=email;
            this.Mobitel=mob;
        }
    }
}
