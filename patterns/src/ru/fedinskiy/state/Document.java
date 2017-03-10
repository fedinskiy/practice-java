package ru.fedinskiy.state;

/**
 * Created by fedinskiy on 09.03.17.
 */
public class Document {
	DocumentStateEnum state;
	
	public void doAction(DocumentStateEnum state){
		switch (this.state){
			case LOAD:
				if(state==DocumentStateEnum.PREPARED) {
					System.out.println("set prepared");
					this.state=state;
				}else{
					System.out.println("error");
				}
				break;
			case PREPARED:
				if(state==DocumentStateEnum.SIGNED_1) {
					System.out.println("set prepared");
					this.state=state;
				}else if(state==DocumentStateEnum.ERROR_SIGNED) {
					System.out.println("error");
					this.state = state;
				}else{
					System.out.println();
				}
				break;
			case SEND:
				break;
			case SIGNED_1:
				break;
			case SIGNED_2:
				break;
			case RECEIVED:
				break;
			case ACCEPT:
				break;
			case SEND_ACCEPT:
				break;
			case ERROR_SIGNED:
				break;
			case SEND_APPRUVED:
				break;
		}
	}
}
