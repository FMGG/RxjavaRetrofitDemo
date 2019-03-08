package com.czj.androiddesignpatterns.network.factory;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import io.reactivex.annotations.Nullable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

public class MyGsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson mGson;
    private final TypeAdapter<T> mAdapter;

    public MyGsonRequestBodyConverter(Gson gson,TypeAdapter<T> typeAdapter){
        mGson = gson;
        mAdapter = typeAdapter;
    }

    @Nullable
    @Override
    public RequestBody convert(T value) throws IOException {
        Buffer buffer = new Buffer();
        Writer writer = new OutputStreamWriter(buffer.outputStream(),UTF_8);
        JsonWriter jsonWriter = mGson.newJsonWriter(writer);
        mAdapter.write(jsonWriter,value);
        jsonWriter.close();
        return RequestBody.create(MEDIA_TYPE,buffer.readByteString());
    }
}
