package test;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Vector;
import javax.servlet.*;
import javax.servlet.http.*;
import java.applet.Applet;

/**
 * Servlet that attempts to give each user a unique * user ID. However, because
 * it fails to synchronize * access to the nextID field, it suffers from race *
 * conditions: two users could get the same ID.
 */
public class UserIDs extends Applet implements Runnable{

    private int nextID = 0;
    

    public UserIDs() {
        super();
        // TODO Auto-generated constructor stub
    }
    // socketClients holds references to all the socket-connected clients
    Vector socketClients = new Vector();
    static final int PORT = 2428;
    DataInputStream serverStream;

    String getNextMessage() {
        
        String nextMessage = null;
        while (nextMessage == null) {
            try {
                // Connect to the server if we haven't before
                if (serverStream == null) {
                    Socket s = new Socket(getCodeBase().getHost(), PORT);
                    serverStream = new DataInputStream(
                            new BufferedInputStream(
                            s.getInputStream()));
                }

                // Read a line
                nextMessage = serverStream.readLine();
            } catch (SocketException e) {
                // Can't connect to host, report it and wait before trying again
                System.out.println("Can't connect to host: " + e.getMessage());
                serverStream = null;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {
                }
            } catch (Exception e) {
                // Some other problem, report it and wait before trying again
                System.out.println("General exception: "
                        + e.getClass().getName() + ": " + e.getMessage());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
        }
        return nextMessage + "\n";
    }

    // doGet() returns the next message. It blocks until there is one.
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        // Return the next message (blocking)
        broadcastMessage(out);
        //out.println(nextID++);
    }

    // doPost() accepts a new message and broadcasts it to all
    // the currently listening HTTP and socket clients.
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Accept the new message as the "message" parameter
        String message = req.getParameter("message");

        // Broadcast it to all listening clients
        if (message != null) {
            // broadcastMessage();
        }

        // Set the status code to indicate there will be no response
        res.setStatus(res.SC_NO_CONTENT);
    }

    // getNextMessage() returns the next new message.
    // It blocks until there is one.
    // broadcastMessage() informs all currently listening clients that there
    // is a new message. Causes all calls to getNextMessage() to unblock.
    public void broadcastMessage(PrintWriter outt) {
        // Send the message to all the HTTP-connected clients by giving the

        outt.println("aaa");
        // Directly send the message to all the socket-connected clients
        Enumeration enumm = socketClients.elements();
        outt.println();
        while (enumm.hasMoreElements()) {
            Socket client = null;
            try {
                client = (Socket) enumm.nextElement();
                PrintStream out = new PrintStream(client.getOutputStream());

                out.println(nextID++);
            } catch (IOException e) {
                // Problem with a client, close and remote it
                try {
                    if (client != null) {
                        client.close();
                    }
                } catch (IOException ignored) {
                }
                socketClients.removeElement(client);
            }
        }

    }

    protected int getSocketPort() {
        // We listen on port 2428 (look at a phone to see why)
        return 2428;
    }

    public void handleClient(Socket client) {
        // We have a new socket client. Add it to our list.
        socketClients.addElement(client);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
