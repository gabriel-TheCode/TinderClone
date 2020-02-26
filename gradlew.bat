/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.grafika;

import android.opengl.GLES20;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;

import com.android.grafika.gles.Drawable2d;
import com.android.grafika.gles.EglCore;
import com.android.grafika.gles.GlUtil;
import com.android.grafika.gles.OffscreenSurface;
import com.android.grafika.gles.Sprite2d;
import com.android.grafika.gles.Texture2dProgram;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * An unscientific test of texture upload speed.
 */
public class TextureUploadActivity extends Activity {
    private static final String TAG = MainActivity.TAG;

    // Texture width/height.
    private static final int WIDTH = 512;       // must be power of 2
    private static final int HEIGHT = 512;
    private static final int ITERATIONS = 10;   // 10 iterations...
    private static final int TEX_PER_ITER = 8;  // ...uploading 8 textures per iteration

    private volatile boolean mIsCanceled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texture_upload);
    }

    /**
     * Sets the text in the message field.
     */
    void setM