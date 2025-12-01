package controller;

import view.MainMenuView;

public class MainMenuController {
    private MainMenuView view;

    public MainMenuController() {
        this.view = new MainMenuView();
    }

    public void mostrarMenu() {
        view.setVisible(true);
    }
}
