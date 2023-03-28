package com.nextit.reactplus.utils;

public interface Constants {

    String APP_ROOT = "api/v1";

    String AUTHENTICATION_ENDPOINT = APP_ROOT + "/auth";
    String ENTREPRISE_ENDPOINT = APP_ROOT + "/entreprises";

    String FOURNISSEUR_ENDPOINT = APP_ROOT + "/fournisseurs";

    String UTILISATEUR_ENDPOINT = APP_ROOT + "/utilisateurs";

    String USER_ENDPOINT = APP_ROOT + "/users";

    String VENTES_ENDPOINT = APP_ROOT + "/ventes";

    String COMMANDE_FOURNISSEUR_ENDPOINT = APP_ROOT + "/commandesfournisseurs";
    String CREATE_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/create";
    String FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/{idCommandeFournisseur}";
    String FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/filter/{codeCommandeFournisseur}";
    String FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/all";
    String DELETE_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/delete/{idCommandeFournisseur}";

}