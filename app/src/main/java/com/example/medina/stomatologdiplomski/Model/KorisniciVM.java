package com.example.medina.stomatologdiplomski.Model;

import java.io.Serializable;

public class KorisniciVM implements Serializable {
    public int Id ;
    public String Ime ;
    public String Prezime ;

    public String Email ;
    public String Mobitel ;
    public String Adresa ;
    public String KorisnickoIme ;
    public String Lozinka ;
    public String LozinkaHash ;
    public String LozinkaSalt ;
    public Boolean IsAdmin ;
    public Boolean Aktivan ;
}
