package Bean;

import java.net.ServerSocket;

public class myPort {
    static int smtpPort = 25;
    static int pop3Port = 110;

    public static void setPop3Port(int pop3Port) {
        myPort.pop3Port = pop3Port;
    }

    public static void setSmtpPort(int smtpPort) {
        myPort.smtpPort = smtpPort;
    }

    public static int getPop3Port() {
        return pop3Port;
    }

    protected static int getSmtpPort() {
        return smtpPort;
    }

    public static boolean isPortUsing(int port){
        boolean flag=false;
        try {
            ServerSocket socket = new ServerSocket(port);
            socket.close();
            flag=true;
        } catch (Exception e) {
            flag=false;
            System.out.println("端口被占用");
            e.printStackTrace();
        } finally{
            return flag;
        }
    }

     class myClass{
        String string = "inner class";
        String isWaht(){
            return string;
        }
    }
}

class outter extends myPort{
    String string = "outter class";
    String isWhat(){
        myClass x = new myClass();
        string += x.isWaht();
        return string;
    }
}