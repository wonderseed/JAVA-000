import inbound.HttpInboundServer;

public class NettyServerApplication {
    public final static String GATEWAY_NAME="NioGATEWAY";
    public final static String GATEWAY_VERSION = "1.0.0";
    public static void main(String[] args) {
        String proxyPort = System.getProperty("proxyPort","8888");
        String proxyServer = System.getProperty("proxyServer","http://localhost:8801");

        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, proxyServer);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + proxyServer);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
