package com.thecode.tinderclone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thecode.tinderclone.R;

public class StartActivity extends AppCompatActivity {

    Button btnFacebook, btnPhoneValidation;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mContext = this;

        btnFacebook = findViewById(R.id.btn_facebook_connect);
        btnPhoneValidation = findViewById(R.id.btn_number_connect);

        btnPhoneValidation.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, PhoneVerificationActivity.class);
            startActivity(intent);
            finish();
        });



    }




    /*public void setSpannableStringText() {

        SpannableString ss = new SpannableString(getResources().getString(R.string.start_text_advice));
        ClickableSpan clickableSpanTerms = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                //startActivity(new Intent(StartActivity.this, TermsActivity.class));
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ClickableSpan clickableSpanPolicy = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                //startActivity(new Intent(StartActivity.this, PrivacyPolicyActivity.class));
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ss.setSpan(clickableSpanTerms, 51, 63, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpanPolicy, 68, 82, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ss.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 51, 63, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 68, 82, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = findViewById(R.id.text_policy_terms);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);

    }*/
}
