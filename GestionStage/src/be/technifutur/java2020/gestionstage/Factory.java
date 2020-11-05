package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.menusorganisateur.*;
import be.technifutur.java2020.gestionstage.menusroles.*;
import be.technifutur.java2020.gestionstage.stages.StageCtrl;

public class Factory {

    private Organisateur orga;
    private MenuStage menus;
    private StageCtrl ctrls;
    private MenuActivite menua;



    public MenuPrincipal getMenu(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setOrga(getOrga());
        return menu;
    }

    private Organisateur getOrga() {
        if (this.orga == null){
            this.orga = new Organisateur();
            this.orga.setMenuStage(getMenuStage());
            this.orga.setMenuActivite(getMenuActivite());
        }
        return orga;
    }

    private MenuStage getMenuStage() {
        if (this.menus == null){
            this.menus = new MenuStage();
            this.menus.setStageCtrl(getStageCtrl());
        }
        return menus;
    }

    private StageCtrl getStageCtrl() {
        if (this.ctrls == null){
            this.ctrls = new StageCtrl();
            this.ctrls.setListeStage(getListeStage());
            this.ctrls.setFonctionsUtiles(getFonctionsUtiles());
        }
        return ctrls;
    }

    private MenuActivite getMenuActivite() {
        if (this.menua == null){
            this.menua = new MenuActivite();
        }
        return menua;
    }

}
