package networking;

//Demonstrate Sockets.
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class Whois {
	public static void main(String args[]) throws Exception {
		int c;
		// Create a socket connected to internic.net, port 48
		Socket s = new Socket("www.internic.net", 80);
		// Obtain input and output streams.
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		// Construct a request string.

		String str = (args.length == 0 ? "google.com" : args[0]) + "\n";
		// Convert to bytes.
		byte buf[] = str.getBytes();
		// Send request.
		out.write(buf);
		// Read and display response.
		while ((c = in.read()) != -1) {
			System.out.print((char) c);
		}
		s.close();
	}
}
