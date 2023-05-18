package auth;

import java.util.ArrayList;

class User {
    private String fullName;
    private String userName;
    private String password;

    public User(String fullName, String userName, String password) {
    
        setFullName(fullName);
        setUserName(userName);
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

class Auth {

    private ArrayList<User> users = new ArrayList<User>();

    public User register(String fullName, String userName, String password) throws Exception {
        int flag = 0;

        if (userName.length() < 4) {
            throw new Exception("Username must be of atleast 4 characters.");
        }

        if (password.length() < 6) {
            throw new Exception("Password must be of atleast 6 characters");
        }

        for (User user : this.users) {
            if (user.getUserName() == userName) {
                flag = 1;
                break;
            }

        }

        if (flag == 1) {
            throw new Exception("Username already exists.");
        } else {
            User user = new User(fullName, userName, password);
            users.add(user);
            System.out.println("Successfully registered.");
            return user;
        }
    }

    public User login(String userName, String password) throws Exception {
        int flag = 0;

        if (userName.length() < 4) {
            throw new Exception("Username must be of atleast 4 characters.");
        }

        if (password.length() < 6) {
            throw new Exception("Password must be of atleast 6 characters");
        }

        for (User user : this.users) {
            if (user.getUserName().compareTo(userName) == 0) {
                flag = 1;
                if (flag == 1) {
                    if (user.getPassword().compareTo(password) == 0) {

                        User user1 = new User(user.getFullName(), userName, password);
                        System.out.println("Login Successful.\n");
                        return user1;
                    }

                    else 
                    {
                        throw new Exception("Wrong Password!!!");
                    }
                    
                }
            }

        }
        if (flag == 0) {
            throw new Exception("Plese register, user does not exists.");
        }
        return null;

    }

}

class AuthCheck
{
    public static void main(String[] args) throws Exception {
        Auth U1 =  new Auth();
        U1.register("Azariush Hussain","hussain", "123456");
        U1.login("hussain", "123456");
    }
}