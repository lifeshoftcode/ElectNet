/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electnet.routes;

import electnet.ui.forms.login.LoginForm;
import electnet.ui.forms.politicalParty.PoliticalPartyForm;
import electnet.ui.forms.users.UserForm;
import electnet.ui.main.MainMenu;
import electnet.utils.WindowManager;
import javax.swing.JFrame;

/**
 *
 * @author jonat
 */
public class Routes {

    static JFrame login = new LoginForm();
    static JFrame mainMenu = new MainMenu();
    static JFrame userForm = new UserForm();
    static JFrame politicalPartyForm = new PoliticalPartyForm();

    public static void ShowLogin(boolean isOpen) {
        if (isOpen) {
            WindowManager.showWindow(login);
        } else {
            WindowManager.hideWindow(login);
        }

    }

    public static void ShowMainMenu(boolean isOpen) {
        if (isOpen) {
            WindowManager.showWindow(mainMenu);
        } else {
            WindowManager.hideWindow(mainMenu);
        }

    }

    public static void ShowUserForm(boolean isOpen) {
        {
            if (isOpen) {
                WindowManager.showWindow(userForm);
            } else {
                WindowManager.hideWindow(userForm);
            }

        }
    }
     public static void ShowPoliticalParty(boolean isOpen) {
        {
            if (isOpen) {
                WindowManager.showWindow(politicalPartyForm);
            } else {
                WindowManager.hideWindow(politicalPartyForm);
            }

        }
    }
}
