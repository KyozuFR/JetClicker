package jetclicker;

public class Player{
    private Integer score;
    private String nom;

    public void scoreUp(){
        this.score=this.score+1;
    }

    public int getScore(){
        return this.score;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public String getNom(){
        return this.nom;
    }
}