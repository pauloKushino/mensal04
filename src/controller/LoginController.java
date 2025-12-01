package controller;

import view.LoginView;
import view.MainMenuView;
import service.UsuarioService;
import model.Usuario;

import javax.swing.*;

public class LoginController {
    private LoginView view;
    private UsuarioService usuarioService;

    public LoginController() {
        this.view = new LoginView();
        this.usuarioService = new UsuarioService();
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnEntrar().addActionListener(e -> validarLogin());
    }

    private void validarLogin() {
        try {
            String usuario = view.getUsuario();
            String senha = view.getSenha();

            if (usuario.isEmpty() || senha.isEmpty()) {
                view.exibirErro("Usuário e senha são obrigatórios!");
                return;
            }

            Usuario usuarioEncontrado = usuarioService.validarLogin(usuario, senha);

            if (usuarioEncontrado != null && "ativo".equalsIgnoreCase(usuarioEncontrado.getStatus())) {
                JOptionPane.showMessageDialog(view, "Login realizado com sucesso!");
                view.dispose();
                new MainMenuController().mostrarMenu();
            } else {
                view.exibirErro("Usuário ou senha inválidos!");
                view.limparCampos();
            }
        } catch (Exception ex) {
            view.exibirErro("Erro ao validar login: " + ex.getMessage());
        }
    }

    public void mostrarLogin() {
        view.setVisible(true);
    }
}
