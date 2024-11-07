package com.rpl2jumat.travelpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.rpl2jumat.travelpal.model.BaseResponse;
import com.rpl2jumat.travelpal.request.BaseApiService;
import com.rpl2jumat.travelpal.request.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    private Context mContext;
    private BaseApiService mApiService;

    private Button statusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mContext = this;
        mApiService = UtilsApi.getApiService();

        statusButton = findViewById(R.id.status_button);

        statusButton.setOnClickListener(v -> handleGetStatus());
    }

    private void handleGetStatus() {
        mApiService.getStatus().enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(mContext, "Application error", Toast.LENGTH_SHORT).show();
                    return;
                }

                BaseResponse<String> res = response.body();

                if (res.payload != null) {
                    Toast.makeText(mContext, res.message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "something went wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                Toast.makeText(mContext, "Problem with server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}