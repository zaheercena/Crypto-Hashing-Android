package com.zaheercena.arul.hashing;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;

//import android.os.Bundle;

import android.util.Log;

import android.view.Menu;

import android.view.MenuItem;



import java.io.UnsupportedEncodingException;



import java.security.MessageDigest;



import java.security.NoSuchAlgorithmException;



//import android.app.Activity;



//import android.content.Context;



import android.view.View;



import android.view.inputmethod.InputMethodManager;



import android.widget.Button;



import android.widget.EditText;



import android.widget.ImageButton;



import android.widget.TableLayout;



import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
    ImageButton hashing, compare, filechk, hash_out, compare_out, back1, back2;
    TextView t1, t2, t3, hash_text, compare_result, md5_result, sha1_result, sha256_result, sha384_result, sha512_result;
    Button md5_btn, sha1_btn, sha256_btn, sha384_btn, sha512_btn;
    EditText inputText, compareText1, compareText2;
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        hashing = (ImageButton) findViewById(R.id.hash_btn);
        compare = (ImageButton) findViewById(R.id.compare_btn);
    }

    public void hash_click(View view) {
        setContentView(R.layout.hash);
        t1 = (TextView) findViewById(R.id.tv1);
        inputText = (EditText) findViewById(R.id.inputText);
        hash_text = (TextView) findViewById(R.id.tv2);
        md5_result = (TextView) findViewById(R.id.md5_result);
        sha1_result = (TextView) findViewById(R.id.sha1_result);
        sha256_result = (TextView) findViewById(R.id.sha256_result);
        sha384_result = (TextView) findViewById(R.id.sha384_result);
        sha512_result = (TextView) findViewById(R.id.sha512_result);
        hash_out = (ImageButton) findViewById(R.id.hashresult);
        back1 = (ImageButton) findViewById(R.id.back1);
        table = (TableLayout) findViewById(R.id.TableLayout);
        table.setVisibility(TableLayout.INVISIBLE);
    }



    public void hashresult_click(View view) throws NoSuchAlgorithmException,

            UnsupportedEncodingException {



        byte[] input, output1, output2, output3, output4, output5;



        // create hash code



        input = inputText.getText().toString().getBytes();



        Log.i("VINH INPUT TEXT", inputText.getText().toString());

        // MD5



        MessageDigest md5 = MessageDigest.getInstance("MD5");



        md5.reset();



        md5.update(input);



        output1 = md5.digest();



        // create hex output



        StringBuffer hexString1 = new StringBuffer();



        for (int i = 0; i < output1.length; i++)



            hexString1.append(Integer.toHexString(0xFF & output1[i]));



        md5_result.setText(hexString1.toString());

        Log.i("VINH MD5 OUTPUT ", hexString1.toString());

        // SHA-1



        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");



        sha1.reset();



        sha1.update(input);



        output2 = sha1.digest();



        // create hex output



        StringBuffer hexString2 = new StringBuffer();



        for (int i = 0; i < output2.length; i++)



            hexString2.append(Integer.toHexString(0xFF & output2[i]));



        sha1_result.setText(hexString2.toString());

        Log.i("VINH SHA1 OUTPUT ", hexString2.toString());

        // SHA-256



        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");



        sha256.reset();



        sha256.update(input);



        output3 = sha256.digest();



        // create hex output



        StringBuffer hexString3 = new StringBuffer();



        for (int i = 0; i < output3.length; i++)



            hexString3.append(Integer.toHexString(0xFF & output3[i]));



        sha256_result.setText(hexString3.toString());

        Log.i("VINH SHA256 OUTPUT ", hexString3.toString());

        // SHA-384



        MessageDigest sha384 = MessageDigest.getInstance("SHA-384");



        sha384.reset();



        sha384.update(input);



        output4 = sha384.digest();



        // create hex output



        StringBuffer hexString4 = new StringBuffer();



        for (int i = 0; i < output4.length; i++)



            hexString4.append(Integer.toHexString(0xFF & output4[i]));



        sha384_result.setText(hexString4.toString());



        Log.i("VINH SHA384 OUTPUT ", hexString4.toString());

        // SHA-512



        MessageDigest sha512 = MessageDigest.getInstance("SHA-512");



        sha512.reset();



        sha512.update(input);



        output5 = sha512.digest();



        // create hex output



        StringBuffer hexString5 = new StringBuffer();



        for (int i = 0; i < output5.length; i++)



            hexString5.append(Integer.toHexString(0xFF & output5[i]));



        sha512_result.setText(hexString5.toString());

        Log.i("VINH SHA512 OUTPUT ", hexString5.toString());

        table.setVisibility(TableLayout.VISIBLE);



    }



    // compare function



    public void compare_click(View view)



    {



        setContentView(R.layout.compare);



        t2 = (TextView) findViewById(R.id.compare_tv1);



        t3 = (TextView) findViewById(R.id.compare_tv2);



        compareText1 = (EditText) findViewById(R.id.compare_et1);



        compareText2 = (EditText) findViewById(R.id.compare_et2);



        compare_result = (TextView) findViewById(R.id.compare_result);



        compare_out = (ImageButton) findViewById(R.id.compare);



        back2 = (ImageButton) findViewById(R.id.back2);



    }



    public void compareresult_click(View view) throws NoSuchAlgorithmException,

            UnsupportedEncodingException



    {



        byte[] input1, input2, output1, output2;



        input1 = compareText1.getText().toString().getBytes();



        input2 = compareText2.getText().toString().getBytes();



        MessageDigest md1 = MessageDigest.getInstance("SHA-256");



        md1.reset();



        md1.update(input1);



        output1 = md1.digest();



        StringBuffer hexString1 = new StringBuffer();



        for (int i = 0; i < output1.length; i++)



            hexString1.append(Integer.toHexString(0xFF & output1[i]));



        MessageDigest md2 = MessageDigest.getInstance("SHA-256");



        md2.reset();



        md2.update(input2);



        output2 = md2.digest();



        StringBuffer hexString2 = new StringBuffer();



        for (int i = 0; i < output1.length; i++)



            hexString2.append(Integer.toHexString(0xFF & output2[i]));



        boolean bln = hexString1.toString().equals(hexString2.toString());



        if (bln)



            compare_result.setText("These two messages are same!" +



                    "\n\n The SHA-256 code for Message 1 is: \n"

                    + hexString1.toString() +



                    "\n\n The SHA-256 code for Message 2 is: \n"

                    + hexString2.toString());



        else



            compare_result.setText("These two messages are different!" +



                    "\n\n The SHA-256 code for Message 1 is: \n"

                    + hexString1.toString() +



                    "\n\n The SHA-256 code for Message 2 is: \n"

                    + hexString2.toString());



    }



    public void back(View view)



    {



        setContentView(R.layout.main);



        hashing = (ImageButton) findViewById(R.id.hash_btn);



        compare = (ImageButton) findViewById(R.id.compare_btn);



    }



    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        //getMenuInflater().inflate(R.menu.hashing, menu);

        return true;

    }



    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will

        // automatically handle clicks on the Home/Up button, so long

        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        if (id == R.id.action_settings) {

            return true;

        }

        return super.onOptionsItemSelected(item);

    }

}