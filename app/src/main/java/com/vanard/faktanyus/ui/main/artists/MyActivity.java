package com.vanard.faktanyus.ui.main.artists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.facebook.appevents.AppEventsConstants;
import com.squareup.picasso.Picasso;
import com.vanard.faktanyus.R;
import com.vanard.faktanyus.network.ApiClient;
import com.vanard.faktanyus.network.ApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* renamed from: MyActivity */
public class MyActivity extends Activity {
    private LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public Adapter mAdapter;
    /* access modifiers changed from: private */
    public List<ArtistItem> myDataset;
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;
    private ApiService service;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        this.recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        this.recyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.service = (ApiService) ApiClient.getClient(ApiClient.SULTHANI_BASE_URL).create(ApiService.class);
        String str = "TesAPISulthani";
        Log.d(str, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Call<FavoriteArtistsResponse> call = this.service.getArtistFavorite();
        Log.d(str, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        call.enqueue(new Callback<FavoriteArtistsResponse>() {
            public void onResponse(Call<FavoriteArtistsResponse> call, Response<FavoriteArtistsResponse> response) {
                String str = "TesAPISulthani";
                Log.d(str, ExifInterface.GPS_MEASUREMENT_2D);
                if (response.body() != null) {
                    MyActivity.this.myDataset = response.body().getData();
                    MyActivity myActivity = MyActivity.this;
                    myActivity.mAdapter = new RecyclerViewAdapter(myActivity.myDataset);
                    MyActivity.this.recyclerView.setAdapter(MyActivity.this.mAdapter);
                    Log.d(str, ExifInterface.GPS_MEASUREMENT_3D);
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

            public void onFailure(Call<FavoriteArtistsResponse> call, Throwable t) {
                Toast.makeText(MyActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("TesAPISulthani", "-1");
            }
        });
    }
}

class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.ViewHolder> {
    /* access modifiers changed from: private */
    public List<ArtistItem> artistData;

    /* renamed from: com.vanard.faktanyus.ui.main.artists.RecyclerViewAdapter$ViewHolder */
    /* compiled from: MyActivity */
    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView icon;
        public TextView tvSubtitle;
        public TextView tvTitle;

        public ViewHolder(View v) {
            super(v);
            this.tvTitle = (TextView) v.findViewById(R.id.tv_title);
            this.tvSubtitle = (TextView) v.findViewById(R.id.tv_subtitle);
            this.icon = (ImageView) v.findViewById(R.id.icon);
            v.setOnClickListener(this);
        }

        public void onClick(View view) {
            ArtistItem clicked = (ArtistItem) RecyclerViewAdapter.this.artistData.get(getAdapterPosition());
            Log.d("TesKartuKlik", clicked.getName());
            Intent intentArtist = new Intent(view.getContext(), DetailArtistActivity.class);
            intentArtist.putExtra("idArtist", clicked.getId());
            intentArtist.putExtra("fotoArtist", clicked.getProfile_path());
            view.getContext().startActivity(intentArtist);
        }
    }

    public RecyclerViewAdapter(List<ArtistItem> inputData) {
        this.artistData = inputData;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardartist_layout, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        if (((ArtistItem) this.artistData.get(position)).getName().equals("Kim Soo-ah")) {
            ((ArtistItem) this.artistData.get(position)).setProfile_path("https://www.hancinema.net/photos/posterphoto344835.jpg");
        }
        String name = ((ArtistItem) this.artistData.get(position)).getName();
        String artistFoto = ((ArtistItem) this.artistData.get(position)).getProfile_path();
        String profesi = ((ArtistItem) this.artistData.get(position)).getKnown_for_department();
        holder.tvTitle.setText(name);
        holder.tvSubtitle.setText(profesi);
        Picasso.get().load(artistFoto).into(holder.icon);
    }

    public int getItemCount() {
        return this.artistData.size();
    }
}
