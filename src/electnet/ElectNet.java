
package electnet;
import electnet.controller.AuthController;
import electnet.routes.Routes;
import electnet.ui.forms.login.LoginForm;
import electnet.ui.main.MainMenu;
import electnet.utils.WindowManager;

public class ElectNet {

    public static void main(String[] args) {
        AuthController authController = new AuthController();
        authController.checkAdminUser();
        Routes.ShowLogin(true);
        //WindowManager.showWindow(new LoginForm());
       
    }
    
}
