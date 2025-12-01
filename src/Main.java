import controller.LoginController;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginController loginController = new LoginController();
                loginController.mostrarLogin();
            }
        });
    }
}
