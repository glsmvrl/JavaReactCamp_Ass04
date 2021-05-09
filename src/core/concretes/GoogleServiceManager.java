package core.concretes;

import GoogleConcretes.ControlService;
import core.abstractt.GoogleService;
import core.abstractt.GoogleService;

public class GoogleServiceManager implements GoogleService {
    @Override
    public void loginWithGoogle(String mail, String password) {
        ControlService controlService = new ControlService();
        controlService.googleAccountLogin(mail,password);
    }
}
