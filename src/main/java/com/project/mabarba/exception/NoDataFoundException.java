package com.project.mabarba.exception;

public class NoDataFoundException extends Exception {
    private String entityName;
    private long id;

    public NoDataFoundException(String entityName, long id){

        super(String.format("this entity %s with id : %s could not be found in the system",entityName, id ));

    }

    public NoDataFoundException(String entityName){

        super(String.format("this entity %s  could not be found in the system",entityName ));

    }

    public NoDataFoundException(long id){

        super(String.format("could not found element with id : %s in the system",id ));

    }
}
