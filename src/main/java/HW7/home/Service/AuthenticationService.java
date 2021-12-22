package HW7.home.Service;

public interface AuthenticationService {
    void start();
    void stop();

    String getNickNameLoginPassword(String login, String password);



}
