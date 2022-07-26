package ex04;

public class Client2 {

	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}

	public void send() {
		System.out.println("Client.send() called ..." + host);
	}
	
	public void connect() {
		System.out.println("Client.connect() called");		
	}
	
	public void close() throws Exception {
		System.out.println("Client.close() called");
	}


}
