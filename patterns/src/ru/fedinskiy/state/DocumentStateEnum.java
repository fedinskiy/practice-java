package ru.fedinskiy.state;

/**
 * Created by fedinskiy on 09.03.17.
 */
public enum DocumentStateEnum {
	LOAD,
	PREPARED,
	SIGNED_1,
	SIGNED_2,
	SEND,
	RECEIVED,
	ACCEPT,
	SEND_ACCEPT,
	ERROR_SIGNED, SEND_APPRUVED
}
