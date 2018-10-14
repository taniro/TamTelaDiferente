package br.ufrn.eaj.tads.tamteladiferente;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        //if device is a tablet, set phoneDevice to false
        boolean ehTelefone = true;

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            ehTelefone = false; // not a phone-sized device
        }

        // if running on phone-sized device, allow only portrait orientation
        if (ehTelefone) {
            Log.i("TESTE", "Mudando a orientação para retrato, pois é telefone");

            //mudar a rotação de tela para RETRATO, independente da posição do dispositivo
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        try{
            //necessário carregar o viewpager, para apresentar
            ViewPager vp =  findViewById(R.id.viewPager);
            PagerAdapter pa = new TabsAdapter(getSupportFragmentManager());

            vp.setAdapter(pa);
            TabLayout tabLayout = findViewById(R.id.tab);
            tabLayout.setupWithViewPager(vp);
        }catch (NullPointerException e){

        }
    }
}
