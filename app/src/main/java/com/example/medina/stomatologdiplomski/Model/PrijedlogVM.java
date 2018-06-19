package com.example.medina.stomatologdiplomski.Model;

import java.io.Serializable;

public class PrijedlogVM implements Serializable{
    public static class PrijedlogInfo implements Serializable
    {  public int Id ;
        public String IPPacijent ;
        public String TekstPoruke ;
        public String IPStomatolog ;

        public PrijedlogInfo(int id, String IPPacijent, String TekstPoruke,String IPStomatolog) {
            this.Id=id;
            this.IPPacijent=IPPacijent;
            this.IPStomatolog=IPStomatolog;
            this.TekstPoruke=TekstPoruke;
        }
    }
}
