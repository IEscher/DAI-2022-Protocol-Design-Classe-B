package ch.heigvd.api.calc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Calculator client implementation
 */
public class Client {

    private static final Logger LOG = Logger.getLogger(Client.class.getName());

    private static final int port = 3101;

    /**
     * Main function to run client
     *
     * @param args no args required
     */
    public static void main(String[] args) {
        // Log output on a single line
        System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s%6$s%n");

        BufferedReader stdin = null;
        PrintWriter stdout = null;

                /* TODO: Implement the client here, according to your specification
         *   The client has to do the following:
         *   - connect to the server
         *   - initialize the dialog with the server according to your specification
         *   - In a loop:
         *     - read the command from the user on stdin (already created)
         *     - send the command to the server
         *     - read the response line from the server (using BufferedReader.readLine)
         */

        stdin = new BufferedReader(new InputStreamReader(System.in));

        // Establish connection with the server and set stdout
        Socket serverSocket;
        try {
            serverSocket = new Socket((String) null, port); // Not sure about that
            stdout = new PrintWriter(serverSocket.getOutputStream());
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return;
        }

        // Exchange with the server
        String line;
        boolean shouldRun = true;
        try {
            LOG.info("Reading until client sends BYE or closes the connection...");
            while ((shouldRun) && (line = stdin.readLine()) != null) {

                // TODO implement base mechanism here

            }

            LOG.info("Cleaning up resources...");
            serverSocket.close();
            stdin.close();
            stdout.close();

        } catch (IOException ex) { // Close everything properly
            try {
                stdin.close();
            } catch (IOException ex1) {
                LOG.log(Level.SEVERE, ex1.getMessage(), ex1);
            }
            stdout.close();
            try {
                serverSocket.close();
            } catch (IOException ex1) {
                LOG.log(Level.SEVERE, ex1.getMessage(), ex1);
            }
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
