package laddergame.exception;

import java.util.function.Supplier;
import laddergame.view.OutputView;

public class ExceptionHandler {

    public static <T> T retryUntilInputIsValid(Supplier<T> function, OutputView outputView) {
        try {
            return function.get();
        } catch(IllegalArgumentException exception){
            outputView.printExceptionMessage(exception.getMessage());
            return retryUntilInputIsValid(function, outputView);
        }
    }

}
