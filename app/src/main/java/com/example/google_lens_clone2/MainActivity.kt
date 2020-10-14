package com.example.google_lens_clone2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.google_lens_clone2.Barcode.Barcode_Activity
import com.example.google_lens_clone2.Face_detect.FaceDetectActivity
import com.example.google_lens_clone2.Labeller.ImageLabellingActivity
import com.example.google_lens_clone2.textRecog.TextRecognitionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        @JvmStatic val PHOTO_REQ_CODE=234
        @JvmStatic val ExtraData="data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTakeEXPhoto.setOnClickListener {
            val takePhotoIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePhotoIntent, PHOTO_REQ_CODE)
        }
        btnBarcodeActivity.setOnClickListener {
            startActivity(Intent(this,Barcode_Activity::class.java))
        }
        btnCameraActivity.setOnClickListener {
            startActivity(Intent(this,CameraActivity::class.java))

        }
        btnFaceDetectActivity.setOnClickListener {
            startActivity(Intent(this,FaceDetectActivity::class.java))
        }
        btnimageLabellerActivity.setOnClickListener {
            startActivity(Intent(this,ImageLabellingActivity::class.java))
        }
        btnTextActivity.setOnClickListener {
            startActivity(Intent(this,TextRecognitionActivity::class.java))
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PHOTO_REQ_CODE) {
            val imageBitmap = data?.extras?.get(ExtraData) as Bitmap
            imgThumb.setImageBitmap(imageBitmap)
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}