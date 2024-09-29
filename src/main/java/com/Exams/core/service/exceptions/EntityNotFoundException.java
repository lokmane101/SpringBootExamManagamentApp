package com.Exams.core.service.exceptions;
	



	public class EntityNotFoundException extends RuntimeException {

	    public EntityNotFoundException() {
	        super("Entité non trouvée");
	    }

	    public EntityNotFoundException(String message) {
	        super(message);
	    }



}
