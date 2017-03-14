package ru.fedinskiy;

public class MessageConstants {
	private final static String SENDER_ID = "SenderID";
	private final static String CONNECTION_NAME = "Destination_unknown";
	private final static String CONNECTION_SOCKET="tcp://localhost:61616";
	public static String getSenderId() {
		return SENDER_ID;
	}
	
	public static String getConnectionName() {
		return CONNECTION_NAME;
	}
	
	public static String getConnectionSocket() {
		return CONNECTION_SOCKET;
	}
}