package com.example.google_lens_clone2.Face_detect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.camera.core.ImageAnalysis
import androidx.core.content.ContextCompat
import com.example.google_lens_clone2.BaseLensActivity

class FaceDetectActivity : BaseLensActivity() {
    override val imageAnalyzer=FaceDetectAnalyser()
    override fun startScanner() {
    startFaceDetect()

    }
    private fun startFaceDetect(){
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer


        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}