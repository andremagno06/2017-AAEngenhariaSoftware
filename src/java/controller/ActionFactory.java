/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author ice
 */
public class ActionFactory {

    public static Action create(String action) {
        Action actionObjet = null;
        String nomeClasse = "action." + action + "Action";
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof Action)) {
            return null;
        }
        actionObjet = (Action) objeto;
        return actionObjet;
    }

}


