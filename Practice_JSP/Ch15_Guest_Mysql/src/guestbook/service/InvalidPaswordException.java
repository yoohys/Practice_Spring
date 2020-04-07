package guestbook.service;

public class InvalidPaswordException extends Exception {

		private static final long serialVersionUID = 1L;
		
		public InvalidPaswordException(String message) {
			super(message);
		}

}
