package com.dimas.projectakhirku.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dimas.projectakhirku.R;
import com.santalu.maskedittext.MaskEditText;

import java.text.NumberFormat;
import java.util.Locale;

public class DashboardFragment extends Fragment {
    String varietas;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final MaskEditText modal = root.findViewById(R.id.modal);
        final Spinner spinner = root.findViewById(R.id.spinner_jenis);
        final EditText jumlah = root.findViewById(R.id.jumlah);
        final EditText panen = root.findViewById(R.id.panen);
        final EditText omzet = root.findViewById(R.id.omzet);
        final Button hitung = root.findViewById(R.id.button);
        final Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        final String madil = modal.getRawText();
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (madil != null){
                    varietas = spinner.getSelectedItem().toString();
                    int finalmodal = Integer.parseInt(modal.getRawText());
                    if (varietas.equals("Sweet Charlie")) {
                        int bibit = finalmodal / 2800;
                        String finalbibit = String.valueOf(bibit);
                        jumlah.setText("±" + finalbibit + " bibit");
                        int hitungpanen = 150 * bibit;
                        String finalpanen = String.valueOf(hitungpanen);
                        panen.setText("±" + finalpanen + " gram");
                        int hitungomzet = (hitungpanen / 100) * 36500;
                        omzet.setText("±" + formatRupiah.format((double) hitungomzet));
                    }if (varietas.equals("Oso Grande")){
                            int bibit = finalmodal / 2300;
                            String finalbibit = String.valueOf(bibit);
                            jumlah.setText("±" + finalbibit + " bibit");
                            int hitungpanen = 250 * bibit;
                            String finalpanen = String.valueOf(hitungpanen);
                            panen.setText("±" + finalpanen + " gram");
                            int hitungomzet = (hitungpanen / 200) * 35000;
                            omzet.setText("±" + formatRupiah.format((double) hitungomzet));
                        }if (varietas.equals("Tristan")){
                            int bibit = finalmodal / 2500;
                            String finalbibit = String.valueOf(bibit);
                            jumlah.setText("±" + finalbibit + " bibit");
                            int hitungpanen = 150 * bibit;
                            String finalpanen = String.valueOf(hitungpanen);
                            panen.setText("±" + finalpanen + " gram");
                            int hitungomzet = (hitungpanen / 100) * 6000;
                            omzet.setText("±" + formatRupiah.format((double) hitungomzet));
                        }if (varietas.equals("Rosalinda")){
                            int bibit = finalmodal / 5000;
                            String finalbibit = String.valueOf(bibit);
                            jumlah.setText("±" + finalbibit + " bibit");
                            int hitungpanen = 300 * bibit;
                            String finalpanen = String.valueOf(hitungpanen);
                            panen.setText("±" + finalpanen + " gram");
                            int hitungomzet = (hitungpanen / 100) * 40000;
                            omzet.setText("±" + formatRupiah.format((double) hitungomzet));
                        }if (varietas.equals("Nyoho")){
                            int bibit = finalmodal / 1500;
                            String finalbibit = String.valueOf(bibit);
                            jumlah.setText("±" + finalbibit + " bibit");
                            int hitungpanen = 150 * bibit;
                            String finalpanen = String.valueOf(hitungpanen);
                            panen.setText("±" + finalpanen + " gram");
                            int hitungomzet = (hitungpanen / 100) * 6000;
                            omzet.setText("±" + formatRupiah.format((double) hitungomzet));
                        }
                    }
                }catch (Exception E){
                Toast.makeText(getActivity().getApplicationContext(), "Masukkan Modal dengan Benar ", Toast.LENGTH_LONG).show();
            }
            }
        });
        return root;
    }
}
