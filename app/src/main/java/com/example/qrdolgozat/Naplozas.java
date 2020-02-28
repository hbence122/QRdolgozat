package com.example.qrdolgozat;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Naplozas {

    public static void kiiras(String adat) throws IOException {
        String state;
        String szoveges_adat;
        Date datum = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
        String formazottDatum = dateFormat.format(datum);
        szoveges_adat = ""+adat+", "+formazottDatum;

        state = Environment.getExternalStorageState();

        if (state.equals(Environment.MEDIA_MOUNTED)){
            File file = new File(Environment.getExternalStorageDirectory(), "scannedCodes.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(szoveges_adat);
            writer.close();
        }
    }
}
