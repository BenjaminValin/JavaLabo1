package be.technifutur.java2020.gestionstage.tarifs;

public enum TarifActivite {Tennis(65), Basket(55), Football(55), Hockey(85), F1(150), Rallye(125)
    ;
    private int tauxHoraire;

    private TarifActivite(int nb){
        this.tauxHoraire = nb;
    }

    public int getTauxHoraire() {
        return tauxHoraire;
    }

}
