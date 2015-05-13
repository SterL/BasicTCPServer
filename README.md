# BasicTCPServer
An open source project that allows users to implement a basic TCPServer with only a few lines of code

### Implementing the BasicTCPServer
To create your own BasicTCPServer, just add the .java files inside the TCPServer source file to your project, and add the following lines of code to your project:

  ```
  public class Your_Class implements ServerEvent{
    //Your code goes here
  }
  ```

Simply implement the ServerEvent and add the unimplemented method:

    @Override
    public void receive(Connection u, String s) {
        //The main logic for your server goes here
    }
    

Create and start the Server using the following block of code:

  ```
  BasicTCPServer myServer = new BasicTCPServer(this, 3000, 50);  //Context, PORT, Number of threads
  myServer.start();
  ```
  
VOILA!  Your own BasicTCPServer

As far as a client goes, they aren't incredibly hard to implement and there are many possibilities out there.  I suggest building your own from scratch, but if you want one that works right out the gate go here:

(http://www.cise.ufl.edu/~amyles/tutorials/tcpchat/TCPChat.java)

or download the code

(http://www.cise.ufl.edu/~amyles/tutorials/tcpchat/TCPChat.java)

Created by Ashish Myles
  
  



