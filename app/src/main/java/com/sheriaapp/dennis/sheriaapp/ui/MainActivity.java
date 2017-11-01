package com.sheriaapp.dennis.sheriaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.sheriaapp.dennis.sheriaapp.R;
import com.sheriaapp.dennis.sheriaapp.ui.Business.BusinessActivity;
import com.sheriaapp.dennis.sheriaapp.ui.Court.CourtProcess;
import com.sheriaapp.dennis.sheriaapp.ui.Employees.Employee;
import com.sheriaapp.dennis.sheriaapp.ui.Land.Land;
import com.sheriaapp.dennis.sheriaapp.ui.Marriage.Marriage;
import com.sheriaapp.dennis.sheriaapp.ui.Police.Police;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.chatWithBot)Button ChatBot;
    @Bind(R.id.card_business) CardView myBusiness;
    @Bind(R.id.card_land)
    CardView myLand;
    @Bind(R.id.card_court) CardView myCourt;
    @Bind(R.id.card_marriage) CardView myMarriage;
    @Bind(R.id.card_employment) CardView myEmployment;
    @Bind(R.id.card_police) CardView myPolice;
    private static final int RC_SIGN_IN = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() == null) {
            // not signed in
            startActivityForResult(
                    // Get an instance of AuthUI based on the default app
                    AuthUI.getInstance().createSignInIntentBuilder()
                            .setAvailableProviders(
                                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                            .build(),
                    RC_SIGN_IN);
        } else {
            Toast.makeText(this,
                    "Welcome " + FirebaseAuth.getInstance()
                            .getCurrentUser()
                            .getDisplayName(),
                    Toast.LENGTH_LONG)
                    .show();
            myBusiness.setOnClickListener(this);
            myLand.setOnClickListener(this);
            myCourt.setOnClickListener(this);
            myMarriage.setOnClickListener(this);
            myEmployment.setOnClickListener(this);
            myPolice.setOnClickListener(this);
            ChatBot.setOnClickListener(this);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this,
                        "Successfully signed in. Welcome!",
                        Toast.LENGTH_LONG)
                        .show();



            } else {
                Toast.makeText(this,
                        "We couldn't sign you in. Please try again later.",
                        Toast.LENGTH_LONG)
                        .show();
            }
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.searchmenu, menu);
        getMenuInflater().inflate(R.menu.signout, menu);
        MenuItem menuItem = menu.findItem(R.id.searchLaws);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String User = query;
                Intent intent = new Intent(MainActivity.this, ListOfLaws.class);
                intent.putExtra("User", User);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return  super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_sign_out) {
            AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this,
                                    "You have been signed out.",
                                    Toast.LENGTH_LONG)
                                    .show();
                            finish();
                        }
                    });
        }if(item.getGroupId() == R.id.find_a_lawyer){
            Intent intent = new Intent(MainActivity.this, FindLawyer.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == myBusiness){
            Intent intent = new Intent(MainActivity.this, BusinessActivity.class);
            startActivity(intent);
        }
        if (view==myLand){
            Intent intent = new Intent(MainActivity.this,Land.class);
            startActivity(intent);
        }
        if (view == ChatBot){
            Intent intent = new Intent(MainActivity.this, Disclaimer.class);
            startActivity(intent);
        }
        if (view==myPolice){
            Intent intent = new Intent(MainActivity.this,Police.class);
            startActivity(intent);
        }
        if (view==myCourt){
            Intent intent = new Intent(MainActivity.this,CourtProcess.class);

            startActivity(intent);
        }
        if (view==myEmployment){
            Intent intent = new Intent(MainActivity.this,Employee.class);
            startActivity(intent);
        }
        if (view==myMarriage){
            Intent intent = new Intent(MainActivity.this,Marriage.class);
            startActivity(intent);
        }



    }

}
