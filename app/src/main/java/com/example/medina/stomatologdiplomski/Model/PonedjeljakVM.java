package com.example.medina.stomatologdiplomski.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PonedjeljakVM implements Serializable {
    public class Ponedjeljak implements Serializable
    {
        public int Id ;
        public Date Vrijeme ;
        public String Pacijent ;
        public int PacijentId ;

        public Boolean Obavljen ;
        public Date Datum ;
        public String Napomena ;
        public Boolean Odobren ;
    }

    public List<Ponedjeljak> _Ponedjeljak ;
}
