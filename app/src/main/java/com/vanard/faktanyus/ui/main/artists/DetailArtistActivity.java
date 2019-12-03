package com.vanard.faktanyus.ui.main.artists;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;

import com.facebook.appevents.AppEventsConstants;
import com.squareup.picasso.Picasso;
import com.vanard.faktanyus.R;
import com.vanard.faktanyus.network.ApiClient;
import com.vanard.faktanyus.network.ApiService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* renamed from: DetailArtistActivity */
public class DetailArtistActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public TextView fakta_tanggal_lahir;
    /* access modifiers changed from: private */
    public ImageView foto_artist;
    /* access modifiers changed from: private */
    public TextView name_artist;
    private ApiService service;
    /* access modifiers changed from: private */
    public TextView tanggal_lahir_artist;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_detail_artist);
        this.name_artist = (TextView) findViewById(R.id.name_artist);
        this.tanggal_lahir_artist = (TextView) findViewById(R.id.tanggal_lahir_artist);
        this.fakta_tanggal_lahir = (TextView) findViewById(R.id.fakta_tanggal_lahir);
        this.foto_artist = (ImageView) findViewById(R.id.foto_artist);
        int artistId = getIntent().getExtras().getInt("idArtist");
        final String artistFoto = getIntent().getExtras().getString("fotoArtist");
        this.service = (ApiService) ApiClient.getClient(ApiClient.SULTHANI_BASE_URL).create(ApiService.class);
        Call<FaktaArtistResponse> call = this.service.getFaktaArtist(artistId);
        Log.d("TesAPISulthani", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        call.enqueue(new Callback<FaktaArtistResponse>() {
            public void onResponse(Call<FaktaArtistResponse> call, Response<FaktaArtistResponse> response) {
                String str = "TesAPISulthani";
                Log.d(str, ExifInterface.GPS_MEASUREMENT_2D);
                if (response.body() != null) {
                    FaktaArtistResponse dataArtist = response.body();
                    DetailArtistActivity.this.name_artist.setText(dataArtist.getArtistName());
                    DetailArtistActivity.this.tanggal_lahir_artist.setText(dataArtist.getBirthday());
                    DetailArtistActivity.this.fakta_tanggal_lahir.setText(dataArtist.getFact());
                    Picasso.get().load(artistFoto).into(DetailArtistActivity.this.foto_artist);
                    Log.d(str, dataArtist.getArtistName());
                } else if (response.errorBody() != null) {
                    try {
                        Log.d(str, response.errorBody().string());
                        Log.d(str, call.request().url().toString());
                        Log.d(str, "4");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onFailure(Call<FaktaArtistResponse> call, Throwable t) {
                Toast.makeText(DetailArtistActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("TesAPISulthani", "-1");
            }
        });
    }
}
