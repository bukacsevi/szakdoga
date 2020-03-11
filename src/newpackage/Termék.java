
package newpackage;

/**
 *
 * @Bukács Éva
 */
public class Termék {
    
    private int termekId;
    private int cegId;
    private String cikkszam;
    private String megnevezes;
    private int ar;    
    private int rendeltMennyiseg;
    
    
    public Termék(int termekId_,int cegId_,String cikkszam_,String megnevezes_,int ar_){
        termekId=termekId_;
        cegId=cegId_;
        cikkszam=cikkszam_;
        megnevezes=megnevezes_;
        ar=ar_;
        
        
    }
    public Termék(int termekId_,int cegId_,String cikkszam_,String megnevezes_,int ar_, int rendeltMennyiseg_){
        termekId=termekId_;
        cegId=cegId_;
        cikkszam=cikkszam_;
        megnevezes=megnevezes_;
        ar=ar_;
        rendeltMennyiseg=rendeltMennyiseg_;
        
    }

    public int getCegId() {
        return cegId;
    }

    public void setCegId(int cegId) {
        this.cegId = cegId;
    }

    public int getRendeltMennyiseg() {
        return rendeltMennyiseg;
    }

    public void setRendeltMennyiseg(int rendeltMennyiseg) {
        this.rendeltMennyiseg = rendeltMennyiseg;
    }
    
    public Termék(int cegId_,String cikkszam_,String megnevezes_,int ar_){
        cegId=cegId_;
        cikkszam=cikkszam_;
        megnevezes=megnevezes_;
        ar=ar_;
        
        
    }

    public int getBeszallitoId() {
        return cegId;
    }

    public void setBeszallitoId(int beszallitoId) {
        this.cegId = beszallitoId;
    }
    
    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getTermekId() {
        return termekId;
    }

    public void setTermekId(int termekId) {
        this.termekId = termekId;
    }

    public String getCikkszam() {
        return cikkszam;
    }

    public void setCikkszam(String cikkszam) {
        this.cikkszam = cikkszam;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }
    
    
    @Override
    public String toString(){
        return cikkszam+" "+megnevezes;
    }
    
    
}
