package app.opass.ccip.network;

import java.io.IOException;
import java.lang.annotation.Annotation;

import app.opass.ccip.model.Error;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtil {

    public static Error parseError(Response<?> response) {
        Converter<ResponseBody, Error> converter =
                CCIPClient.getRetrofit().responseBodyConverter(Error.class, new Annotation[0]);

        Error error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new Error();
        }

        return error;
    }
}
