package com.dimas.projectakhirku.ui.notifications;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dimas.projectakhirku.R;

public class NotificationsFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final Button bAbout = (Button) root.findViewById(R.id.about);
        Button bHelp = (Button) root.findViewById(R.id.bantuan);
        bAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.about);
                dialog.setTitle("Info Aplikasi");

                TextView tek1 = (TextView) dialog.findViewById(R.id.tek1);
                ImageView logo = (ImageView) dialog.findViewById(R.id.logo);
                TextView tek2 = (TextView) dialog.findViewById(R.id.tek2);
                TextView tek3 = (TextView) dialog.findViewById(R.id.tek3);
                TextView tek5 = (TextView) dialog.findViewById(R.id.tek5);
                tek5.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stiki.ac.id/"));
                        startActivity(intent);
                    }
                });
                TextView tek4 = (TextView) dialog.findViewById(R.id.tek4);
                tek4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:dimasdwi340@gmail.com"));
                        startActivity(intent);
                    }
                });
                Button btok = (Button) dialog.findViewById(R.id.btok);
                btok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }catch (Exception E){
                    Toast.makeText(getActivity().getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
                }
            }
        });
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.bantuan);
                    dialog.setTitle("Bantuan");

                    TextView tek1 = (TextView) dialog.findViewById(R.id.tek1);
                    ImageView logo = (ImageView) dialog.findViewById(R.id.logo);
                    TextView tek2 = (TextView) dialog.findViewById(R.id.tek2);
                    TextView tek3 = (TextView) dialog.findViewById(R.id.tek3);
                    TextView tek4 = (TextView) dialog.findViewById(R.id.tek4);
                    tek4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:dimasdwi340@gmail.com"));
                            startActivity(intent);
                        }
                    });
                    Button btok = (Button) dialog.findViewById(R.id.btok);
                    btok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }catch (Exception E){
                    Toast.makeText(getActivity().getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }


}



