package ir.dyalysis.dialysis.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.muddzdev.styleabletoast.StyleableToast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

import ir.dyalysis.dialysis.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener
{
    //Variable
    private int STORAGE_PERMISSION_CODE = 1;
    static final float END_SCALE = 0.7f;
    private static final int TIME_INTERVAL = 2000;
    private boolean doubleBackToExitPressed = false;
    ImageView menuImage;
    private CardView kidneyCard;
    private CardView dialysisCard;
    private CardView veinCard;
    private CardView nourishCard;
    private CardView drugCard;
    private CardView labCard;
    private CardView sportCard;
    LinearLayout contentView;
    Toolbar toolbar;
    private Dialog dialog;

    //Handler and timer to back pressed
    private Handler handler = new Handler();
    private final Runnable runnable = () ->
    {
        doubleBackToExitPressed = false;
    };

    //Drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Hooks
        menuImage = findViewById(R.id.nav_openDrawer);
        contentView = findViewById(R.id.contentView);
        kidneyCard = findViewById(R.id.kidney);
        dialysisCard = findViewById(R.id.dialysis);
        veinCard = findViewById(R.id.vein);
        nourishCard = findViewById(R.id.nourish);
        drugCard = findViewById(R.id.drug);
        labCard = findViewById(R.id.labValue);
        sportCard = findViewById(R.id.sport);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        //Toolbar
        setSupportActionBar(toolbar);

        //Navigation drawer function
        navigationDrawer();

        //Dialog hooks
        dialog = new Dialog(this);

        //OnClick()
        kidneyCard.setOnClickListener(this);
        dialysisCard.setOnClickListener(this);
        veinCard.setOnClickListener(this);
        nourishCard.setOnClickListener(this);
        drugCard.setOnClickListener(this);
        labCard.setOnClickListener(this);
        sportCard.setOnClickListener(this);
    }

    //OnDestroy method
    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (handler != null)
        {
            handler.removeCallbacks(runnable);
        }
    }
    //Navigation drawer methods
    @Override
    public void onBackPressed()
    {
        //check drawer layout open or close
        if (drawerLayout.isDrawerVisible(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            //if user clicking twice on back button finish activity ...
            if (doubleBackToExitPressed)
            {
                super.onBackPressed();
                finishAffinity();
            }
            this.doubleBackToExitPressed = true;
            StyleableToast.makeText(getApplicationContext(), "لطفا کلید بازگشت را مجددا فشار دهید!", Toast.LENGTH_LONG, R.style.toastTheme).show();
            handler.postDelayed(runnable, TIME_INTERVAL);
        }
    }
    private void navigationDrawer()
    {
        //Navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        menuImage.setOnClickListener(v ->
        {
            if (drawerLayout.isDrawerVisible(GravityCompat.START))
            {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            else
            {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigateDrawer();
    }
    private void animateNavigateDrawer()
    {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener()
        {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset)
            {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffsetDiff - xOffset;
                contentView.setTranslationX(xTranslation);
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        switch(menuItem.getItemId())
        {
            case R.id.inviteFriends:
                shareApp();
                break;
            case R.id.nav_rating:
                StyleableToast.makeText(getApplicationContext(), "از اپلیکیشن خودتون حمایت کنید", Toast.LENGTH_LONG, R.style.toastTheme).show();
                break;
            case R.id.nav_recentUpdates:
                StyleableToast.makeText(getApplicationContext(), "هنوز برنامه بروز نشده است!", Toast.LENGTH_LONG, R.style.toastTheme).show();
                break;
            case R.id.nav_aboutUs:
                showAboutDialog();
                break;
            case R.id.nav_contactUS:
                showContactDialog();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //Check permission ...
    private void requestStoragePermission()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE))
        {
            new AlertDialog.Builder(this)
                    .setTitle("دسترسی به حافظه")
                    .setMessage("برای دسترسی به این بخش باید اجازه دسترسی به حافظه به برنامه داده شود")
                    .setPositiveButton("تایید", (dialog, which) ->
                            ActivityCompat.requestPermissions(HomeActivity.this,
                                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE))
                    .setNegativeButton("لغو", (dialog, which) ->
                            dialog.dismiss())
                    .create().show();
        }
        else
        {
            ActivityCompat.requestPermissions(HomeActivity.this,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                shareAppMethod();
            }
            else
            {
                StyleableToast.makeText(getApplicationContext(), "اجازه دسترسی داده نشد!", Toast.LENGTH_LONG, R.style.toastTheme).show();
            }
        }
    }

    //Show Contact Dialog ...
    private void showContactDialog()
    {
        dialog.setContentView(R.layout.custom_dialog_contact);
        ImageView closeDialog = dialog.findViewById(R.id.close_dialog_contact);
        closeDialog.setOnClickListener(v ->
                dialog.dismiss());
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button callButton = dialog.findViewById(R.id.call);
        Button mailButton = dialog.findViewById(R.id.mail);
        callButton.setOnClickListener(v ->
        {
            Uri number = Uri.parse("tel:+989129570184");
            Intent intent = new Intent(Intent.ACTION_DIAL, number);
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
            }
        });
        mailButton.setOnClickListener(v ->
        {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"Hosseini.h8680@yahoo.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "گزارش مشکلات و ارتباط با ما");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "");
            try
            {
                startActivity(Intent.createChooser(emailIntent, "ارسال ایمیل از طریق ..."));
            }
            catch (android.content.ActivityNotFoundException ex)
            {
                StyleableToast.makeText(getApplicationContext(), "هیچ کلاینتی برای ارسال ایمیل پیدا نشد",
                        Toast.LENGTH_SHORT, R.style.toastTheme).show();
            }
        });
        dialog.show();
    }

    //Show about dialog ...
    private void showAboutDialog()
    {
        dialog.setContentView(R.layout.custom_dialog);
        ImageView closeDialog = dialog.findViewById(R.id.close_dialog);
        closeDialog.setOnClickListener(v ->
                dialog.dismiss());
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    //Share App function
    private void shareApp()
    {
        if (ContextCompat.checkSelfPermission(HomeActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            requestStoragePermission();
        }
        else
        {
            shareAppMethod();
        }
    }
    private void shareAppMethod()
    {
        try
        {
            //Get application info
            ApplicationInfo app = getApplicationContext().getApplicationInfo();
            String filePath = app.sourceDir;

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.setType("*/*");

            File originalApk = new File(filePath);
            File tempFile = new File(getExternalCacheDir() + "/ExtractedApk");
            //If directory doesn't exists create new
            if (!tempFile.isDirectory())
                if (!tempFile.mkdirs())
                    return;
            tempFile = new File(tempFile.getPath() + "/" + getString(app.labelRes).replace(" ","").toLowerCase() + ".apk");
            if (!tempFile.exists())
            {
                if (!tempFile.createNewFile())
                {
                    return;
                }
            }
            InputStream in = new FileInputStream(originalApk);
            OutputStream out = new FileOutputStream(tempFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0)
            {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            // open share window
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
            startActivity(Intent.createChooser(intent, "اشتراک گذاری با:"));
        }
        catch (Exception e)
        {
            String message = "لینک مستقیم دانلود برنامه:" + "\n" + "https://8upload.ir/uploads/f357829025.apk";
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            intent.setType("text/plain");

            Intent chooser = Intent.createChooser(intent, "به اشتراک گذاری از طریق:");
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(chooser);
            }
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v)
    {
        Intent baseActivity = new Intent(HomeActivity.this, BaseActivity.class);
        Intent infoActivity = new Intent(HomeActivity.this, InfoActivity.class);
        switch (v.getId())
        {
            case R.id.kidney:
                baseActivity.putExtra("name", "kidney");
                startActivity(baseActivity);
                break;
            case R.id.dialysis:
                baseActivity.putExtra("name", "dialysis");
                startActivity(baseActivity);
                break;
            case R.id.vein:
                baseActivity.putExtra("name", "vein");
                startActivity(baseActivity);
                break;
            case R.id.nourish:
                baseActivity.putExtra("name", "nourish");
                startActivity(baseActivity);
                break;
            case R.id.drug:
                baseActivity.putExtra("name", "drug");
                startActivity(baseActivity);
                break;
            case R.id.labValue:
                infoActivity.putExtra("name", "labValue");
                startActivity(infoActivity);
                break;
            case R.id.sport:
                infoActivity.putExtra("name", "sport");
                startActivity(infoActivity);
                break;
            default:
                break;
        }
    }
}
