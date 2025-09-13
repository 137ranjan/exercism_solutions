import java.util.Optional;
import java.io.FileNotFoundException;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException("This is the detail message.");
    }

    void handleErrorByThrowingAnyCheckedException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws FileNotFoundException{
        throw new FileNotFoundException("This is the detail message.");
    }

    void handleErrorByThrowingAnyUncheckedException() {
        throw new RuntimeException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        throw new RuntimeException("This is the detail message.");
    }

    void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException  {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException{
        throw new CustomCheckedException("This is the detail message.");
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException("This is the detail message.");
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try{
            int value = Integer.parseInt(integer);
            return Optional.of(value);
        }catch(NumberFormatException e){
            return Optional.empty();
        }
    }

}
