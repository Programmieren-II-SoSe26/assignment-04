package ExceptionHandling_2;

public class AppConfig {

    private String host;
    private int port;
    private int timeout;

    public AppConfig(String host, int port, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public int getTimeout() {
        return timeout;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", timeout=" + timeout +
                '}';
    }
}