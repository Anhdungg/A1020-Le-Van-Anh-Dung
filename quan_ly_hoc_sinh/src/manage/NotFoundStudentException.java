package manage;

public class NotFoundStudentException extends Exception {
    public NotFoundStudentException(){
        super("NotFoundStudentException");
    }

    public NotFoundStudentException(String value){
        super(value);
    }
}
